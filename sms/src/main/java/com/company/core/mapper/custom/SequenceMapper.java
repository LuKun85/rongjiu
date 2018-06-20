package com.company.core.mapper.custom;

import org.apache.ibatis.annotations.Param;

public interface SequenceMapper {

     int getSequenceNextVal(@Param("sequenceName") String sequenceName);

}