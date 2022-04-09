package com.glasssellmanagersystem.service;

import com.glasssellmanagersystem.pojo.PageInfo;
import com.glasssellmanagersystem.pojo.Review;

public interface ReviewService {

    int addReview(Review review);

    PageInfo<Review> findCustomerReviewByCustomerId(Integer pageIndex, Integer pageSize, Integer review_customerId);

    int deleteReviewByCustomerId(Integer review_customerId);

    int deleteReviewById(Integer review_id);
}
