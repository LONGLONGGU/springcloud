package com.pie.springcloud.dao;

import com.pie.springcloud.model.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ Author     ：longlong
 * @ Date       ：Created in 15:28 2021/4/7
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
