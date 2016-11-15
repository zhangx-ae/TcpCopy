package com.glodon.tcpcopy.controller;

import com.glodon.tcpcopy.bo.user.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhangxin on 2016/11/10.
 */
public abstract class BaseController {
    public HttpServletRequest request;
    public HttpServletResponse response;
    public User user;

    @ModelAttribute
    protected void initHttpContext(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
        if(SecurityUtils.getSubject().isAuthenticated()){
            this.user = (User)SecurityUtils.getSubject().getPrincipal();
        }else{
            this.user = null;
        }
    }
}
