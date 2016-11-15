package com.glodon.tcpcopy.bo.user;

import com.glodon.tcpcopy.bo.commom.CommonStateEnum;

public class User {
    private Integer userId;

    private String uId;

    private String userName;

    private RoleEnum userType;

    private CommonStateEnum state;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public RoleEnum getUserType() {
        return userType;
    }

    public void setUserType(RoleEnum userType) {
        this.userType = userType;
    }

    public CommonStateEnum getState() {
        return state;
    }

    public void setState(CommonStateEnum state) {
        this.state = state;
    }
}