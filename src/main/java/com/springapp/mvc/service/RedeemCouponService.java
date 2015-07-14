package com.springapp.mvc.service;

import com.springapp.mvc.exception.MyDatabaseException;

/**
 * Author: Yang Yifan
 * MisId: yangyifan03
 * Project: transaction-demo
 * Date: 7/13/15
 * Time: 3:20 PM
 */
public interface RedeemCouponService {
    String redeemCoupon(Integer userId) throws MyDatabaseException;

}
