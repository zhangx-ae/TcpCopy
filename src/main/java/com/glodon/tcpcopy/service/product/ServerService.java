package com.glodon.tcpcopy.service.product;

import com.glodon.tcpcopy.bo.server.Server;

import java.util.List;

/**
 * Created by zhangxin on 2016/11/11.
 */
public interface ServerService {
    Server getServerByIp(String ip);

    boolean editServer(List<Server> servers);

    Server getServerBySId(String sId);
}
