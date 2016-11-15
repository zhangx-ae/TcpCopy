package com.glodon.tcpcopy.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhangxin on 2016/11/11.
 */
@Controller
public class IndexController {

    private Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping("/")
    public String index(){
        logger.debug("index");
        return "/index";
    }
}
