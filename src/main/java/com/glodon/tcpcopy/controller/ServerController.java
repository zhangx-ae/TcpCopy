package com.glodon.tcpcopy.controller;

import com.glodon.tcpcopy.bo.server.Server;
import com.glodon.tcpcopy.bo.commom.JsonResult;
import com.glodon.tcpcopy.service.product.ServerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhangxin on 2016/11/11.
 */
@Controller
@RequestMapping("/server")
public class ServerController {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private ServerService serverService;

    @RequestMapping(value = "/start")
    @ResponseBody
    public JsonResult startTcpCopy(String onlineIp, String onlinePort, String targetIp, String targetPort){
        JsonResult jsonResult = new JsonResult();
        //调用sdk开始tcpcopy

        jsonResult.setSuccess(true);
        jsonResult.setMessage("TCP copy启动成功!");

        return jsonResult;
    }

    @RequestMapping(value = "/terminate")
    @ResponseBody
    public JsonResult terminateTcpCopy(String onlineIp, String onlinePort, String targetIp, String targetPort){
        JsonResult jsonResult = new JsonResult();
        //调用sdk终止tcpcopy

        jsonResult.setSuccess(true);
        jsonResult.setMessage("TCP copy终止成功!");

        return jsonResult;
    }

    @RequestMapping(value = "/{sId}/{device}")
    @ResponseBody
    public JsonResult getCPUStatus(@PathVariable("sId")String sId, @PathVariable("device")String device){

        Server server = serverService.getServerBySId(sId);
        logger.debug("用户名:" + server.getUsername());
        logger.debug("密码:" + server.getPassword());
        logger.debug("ip:" + server.getServerIp());
        logger.debug("硬件:" + device);


        JsonResult jsonResult = new JsonResult();
        //调用sdk获取硬件信息

        jsonResult.setSuccess(true);
        jsonResult.setMessage("获取CPU信息成功!");
        return jsonResult;
    }

}
