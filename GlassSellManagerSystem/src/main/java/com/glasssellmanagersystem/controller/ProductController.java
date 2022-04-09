package com.glasssellmanagersystem.controller;

import com.glasssellmanagersystem.pojo.PageInfo;
import com.glasssellmanagersystem.pojo.Product;
import com.glasssellmanagersystem.pojo.ProductPackage;
import com.glasssellmanagersystem.service.ProductPackageService;
import com.glasssellmanagersystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductPackageService productPackageService;

    //单品
    @RequestMapping("/user/product/findProducts")
    public String findProduct(Integer pageIndex, Integer pageSize, Model model){
        PageInfo<Product> productPageInfo = productService.getAllProductsList(pageIndex, pageSize);
        model.addAttribute("pages",productPageInfo);
        return "product-list";
    }
    @RequestMapping("/user/product/openAddProductPage")
    public String openAddProductPage(){
        return "product-add";
    }
    @RequestMapping(value = "/user/product/addProduct",method = RequestMethod.POST)
    @ResponseBody
    public void addProduct(Product product, HttpServletResponse httpServletResponse){
        int a = productService.findProductByNumber(product.getProduct_number());
        if (a == 0){
            productService.addProduct(product);
        }else{
            try {
                httpServletResponse.sendError(403);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @RequestMapping("/user/product/openProductEditPage/{id}")
    public String openProductEditPage(@PathVariable(name = "id") Integer product_id,Model model){
        Product product = productService.findProductById(product_id);
        model.addAttribute("product",product);
        return "product-edit";
    }
    @RequestMapping("/user/product/editProduct")
    @ResponseBody
    public void editProduct(Product product){
        productService.updateProduct(product);
    }
    @RequestMapping("/user/product/deleteProduct")
    @ResponseBody
    public void deleteProduct(Integer product_id){
        productService.deleteProduct(product_id);
    }


    //套餐
    @RequestMapping("/user/product/findProductPackages")
    public String findProductPackages(Integer pageIndex, Integer pageSize, Model model){
        PageInfo<ProductPackage> productPackagePageInfo = productPackageService.getAllProductPackageList(pageIndex, pageSize);
        model.addAttribute("pages",productPackagePageInfo);
        return "productPackage-list";
    }

    @RequestMapping(value = "/user/product/addProductPackage",method = RequestMethod.POST)
    @ResponseBody
    public void addProductPackage(ProductPackage productPackage, HttpServletResponse httpServletResponse){
        int a = productPackageService.findProductPackageByNumber(productPackage.getProductPackage_number());
        if (a == 0){
            productPackageService.addProductPackage(productPackage);
        }else{
            try {
                httpServletResponse.sendError(403);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @RequestMapping("/user/product/openAddProductPackagePage")
    public String openAddProductPackagePage(){
        return "productPackage-add";
    }
    @RequestMapping("/user/product/openProductPackageEditPage/{id}")
    public String openProductPackageEditPage(@PathVariable(name = "id") Integer productPackage_id,Model model){
        ProductPackage productPackage = productPackageService.findProductPackageById(productPackage_id);
        model.addAttribute("productPackage",productPackage);
        return "productPackage-edit";
    }
    @RequestMapping("/user/product/editProductPackage")
    @ResponseBody
    public void editProductPackage(ProductPackage productPackage){
        productPackageService.updateProductPackage(productPackage);
    }
    @RequestMapping("/user/product/deleteProductPackage")
    @ResponseBody
    public void deleteProductPackage(Integer productPackage_id){
        productPackageService.deleteProductPackage(productPackage_id);
    }
}
