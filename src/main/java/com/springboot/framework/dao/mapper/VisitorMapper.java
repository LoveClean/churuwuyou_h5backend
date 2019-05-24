package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.pojo.Visitor;
import tk.mybatis.mapper.common.Mapper;

public interface VisitorMapper  extends Mapper<Visitor> {
//    @Select("SELECT * FROM visitor WHERE status != -1 AND (phone = #{loginKey} OR account = #{loginKey}) AND password = #{password}")
//    Visitor login(@Param("loginKey") String loginKey, @Param("password") String password);
}