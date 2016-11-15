package com.glodon.tcpcopy.dao;

import com.glodon.tcpcopy.bo.product.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> selectByOwnerId(@Param("ownerId") String ownerId);

    int deleteByPId(String pId);

    int updateByPIdSelective(Product product);
}