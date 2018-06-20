package com.company.core.table;

import com.company.core.dao.TblAlismsConfigDAO;
import com.company.core.dao.TblSmsRouteDAO;
import com.company.core.mapper.TblAlismsConfigDAOMapper;
import com.company.core.mapper.TblSmsRouteDAOMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: online
 * @description: 阿里云渠道配置
 * @author: weiwankun
 * @create: 2018-06-02 10:55
 **/
@Slf4j
@Service
public class TblAlismsConfigSQL {
    
    @Autowired
    TblAlismsConfigDAOMapper tblAlismsConfigDAOMapper;
    
    public TblAlismsConfigDAO get(String smsChannelId){
        return tblAlismsConfigDAOMapper.selectByPrimaryKey(smsChannelId);
    }
    
    
}
