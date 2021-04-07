package com.pie.springcloud.service;

import com.pie.springcloud.dao.PaymentDao;
import com.pie.springcloud.model.Payment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ Author     ：longlong
 * @ Date       ：Created in 15:45 2021/4/7
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;
    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
