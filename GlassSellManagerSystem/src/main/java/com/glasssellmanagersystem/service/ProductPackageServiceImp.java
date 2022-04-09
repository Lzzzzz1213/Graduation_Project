package com.glasssellmanagersystem.service;

import com.glasssellmanagersystem.dao.ProductPackageMapper;
import com.glasssellmanagersystem.pojo.PageInfo;
import com.glasssellmanagersystem.pojo.Product;
import com.glasssellmanagersystem.pojo.ProductPackage;
import com.glasssellmanagersystem.utils.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductPackageServiceImp implements ProductPackageService{
    @Autowired
    ProductPackageMapper productPackageMapper;
    @Override
    public List<ProductPackage> findAllProductPackage() {
        return productPackageMapper.findAllProductPackage();
    }

    @Override
    public PageInfo<ProductPackage> getAllProductPackageList(Integer pageIndex, Integer pageSize) {
        PageInfo<ProductPackage> productPackagePageInfo = new PageInfo<ProductPackage>();
        productPackagePageInfo.setPageIndex(pageIndex);
        productPackagePageInfo.setPageSize(pageSize);
        int totalCount = productPackageMapper.totalCount();
        if (totalCount > 0){
            productPackagePageInfo.setTotalCount(totalCount);
            List<ProductPackage> productPackageList = productPackageMapper.getAllProductPackageList((productPackagePageInfo.getPageIndex() - 1) * productPackagePageInfo.getPageSize(), productPackagePageInfo.getPageSize());
            productPackagePageInfo.setList(productPackageList);
        }
        return productPackagePageInfo;
    }

    @Override
    public int deleteProductPackage(Integer productPackage_id) {
        return productPackageMapper.deleteProductPackage(productPackage_id);
    }

    @Override
    public int addProductPackage(ProductPackage productPackage) {
        DateFormatUtil getDate = new DateFormatUtil();
        productPackage.setProductPackage_createDate(getDate.getDate());
        System.out.println(getDate.getDate());
        return productPackageMapper.addProductPackage(productPackage);
    }

    @Override
    public int updateProductPackage(ProductPackage productPackage) {
        return productPackageMapper.updateProductPackage(productPackage);
    }

    @Override
    public ProductPackage findProductPackageById(Integer productPackage_id) {
        return productPackageMapper.findProductPackageById(productPackage_id);
    }

    @Override
    public int findProductPackageByNumber(String productPackage_number) {
        return productPackageMapper.findProductPackageByNumber(productPackage_number);
    }

}
