package com.glasssellmanagersystem.service;

import com.glasssellmanagersystem.dao.ReviewMapper;
import com.glasssellmanagersystem.pojo.PageInfo;
import com.glasssellmanagersystem.pojo.RegisterInfo;
import com.glasssellmanagersystem.pojo.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ReviewServiceImp implements ReviewService{
    @Autowired
    ReviewMapper reviewMapper;


    @Override
    public int addReview(Review review) {
        return reviewMapper.addReview(review);
    }

    @Override
    public PageInfo<Review> findCustomerReviewByCustomerId(Integer pageIndex, Integer pageSize, Integer review_customerId) {
        PageInfo<Review> reviewPageInfo = new PageInfo<Review>();
        reviewPageInfo.setPageIndex(pageIndex);
        reviewPageInfo.setPageSize(pageSize);
        Integer customerVipTotalCount = reviewMapper.customerVipTotalCount(review_customerId);
        if (customerVipTotalCount > 0){
            reviewPageInfo.setTotalCount(customerVipTotalCount);
            List<Review> reviewList =reviewMapper.findCustomerReviewByCustomerId((reviewPageInfo.getPageIndex() - 1) * reviewPageInfo.getPageSize(), reviewPageInfo.getPageSize(),review_customerId);
            reviewPageInfo.setList(reviewList);
        }
        return reviewPageInfo;
    }

    @Override
    public int deleteReviewByCustomerId(Integer review_customerId) {
        return reviewMapper.deleteReviewByCustomerId(review_customerId);
    }

    @Override
    public int deleteReviewById(Integer review_id) {
        return reviewMapper.deleteReviewById(review_id);
    }


}
