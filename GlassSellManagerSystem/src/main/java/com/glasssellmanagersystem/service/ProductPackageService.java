package com.glasssellmanagersystem.service;

import com.glasssellmanagersystem.pojo.PageInfo;
import com.glasssellmanagersystem.pojo.Product;
import com.glasssellmanagersystem.pojo.ProductPackage;

import java.util.List;

public interface ProductPackageService {

    List<ProductPackage> findAllProductPackage();

    PageInfo<ProductPackage> getAllProductPackageList(Integer pageIndex, Integer pageSize);

    int deleteProductPackage(Integer productPackage_id);

    int addProductPackage(ProductPackage productPackage);

    int updateProductPackage(ProductPackage productPackage);

    ProductPackage findProductPackageById(Integer productPackage_id);

    int findProductPackageByNumber(String productPackage_number);
}
