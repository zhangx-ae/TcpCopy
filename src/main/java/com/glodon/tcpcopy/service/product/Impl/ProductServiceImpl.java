package com.glodon.tcpcopy.service.product.Impl;

import com.glodon.tcpcopy.bo.product.Product;
import com.glodon.tcpcopy.dao.ProductDao;
import com.glodon.tcpcopy.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by zhangxin on 2016/11/11.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    public List<Product> selectByOwnerId(String ownerId) {
        return productDao.selectByOwnerId(ownerId);
    }

    public boolean add(Product product) {
        int affectRows = productDao.insertSelective(product);
        return affectRows > 0;
    }

    public boolean deleteProduct(String pId) {
        int affectRows = productDao.deleteByPId(pId);
        return affectRows > 0;
    }

    public Product getProductByPId(String pId) {
        return null;
    }

    public boolean editProduct(Product product) {
        int affectRow = productDao.updateByPIdSelective(product);
        return affectRow > 0;
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID());
    }
}
