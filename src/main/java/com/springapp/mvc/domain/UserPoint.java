package com.springapp.mvc.domain;

public class UserPoint {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_point.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_point.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_point.level
     *
     * @mbggenerated
     */
    private Byte level;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_point.points
     *
     * @mbggenerated
     */
    private Integer points;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_point.id
     *
     * @return the value of user_point.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_point.id
     *
     * @param id the value for user_point.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_point.user_id
     *
     * @return the value of user_point.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_point.user_id
     *
     * @param userId the value for user_point.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_point.level
     *
     * @return the value of user_point.level
     *
     * @mbggenerated
     */
    public Byte getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_point.level
     *
     * @param level the value for user_point.level
     *
     * @mbggenerated
     */
    public void setLevel(Byte level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_point.points
     *
     * @return the value of user_point.points
     *
     * @mbggenerated
     */
    public Integer getPoints() {
        return points;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_point.points
     *
     * @param points the value for user_point.points
     *
     * @mbggenerated
     */
    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "UserPoint{" +
                "id=" + id +
                ", userId=" + userId +
                ", level=" + level +
                ", points=" + points +
                '}';
    }
}