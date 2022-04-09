package com.glasssellmanagersystem.service;

import com.glasssellmanagersystem.dao.ProductMapper;
import com.glasssellmanagersystem.pojo.PageInfo;
import com.glasssellmanagersystem.pojo.Product;
import com.glasssellmanagersystem.utils.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImp implements ProductService{
    @Autowired
    ProductMapper productMapper;
    @Override
    public List<Product> findAllProduct() {
        return productMapper.findAllProduct();
    }

    @Override
    public PageInfo<Product> getAllProductsList(Integer pageIndex, Integer pageSize) {
        PageInfo<Product> productPageInfo = new PageInfo<Product>();
        productPageInfo.setPageIndex(pageIndex);
        productPageInfo.setPageSize(pageSize);
        int totalCount = productMapper.totalCount();
        if (totalCount > 0){
            productPageInfo.setTotalCount(totalCount);
            List<Product> productList = productMapper.getAllProductList((productPageInfo.getPageIndex() - 1) * productPageInfo.getPageSize(), productPageInfo.getPageSize());
            productPageInfo.setList(productList);
        }
        return productPageInfo;
    }

    @Override
    public int deleteProduct(Integer product_id) {
        return productMapper.deleteProduct(product_id);
    }

    @Override
    public int addProduct(Product product) {
        DateFormatUtil getDate = new DateFormatUtil();
        product.setProduct_createDate(getDate.getDate());
        return productMapper.addProduct(product);
    }

    @Override
    public int updateProduct(Product product) {
        DateFormatUtil getDate = new DateFormatUtil();
        product.setProduct_createDate(getDate.getDate());
        return productMapper.updateProduct(product);
    }

    @Override
    public Product findProductById(Integer product_id) {
        return productMapper.findProductById(product_id);
    }

    @Override
    public int findProductByNumber(String product_number) {
        return productMapper.findProductByNumber(product_number);
    }

}
