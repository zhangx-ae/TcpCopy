package com.glodon.tcpcopy.controller;

import com.glodon.tcpcopy.service.user.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhangxin on 2016/11/10.
 */
@Controller
public class MemberShipController {

    Logger logger = Logger.getLogger(this.getClass());

    public static final String USER_VIEW_PATH = "/user";

    @Autowired
    UserService userService;


    @RequestMapping("/login")
    public String login(){
        logger.debug("login");
        return USER_VIEW_PATH + "/login";
    }


}

