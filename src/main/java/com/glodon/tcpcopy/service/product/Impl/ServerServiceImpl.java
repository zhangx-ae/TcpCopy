package com.glodon.tcpcopy.service.product.Impl;

import com.glodon.tcpcopy.bo.server.Server;
import com.glodon.tcpcopy.dao.ServerDao;
import com.glodon.tcpcopy.service.product.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangxin on 2016/11/11.
 */
@Service
public class ServerServiceImpl implements ServerService {

    @Autowired
    ServerDao serverDao;

    public Server getServerByIp(String ip) {
        return serverDao.selectByIp(ip);
    }

    public boolean editServer(List<Server> servers) {
        int affectRows = serverDao.updateBySIdBatch(servers);
        return affectRows > 0;
    }

    public Server getServerBySId(String sId) {
        return serverDao.selectBySId(sId);
    }
}
