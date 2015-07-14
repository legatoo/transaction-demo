package com.springapp.mvc.service.impl;

import com.springapp.mvc.dao.CouponPoolMapper;
import com.springapp.mvc.dao.UserPointHistoryMapper;
import com.springapp.mvc.dao.UserPointMapper;
import com.springapp.mvc.dao.UserRedeemHistoryMapper;
import com.springapp.mvc.domain.*;
import com.springapp.mvc.exception.MyDatabaseException;
import com.springapp.mvc.service.RedeemCouponService;
import org.mybatis.spring.SqlSessionTemplate;
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

    @Autowired
    public UserPointMapper userPointMapper;
    @Autowired
    public UserPointHistoryMapper userPointHistoryMapper;
    @Autowired
    public UserRedeemHistoryMapper userRedeemHistoryMapper;
    @Autowired
    public CouponPoolMapper couponPoolMapper;

    @Autowired
    public SqlSessionTemplate sqlSessionTemplate;


    @Override
    @Transactional(rollbackFor = MyDatabaseException.class)
    public String redeemCoupon(Integer userId){
        UserPointExample example = new UserPointExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<UserPoint> userPoints = userPointMapper.selectByExample(example);

        SERVICE_LOG.info("UserPoint is {}", userPoints.get(0));

        UserPoint userPoint = userPoints.get(0);
        userPoint.setPoints(userPoint.getPoints() - 100);
        userPointMapper.updateByExample(userPoint, example);

//        sqlSessionTemplate.update("com.springapp.mvc.dao.UserPointMapper.updateByPrimaryKeySelective", userPoint);

        UserRedeemHistory record = new UserRedeemHistory();
        record.setCouponId(123456);
        record.setUserId(userId);
        record.setDate(new Date());
        userRedeemHistoryMapper.insert(record);

        CouponPoolExample couponPoolExample = new CouponPoolExample();
        couponPoolExample.createCriteria().andStatusEqualTo((byte) 1);
        List<CouponPool> coupons = couponPoolMapper.selectByExample(couponPoolExample);

        if (coupons.isEmpty()) {
            MyDatabaseException exception = new MyDatabaseException(String.valueOf(TransactionSynchronizationManager.isActualTransactionActive()));
            SERVICE_LOG.error("Exception happens: {}", exception.getMessage());
            throw exception;
        }

        CouponPool coupon = coupons.get(0);
        coupon.setStatus((byte) 0);
        coupon.setDate(new Date());
        couponPoolMapper.updateByPrimaryKey(coupon);


        return "Success";
    }
}
