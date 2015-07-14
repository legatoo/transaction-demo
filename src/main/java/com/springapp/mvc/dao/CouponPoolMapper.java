package com.springapp.mvc.dao;

import com.springapp.mvc.domain.CouponPool;
import com.springapp.mvc.domain.CouponPoolExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponPoolMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coupon_pool
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coupon_pool
     *
     * @mbggenerated
     */
    int insert(CouponPool record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coupon_pool
     *
     * @mbggenerated
     */
    int insertSelective(CouponPool record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coupon_pool
     *
     * @mbggenerated
     */
    List<CouponPool> selectByExample(CouponPoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coupon_pool
     *
     * @mbggenerated
     */
    CouponPool selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coupon_pool
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CouponPool record, @Param("example") CouponPoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coupon_pool
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CouponPool record, @Param("example") CouponPoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coupon_pool
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CouponPool record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table coupon_pool
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CouponPool record);
}