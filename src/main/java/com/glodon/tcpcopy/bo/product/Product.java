package com.glodon.tcpcopy.bo.product;

import com.glodon.tcpcopy.bo.commom.CommonStateEnum;
import com.glodon.tcpcopy.bo.server.Server;

import java.util.List;

public class Product {
    private Integer productId;

    private String ownerId;

    private String productName;

    private CommonStateEnum state;

    private String pId;

    private List<Server> servers;

    public List<Server> getServers() {
        return servers;
    }

    public void setServers(List<Server> servers) {
        this.servers = servers;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId == null ? null : ownerId.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public CommonStateEnum getState() {
        return state;
    }

    public void setState(CommonStateEnum state) {
        this.state = state;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId == null ? null : pId.trim();
    }
}