package com.springapp.mvc.service.impl;

import com.springapp.mvc.dao.UserPointMapper;
import com.springapp.mvc.domain.UserPoint;
import com.springapp.mvc.domain.UserPointExample;
import com.springapp.mvc.service.RedeemCouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author: Yang Yifan
 * MisId: yangyifan03
 * Project: transaction-demo
 * Date: 7/13/15
 * Time: 3:22 PM
 */
@Service("redeemCouponService")
public class RedeemCouponServiceImpl implements RedeemCouponService {
    private static final Logger SERVICE_LOG = LoggerFactory.getLogger("service");
    @Autowired
    public UserPointMapper userPointMapper;

    @Override
    @Transactional
    public boolean redeemCoupon(Integer userId) {
        UserPointExample example = new UserPointExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<UserPoint> userPoint = userPointMapper.selectByExample(example);

        SERVICE_LOG.info("UserPoint is {}", userPoint.get(0));

        return userPoint.isEmpty();
    }
}
