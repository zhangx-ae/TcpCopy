package com.glodon;

import com.glodon.tcpcopy.controller.BaseController;
import com.glodon.tcpcopy.service.user.UserService;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by zhangxin on 2016/11/7.
 */
@Controller
@RequestMapping("/hello")
public class HelloWorldController extends BaseController{


    @Autowired
    UserService userService;

    Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping("/hello")
    @ResponseBody
    public String Hello(){
        logger.debug("hello world!");
        return "hello";
    }

    @RequestMapping("/anon")
    @ResponseBody
    public String Anon(){
        logger.debug("anon!");
        return "anon";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String Login(){
        logger.debug("login as " + user.getUserName());
        return "login";
    }

    @RequestMapping("/")
    @ResponseBody
    public String Index(){
        logger.debug("index!");
        return "index";
    }

    @RequestMapping("/cas")
    public String cas(){
        logger.debug("cas!");
        return "redirect:/anon";
    }

    @RequestMapping("/logout")
    @ResponseBody
    public String logout(){
        logger.debug("logout!");
        return "logout";
    }
}
