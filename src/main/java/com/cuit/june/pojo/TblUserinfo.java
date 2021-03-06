package com.cuit.june.pojo;

import java.math.BigDecimal;

public class TblUserinfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TBL_USERINFO.PK_ID
     *
     * @mbggenerated
     */
    private BigDecimal pkId;  //用户ID

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TBL_USERINFO.USIN_USERNAME
     *
     * @mbggenerated
     */
    private String usinUsername; //登录名

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column TBL_USERINFO.USIN_PASSWORD
     *
     * @mbggenerated
     */
    private String usinPassword; //登录密码

    private String usinName;  //姓名

    private String usinPhone;  //手机号

    public String getUsinName() {
        return usinName;
    }

    public void setUsinName(String usinName) {
        this.usinName = usinName;
    }

    public String getUsinPhone() {
        return usinPhone;
    }

    public void setUsinPhone(String usinPhone) {
        this.usinPhone = usinPhone;
    }

    public TblUserinfo(String usinUsername, String usinPassword,String usinName,String usinPhone){
        this.usinUsername = usinUsername;
        this.usinPassword = usinPassword;
        this.usinName = usinName;
        this.usinPhone = usinPhone;
    }

    public TblUserinfo(BigDecimal pkId, String usinUsername, String usinPassword,String usinName,String usinPhone){
        this.pkId = pkId;
        this.usinUsername = usinUsername;
        this.usinPassword = usinPassword;
        this.usinName = usinName;
        this.usinPhone = usinPhone;
    }

    public TblUserinfo(){}

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TBL_USERINFO.PK_ID
     *
     * @return the value of TBL_USERINFO.PK_ID
     *
     * @mbggenerated
     */
    public BigDecimal getPkId() {
        return pkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TBL_USERINFO.PK_ID
     *
     * @param pkId the value for TBL_USERINFO.PK_ID
     *
     * @mbggenerated
     */
    public void setPkId(BigDecimal pkId) {
        this.pkId = pkId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TBL_USERINFO.USIN_USERNAME
     *
     * @return the value of TBL_USERINFO.USIN_USERNAME
     *
     * @mbggenerated
     */
    public String getUsinUsername() {
        return usinUsername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TBL_USERINFO.USIN_USERNAME
     *
     * @param usinUsername the value for TBL_USERINFO.USIN_USERNAME
     *
     * @mbggenerated
     */
    public void setUsinUsername(String usinUsername) {
        this.usinUsername = usinUsername == null ? null : usinUsername.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column TBL_USERINFO.USIN_PASSWORD
     *
     * @return the value of TBL_USERINFO.USIN_PASSWORD
     *
     * @mbggenerated
     */
    public String getUsinPassword() {
        return usinPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column TBL_USERINFO.USIN_PASSWORD
     *
     * @param usinPassword the value for TBL_USERINFO.USIN_PASSWORD
     *
     * @mbggenerated
     */
    public void setUsinPassword(String usinPassword) {
        this.usinPassword = usinPassword == null ? null : usinPassword.trim();
    }
}