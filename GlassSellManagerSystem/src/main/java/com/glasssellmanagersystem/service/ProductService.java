package com.glasssellmanagersystem.service;

import com.glasssellmanagersystem.pojo.PageInfo;
import com.glasssellmanagersystem.pojo.Product;
import com.glasssellmanagersystem.pojo.School;

import java.util.List;

public interface ProductService {

    List<Product> findAllProduct();

    PageInfo<Product> getAllProductsList(Integer pageIndex, Integer pageSize);

    int deleteProduct(Integer product_id);

    int addProduct(Product product);

    int updateProduct(Product product);

    Product findProductById(Integer product_id);

    int findProductByNumber(String product_number);
}
