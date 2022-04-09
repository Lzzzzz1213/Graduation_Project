package com.glasssellmanagersystem.dao;

import com.glasssellmanagersystem.pojo.Review;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReviewMapper {
    int addReview(Review review);

    List<Review> findCustomerReviewByCustomerId(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize,
                                                @Param("review_customerId") Integer review_customerId);

    int customerVipTotalCount(Integer review_customerId);

    int deleteReviewByCustomerId(Integer review_customerId);

    int deleteReviewById(Integer review_id);
}
