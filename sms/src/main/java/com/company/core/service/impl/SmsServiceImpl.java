package com.company.core.service.impl;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.company.core.constant.NotifyException;
import com.company.core.dao.TblAlismsConfigDAO;
import com.company.core.dao.TblSmsVerifyCodeDAO;
import com.company.core.domain.AliyunSmsRequestBo;
import com.company.core.domain.AliyunSmsTemplicateBo;
import com.company.core.domain.CommonRequestBo;
import com.company.core.domain.CommonResponseBo;
import com.company.core.enums.ErrorRespEnum;
import com.company.core.mapper.custom.SequenceMapper;
import com.company.core.service.BaseService;
import com.company.core.service.SmsService;
import com.company.core.table.TblAlismsConfigSQL;
import com.company.core.table.TblSmsRecordSQL;
import com.company.core.table.TblSmsVerifyCodeSQL;
import com.company.core.util.RandomString;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: online
 * @description: 短信服务实现
 * @author: weiwankun
 * @create: 2018-05-30 14:34
 **/
@Slf4j
@Service
public class SmsServiceImpl implements SmsService {
    
    @Autowired
    BaseService baseService;
    @Autowired
    TblAlismsConfigSQL tblAlismsConfigSQL;
    @Autowired
    TblSmsRecordSQL tblSmsRecordSQL;
    @Autowired
    SequenceMapper sequenceMapper;
    @Autowired
    TblSmsVerifyCodeSQL tblSmsVerifyCodeSQL;
    
    @Override
    public void checkSend(CommonRequestBo commonRequestBo) {
        
        baseService.paramCheckString(commonRequestBo.getSmsCode(), "短信代号不能为空");
        baseService.paramCheckString(commonRequestBo.getSmsType(), "发送短信类型不能为空");
        baseService.paramCheckString(commonRequestBo.getSmsPhoneNumber(), "手机号不能为空");
        baseService.paramCheckString(commonRequestBo.getHost(), "请求Host不能为空");
        
        baseService.paramCheckSmsCode(commonRequestBo);
        baseService.paramCheckSmsType(commonRequestBo);
        baseService.paramCheckPhoneNumber(commonRequestBo.getSmsPhoneNumber());
        
        baseService.paramCheckSmsChannelCat(commonRequestBo);
        baseService.paramCheckSmsChannelId(commonRequestBo);
        
        /**如果是验证码, 检查上次上次发送时间**/
        if("CODE".equals(commonRequestBo.getSmsType())){
            baseService.paramCheckMessageCodeAvaileableAgain(commonRequestBo);
        }
    }
    
    @Override
    public void checkVerify(CommonRequestBo commonRequestBo) {
        
        baseService.paramCheckString(commonRequestBo.getSmsCode(), "短信代号不能为空");
        baseService.paramCheckString(commonRequestBo.getSmsType(), "发送短信类型不能为空");
        baseService.paramCheckString(commonRequestBo.getSmsPhoneNumber(), "手机号不能为空");
        baseService.paramCheckString(commonRequestBo.getMessageCode(), "短信验证码不能为空");
        
        baseService.paramCheckSmsCode(commonRequestBo);
        baseService.paramCheckSmsType(commonRequestBo);
        baseService.paramCheckPhoneNumber(commonRequestBo.getSmsPhoneNumber());
        
    }
    
    @Override
    public void doSend(CommonRequestBo commonRequestBo, CommonResponseBo commonResponseBo) {
        try {
            /**初始短信信息**/
            tblSmsRecordSQL.tblSmsRecordCreate(commonRequestBo);
            
            commonResponseBo.setSmsOrderId(commonRequestBo.getSmsOrderId());
            
            if ("ALIYUN".equals(commonRequestBo.getSmsChannelCat())) {
                AliyunSmsRequestBo aliyunSmsRequestBo = this.formatAliyunSmsRequestBo(commonRequestBo);
                if ("CODE".equals(commonRequestBo.getSmsType())) {
                    /**生成验证码**/
                    this.genMessageCode(commonRequestBo);
                    
                    /**发送内容**/
                    AliyunSmsTemplicateBo aliyunSmsTemplicateBo = new AliyunSmsTemplicateBo();
                    aliyunSmsTemplicateBo.setCode(commonRequestBo.getMessageCode());
                    Gson gson = new Gson();
                    String str = gson.toJson(aliyunSmsTemplicateBo);
                    aliyunSmsRequestBo.setTemplicateParam(str);
                    
                    aliyunSmsRequestBo.setSendOrderNo(commonRequestBo.getSmsOrderId());
                    /**调用阿里发送接口**/
                    this.aliyunSendCode(aliyunSmsRequestBo, commonResponseBo);
                    if (ErrorRespEnum.RESP000000.getRespCode().equals(commonResponseBo.getRespCode())) {
                        /**验证码已发送, 等待验证**/
                        tblSmsRecordSQL.tblSmsRecordProcessing(commonResponseBo);
                        
                        /**录入短信验证记录**/
                        tblSmsVerifyCodeSQL.insert(commonRequestBo);
                        
                    } else {
                        /** 验证码发送失败**/
                        tblSmsRecordSQL.tblSmsRecordFailed(commonResponseBo);
                    }
                }
            }
        } catch (Exception ex) {
            if (ex instanceof NotifyException) {
                throw ex;
            } else {
                throw new NotifyException(ErrorRespEnum.RESP999999, "系统错误");
            }
        }
    }
    
    @Override
    public void doVerify(CommonRequestBo commonRequestBo, CommonResponseBo commonResponseBo) {
        try {
            
            TblSmsVerifyCodeDAO tblSmsVerifyCodeDAO = tblSmsVerifyCodeSQL.get(commonRequestBo);
            if(tblSmsVerifyCodeDAO == null){
                throw new NotifyException(ErrorRespEnum.RESP000010, "请先获取验证码");
            }
            if(StringUtils.isNotBlank(tblSmsVerifyCodeDAO.getVerifyCode())){
                if(tblSmsVerifyCodeDAO.getVerifyCode().equals(commonRequestBo.getMessageCode())){
                    /**验证码正确**/
                    commonResponseBo.setRespCode(ErrorRespEnum.RESP000000.getRespCode());
                    commonResponseBo.setRespMsg("短息验证成功");
                    
                    /**删除验证码记录**/
                    tblSmsVerifyCodeSQL.delte(commonRequestBo);
                    return;
                }
            }
            commonResponseBo.setRespCode(ErrorRespEnum.RESP000009.getRespCode());
            commonResponseBo.setRespMsg("验证码不正确,请重新输入");
        } catch (Exception ex) {
            if (ex instanceof NotifyException) {
                throw ex;
            } else {
                throw new NotifyException(ErrorRespEnum.RESP999999, "系统错误");
            }
        }
    }
    
    
    private AliyunSmsRequestBo formatAliyunSmsRequestBo(CommonRequestBo commonRequestBo) {
        TblAlismsConfigDAO tblAlismsConfigDAO = tblAlismsConfigSQL.get(commonRequestBo.getSmsChannelId());
        AliyunSmsRequestBo aliyunSmsRequestBo = new AliyunSmsRequestBo();
        aliyunSmsRequestBo.setConnectTimeOut(tblAlismsConfigDAO.getConnectTimeout().toString());
        aliyunSmsRequestBo.setReadTimeOut(tblAlismsConfigDAO.getReadTimeout().toString());
        aliyunSmsRequestBo.setSmsAccessKeyId(tblAlismsConfigDAO.getAccessKeyId());
        aliyunSmsRequestBo.setSmsAccessKeySecret(tblAlismsConfigDAO.getAccessKeySecret());
        aliyunSmsRequestBo.setToPhoneNumber(commonRequestBo.getSmsPhoneNumber());
        aliyunSmsRequestBo.setSignName(tblAlismsConfigDAO.getSignName());
        aliyunSmsRequestBo.setTemplicateCode(tblAlismsConfigDAO.getTemplicateCode());
        aliyunSmsRequestBo.setSmsProduct(tblAlismsConfigDAO.getProduct());
        aliyunSmsRequestBo.setSmsDomain(tblAlismsConfigDAO.getDomain());
        
        /**发送内容**/
        AliyunSmsTemplicateBo aliyunSmsTemplicateBo = new AliyunSmsTemplicateBo();
        aliyunSmsTemplicateBo.setCode(commonRequestBo.getMessageCode());
        Gson gson = new Gson();
        String str = gson.toJson(aliyunSmsTemplicateBo);
        aliyunSmsRequestBo.setTemplicateParam(str);
        
        aliyunSmsRequestBo.setSendOrderNo(commonRequestBo.getSmsOrderId());
        return aliyunSmsRequestBo;
    }
    
    private void genMessageCode(CommonRequestBo commonRequestBo) {
        String var = RandomString.genMessageCode(4);
        commonRequestBo.setMessageCode(var);
    }
    
    @Override
    public void aliyunSendCode(AliyunSmsRequestBo aliyunSmsRequestBo, CommonResponseBo commonResponseBo) {
        
        try {
            //可自助调整超时时间
            System.setProperty("sun.net.client.defaultConnectTimeout", aliyunSmsRequestBo.getConnectTimeOut().toString());
            System.setProperty("sun.net.client.defaultReadTimeout", aliyunSmsRequestBo.getReadTimeOut().toString());
            
            //初始化acsClient,暂不支持region化
            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", aliyunSmsRequestBo.getSmsAccessKeyId(), aliyunSmsRequestBo.getSmsAccessKeySecret());
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", aliyunSmsRequestBo.getSmsProduct(), aliyunSmsRequestBo.getSmsDomain());
            IAcsClient acsClient = new DefaultAcsClient(profile);
            
            //组装请求对象-具体描述见控制台-文档部分内容
            SendSmsRequest request = new SendSmsRequest();
            //必填:待发送手机号
            request.setPhoneNumbers(aliyunSmsRequestBo.getToPhoneNumber());
            //必填:短信签名-可在短信控制台中找到
            request.setSignName(aliyunSmsRequestBo.getSignName());
            //必填:短信模板-可在短信控制台中找到
            request.setTemplateCode(aliyunSmsRequestBo.getTemplicateCode());
            //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
            request.setTemplateParam(aliyunSmsRequestBo.getTemplicateParam());
            
            //选填-上行短信扩展码(无特殊需求用户请忽略此字段)
            //request.setSmsUpExtendCode("90997");
            
            //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
            request.setOutId(aliyunSmsRequestBo.getSendOrderNo());
            
            //hint 此处可能会抛出异常，注意catch
            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            log.info("短信发送结果:" + new Gson().toJson(sendSmsResponse));
            if (sendSmsResponse != null && "OK".equals(sendSmsResponse.getCode())) {
                //短信发送成功
                commonResponseBo.setRespCode(ErrorRespEnum.RESP000000.getRespCode());
                commonResponseBo.setRespMsg("短息发送成功");
                commonResponseBo.setRequestId(sendSmsResponse.getRequestId());
                commonResponseBo.setBizId(sendSmsResponse.getBizId());
            } else {
                //短信发送失败
                commonResponseBo.setRespCode(ErrorRespEnum.RESP000007.getRespCode());
                commonResponseBo.setRespMsg("渠道短信发送失败");
                commonResponseBo.setRequestId(sendSmsResponse.getRequestId());
                commonResponseBo.setBizId(sendSmsResponse.getBizId());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            //短信发送失败
            commonResponseBo.setRespCode(ErrorRespEnum.RESP999999.getRespCode());
            commonResponseBo.setRespMsg("短信发送失败:系统错误");
        }
    }
    
    
}
