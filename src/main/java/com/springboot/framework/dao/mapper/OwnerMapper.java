package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.pojo.Owner;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

public interface OwnerMapper  extends Mapper<Owner> {
    @Update("UPDATE owner SET wechat_openid = #{wechatOpenid} WHERE phone = #{phone}")
    int updateByPhone(@Param("phone") String phone, @Param("wechatOpenid") String wechatOpenid);
}