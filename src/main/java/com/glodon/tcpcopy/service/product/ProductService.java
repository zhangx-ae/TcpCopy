package com.glodon.tcpcopy.service.product;

import com.glodon.tcpcopy.bo.product.Product;

import java.util.List;

/**
 * Created by zhangxin on 2016/11/11.
 */
public interface ProductService {
    List<Product> selectByOwnerId(String ownerId);

    boolean add(Product product);

    boolean deleteProduct(String pId);

    Product getProductByPId(String pId);

    boolean editProduct(Product product);
}
