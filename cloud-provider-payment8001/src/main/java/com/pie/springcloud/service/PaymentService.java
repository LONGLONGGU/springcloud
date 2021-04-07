package com.pie.springcloud.service;

import com.pie.springcloud.model.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @ Author     ：longlong
 * @ Date       ：Created in 15:44 2021/4/7
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
