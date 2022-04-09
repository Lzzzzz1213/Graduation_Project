package com.glasssellmanagersystem.dao;

import com.glasssellmanagersystem.pojo.Product;
import com.glasssellmanagersystem.pojo.School;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductMapper {

    List<Product> findAllProduct();

    List<Product> getAllProductList(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    int totalCount();

    int deleteProduct(Integer product_id);

    int addProduct(Product product);

    int updateProduct(Product product);

    Product findProductById(Integer product_id);

    int findProductByNumber(String product_number);
}
