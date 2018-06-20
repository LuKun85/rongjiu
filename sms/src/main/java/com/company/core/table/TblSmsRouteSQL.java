package com.company.core.table;

import com.company.core.dao.TblSmsRouteDAO;
import com.company.core.mapper.TblSmsRouteDAOMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: online
 * @description: 短信路由表
 * @author: weiwankun
 * @create: 2018-06-02 10:55
 **/
@Slf4j
@Service
public class TblSmsRouteSQL {
    
    @Autowired
    TblSmsRouteDAOMapper tblSmsRouteDAOMapper;
    
    public TblSmsRouteDAO get(String smsCode){
        return tblSmsRouteDAOMapper.selectByPrimaryKey(smsCode);
    }
    
}
