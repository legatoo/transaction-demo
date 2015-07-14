package com.springapp.mvc.service.impl;

import com.google.common.base.Function;
import com.springapp.mvc.dao.CouponPoolMapper;
import com.springapp.mvc.dao.UserPointHistoryMapper;
import com.springapp.mvc.dao.UserPointMapper;
import com.springapp.mvc.dao.UserRedeemHistoryMapper;
import com.springapp.mvc.domain.*;
import com.springapp.mvc.exception.MyDatabaseException;
import com.springapp.mvc.service.RedeemCouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Date;
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

    private static Function<CouponPool, Byte> statusFunction  = new Function<CouponPool, Byte>() {
        @Override
        public Byte apply(CouponPool input) {
            return input.getStatus();
        }
    };

    @Autowired
    public UserPointMapper userPointMapper;
    @Autowired
    public UserPointHistoryMapper userPointHistoryMapper;
    @Autowired
    public UserRedeemHistoryMapper userRedeemHistoryMapper;
    @Autowired
    public CouponPoolMapper couponPoolMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String redeemCoupon(Integer userId) throws MyDatabaseException {
        //可以使用这个检查事务是否开启
        String.valueOf(TransactionSynchronizationManager.isActualTransactionActive());

        //这个方法实际上是不能设置事务的开启和关闭
        //TransactionSynchronizationManager.setActualTransactionActive(true);

        UserPointExample example = new UserPointExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<UserPoint> userPoints = userPointMapper.selectByExample(example);

        SERVICE_LOG.info("UserPoint is {}", userPoints.get(0));

        UserPoint userPoint = userPoints.get(0);
        userPoint.setPoints(userPoint.getPoints() - 100);
        userPointMapper.updateByExample(userPoint, example);

        UserRedeemHistory record = new UserRedeemHistory();
        record.setCouponId(123456);
        record.setUserId(userId);
        record.setDate(new Date());
        userRedeemHistoryMapper.insert(record);

        CouponPoolExample couponPoolExample = new CouponPoolExample();
        couponPoolExample.createCriteria().andStatusEqualTo((byte) 1);
        List<CouponPool> coupons = couponPoolMapper.selectByExample(couponPoolExample);

        //这里应该要回滚了
        if (coupons.isEmpty() || noCouponAvailable(coupons)) {
            MyDatabaseException exception = new MyDatabaseException("Exception happened --> Rollback. Redeem failed.");
            SERVICE_LOG.error("Exception happens: {}", exception.getMessage());
            throw exception;
        }

        CouponPool coupon = coupons.get(0);
        coupon.setStatus((byte) 0);
        coupon.setDate(new Date());
        couponPoolMapper.updateByPrimaryKey(coupon);


        return "Success Redeem A Coupon. Id: " + coupon.getCouponId();
    }

    private boolean noCouponAvailable(List<CouponPool> couponPools) {
        assert !couponPools.isEmpty();
        for (CouponPool coupon : couponPools) {
            if (coupon.getStatus() == 1)
                return false;
        }

        return true;
    }
}
