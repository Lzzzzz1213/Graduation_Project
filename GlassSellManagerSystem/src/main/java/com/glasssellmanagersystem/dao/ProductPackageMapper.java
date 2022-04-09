package com.glasssellmanagersystem.dao;

import com.glasssellmanagersystem.pojo.Product;
import com.glasssellmanagersystem.pojo.ProductPackage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductPackageMapper {

    List<ProductPackage> findAllProductPackage();

    List<ProductPackage> getAllProductPackageList(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    int totalCount();

    int deleteProductPackage(Integer productPackage_id);

    int addProductPackage(ProductPackage productPackage);

    int updateProductPackage(ProductPackage productPackage);

    ProductPackage findProductPackageById(Integer productPackage_id);

    int findProductPackageByNumber(String productPackage_number);
}
