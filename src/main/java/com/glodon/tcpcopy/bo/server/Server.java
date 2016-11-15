package com.glodon.tcpcopy.bo.server;

import com.glodon.tcpcopy.bo.commom.CommonStateEnum;

public class Server {
    private Integer serverId;

    private Integer serverType;

    private String productId;

    private String serverIp;

    private String username;

    private String password;

    private String appPort;

    private CommonStateEnum state;

    private String sId;

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public Integer getServerType() {
        return serverType;
    }

    public void setServerType(Integer serverType) {
        this.serverType = serverType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp == null ? null : serverIp.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAppPort() {
        return appPort;
    }

    public void setAppPort(String appPort) {
        this.appPort = appPort == null ? null : appPort.trim();
    }

    public CommonStateEnum getState() {
        return state;
    }

    public void setState(CommonStateEnum state) {
        this.state = state;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId == null ? null : sId.trim();
    }
}