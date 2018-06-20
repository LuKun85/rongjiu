package com.company.core.table;

import com.company.core.constant.Constant;
import com.company.core.dao.TblSmsRouteDAO;
import com.company.core.dao.TblSmsVerifyCodeDAO;
import com.company.core.domain.CommonRequestBo;
import com.company.core.mapper.TblSmsRouteDAOMapper;
import com.company.core.mapper.TblSmsVerifyCodeDAOMapper;
import com.company.core.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: online
 * @description: 短信验证码控制表
 * @author: weiwankun
 * @create: 2018-06-02 10:55
 **/
@Slf4j
@Service
public class TblSmsVerifyCodeSQL {
    
    @Autowired
    TblSmsVerifyCodeDAOMapper tblSmsVerifyCodeDAOMapper;
    
    @Transactional(rollbackFor = Exception.class)
    public void insert(CommonRequestBo commonRequestBo){
        TblSmsVerifyCodeDAO tblSmsVerifyCodeDAO = new TblSmsVerifyCodeDAO();
        tblSmsVerifyCodeDAO.setPhoneNumber(commonRequestBo.getSmsPhoneNumber());
        tblSmsVerifyCodeDAO.setVerifyCode(commonRequestBo.getMessageCode());
        tblSmsVerifyCodeDAO.setStatus(Constant.STATUS_PROCESSING);
        tblSmsVerifyCodeDAO.setSendDateTime(TimeUtil.getCurrentDateTime());
        tblSmsVerifyCodeDAO.setExpireDateTime(String.valueOf(Long.parseLong(TimeUtil.getCurrentDateTime()) + 500));
        tblSmsVerifyCodeDAOMapper.deleteByPrimaryKey(tblSmsVerifyCodeDAO.getPhoneNumber());
        tblSmsVerifyCodeDAOMapper.insert(tblSmsVerifyCodeDAO);
    }
    
    public TblSmsVerifyCodeDAO get(CommonRequestBo commonRequestBo){
        return tblSmsVerifyCodeDAOMapper.selectByPrimaryKey(commonRequestBo.getSmsPhoneNumber());
    }
    
    @Transactional(rollbackFor = Exception.class)
    public void delte(CommonRequestBo commonRequestBo){
        tblSmsVerifyCodeDAOMapper.deleteByPrimaryKey(commonRequestBo.getSmsPhoneNumber());
    }
    
}
