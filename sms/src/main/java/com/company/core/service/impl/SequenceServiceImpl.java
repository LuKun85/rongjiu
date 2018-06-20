package com.company.core.service.impl;

import com.company.core.mapper.custom.SequenceMapper;
import com.company.core.service.SequenceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: online
 * @description:  系统sequence
 * @author: weiwankun
 * @create: 2018-05-30 14:34
 **/
@Slf4j
@Service
public class SequenceServiceImpl implements SequenceService {
    
    @Autowired
    SequenceMapper sequenceMapper;
    
    @Override
    public String getSmsOrderId() {
        int i = sequenceMapper.getSequenceNextVal("SMS_ORDER_ID");
        String str = StringUtils.leftPad(String.valueOf(i), 12, "0");
        return str;
    }
    
}
