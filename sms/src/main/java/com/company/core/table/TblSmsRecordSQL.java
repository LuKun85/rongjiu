package com.company.core.table;

import com.company.core.constant.Constant;
import com.company.core.dao.TblSmsRecordDAO;
import com.company.core.dao.TblSmsRouteDAO;
import com.company.core.domain.CommonRequestBo;
import com.company.core.domain.CommonResponseBo;
import com.company.core.mapper.TblSmsRecordDAOMapper;
import com.company.core.mapper.TblSmsRouteDAOMapper;
import com.company.core.service.SequenceService;
import com.company.core.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;

/**
 * @program: online
 * @description: 短信记录表
 * @author: weiwankun
 * @create: 2018-06-02 10:55
 **/
@Slf4j
@Service
public class TblSmsRecordSQL {
    
    @Autowired
    TblSmsRecordDAOMapper tblSmsRecordDAOMapper;
    @Autowired
    SequenceService sequenceService;
    
    @Transactional(rollbackFor = Exception.class)
    public void tblSmsRecordCreate(CommonRequestBo commonRequestBo){
        TblSmsRecordDAO tblSmsRecordDAO = new TblSmsRecordDAO();
        tblSmsRecordDAO.setSmsOrderNo(TimeUtil.getCurrentDateTime() + sequenceService.getSmsOrderId());
        tblSmsRecordDAO.setPhoneNumber(commonRequestBo.getSmsPhoneNumber());
        tblSmsRecordDAO.setSmsType(commonRequestBo.getSmsType());
        tblSmsRecordDAO.setSmsChannelCat(commonRequestBo.getSmsChannelCat());
        tblSmsRecordDAO.setSmsChannelId(commonRequestBo.getSmsChannelId());
        tblSmsRecordDAO.setSendDate(TimeUtil.getCurrentDate());
        tblSmsRecordDAO.setSendTime(TimeUtil.getCurrentTime());
        tblSmsRecordDAO.setVerifyDate(TimeUtil.getCurrentDate());
        tblSmsRecordDAO.setVerifyTime(TimeUtil.getCurrentTime());
        tblSmsRecordDAO.setStatus(Constant.STATUS_INITIAL);
        tblSmsRecordDAO.setSendContent("1234");
        tblSmsRecordDAOMapper.insertSelective(tblSmsRecordDAO);
        
        /**返回订单号**/
        commonRequestBo.setSmsOrderId(tblSmsRecordDAO.getSmsOrderNo());
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void tblSmsRecordProcessing(CommonResponseBo commonResponseBo) {
        TblSmsRecordDAO tblSmsRecordDAO = new TblSmsRecordDAO();
        tblSmsRecordDAO.setSmsOrderNo(commonResponseBo.getSmsOrderId());
        tblSmsRecordDAO.setStatus(Constant.STATUS_PROCESSING);
        tblSmsRecordDAOMapper.updateByPrimaryKeySelective(tblSmsRecordDAO);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void tblSmsRecordFailed(CommonResponseBo commonResponseBo) {
        TblSmsRecordDAO tblSmsRecordDAO = new TblSmsRecordDAO();
        tblSmsRecordDAO.setSmsOrderNo(commonResponseBo.getSmsOrderId());
        tblSmsRecordDAO.setStatus(Constant.STATUS_FAIL);
        tblSmsRecordDAOMapper.updateByPrimaryKeySelective(tblSmsRecordDAO);
    }
    
}
