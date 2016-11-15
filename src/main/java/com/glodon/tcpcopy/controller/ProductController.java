package com.glodon.tcpcopy.controller;

import com.glodon.tcpcopy.bo.product.Product;
import com.glodon.tcpcopy.bo.commom.JsonResult;
import com.glodon.tcpcopy.service.product.ProductService;
import com.glodon.tcpcopy.service.product.ServerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhangxin on 2016/11/10.
 */
@Controller
@RequestMapping("/application")
public class ProductController extends BaseController{

    private Logger logger = Logger.getLogger(this.getClass());

    private static final String PRODUCT_VIEW_PATH = "/product";

    @Autowired
    private ProductService productService;
    @Autowired
    private ServerService serverService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getProductsByUserId(ModelMap modelMap){

//        String ownerId = user.getuId();
        String ownerId = "user-fa6ffb59-6761-48f3-ac7c-23d53e1d430b";
        List<Product> products = productService.selectByOwnerId(ownerId);

        modelMap.put("products", products);
        return PRODUCT_VIEW_PATH + "/list";
    }

    @RequestMapping("/add")
    @ResponseBody
    public JsonResult addProduct(@RequestBody Product product){
        JsonResult jsonResult = new JsonResult();
        boolean result = productService.add(product);

        jsonResult.setSuccess(result);
        jsonResult.setMessage("产品添加成功!");

        return jsonResult;
    }

    @RequestMapping("/{pId}/delete")
    @ResponseBody
    public JsonResult deleteProduct(@PathVariable("pId")String pId){
        JsonResult jsonResult = new JsonResult();
        boolean result = productService.deleteProduct(pId);

        jsonResult.setSuccess(result);
        return jsonResult;
    }

    @RequestMapping("/{pId}/edit")
    @ResponseBody
    public JsonResult editProduct(@PathVariable("pId")String pId, Product product){
        JsonResult jsonResult = new JsonResult();
        boolean productResult = productService.editProduct(product);
        //批量更新sql还没写
        boolean serverResult = serverService.editServer(product.getServers());

        jsonResult.setSuccess(productResult && serverResult);
        return jsonResult;
    }

}
