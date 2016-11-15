package com.glodon.tcpcopy.dao;

import com.glodon.tcpcopy.bo.server.Server;

import java.util.List;

public interface ServerDao {
    int deleteByPrimaryKey(Integer serverId);

    int insert(Server record);

    int insertSelective(Server record);

    Server selectByPrimaryKey(Integer serverId);

    int updateByPrimaryKeySelective(Server record);

    int updateByPrimaryKey(Server record);

    Server selectByIp(String ip);

    int updateBySIdBatch(List<Server> servers);

    Server selectBySId(String sId);
}