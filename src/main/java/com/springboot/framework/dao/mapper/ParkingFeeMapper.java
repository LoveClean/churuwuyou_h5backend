package com.springboot.framework.dao.mapper;

import com.springboot.framework.dao.pojo.ParkingFee;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;

public interface ParkingFeeMapper extends Mapper<ParkingFee> {
    @Update("UPDATE parking_fee SET money = (money + #{money}) , status = 1 WHERE visitor_apply_id = #{visitorApplyId}")
    int updateByMoneySelective(@Param("visitorApplyId") Integer visitorApplyId, @Param("money") Integer money);
}