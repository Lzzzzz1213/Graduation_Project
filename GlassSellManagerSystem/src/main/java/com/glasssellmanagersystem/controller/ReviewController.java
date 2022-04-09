package com.glasssellmanagersystem.controller;

import com.glasssellmanagersystem.pojo.Customer;
import com.glasssellmanagersystem.pojo.PageInfo;
import com.glasssellmanagersystem.pojo.Review;
import com.glasssellmanagersystem.service.CustomerService;
import com.glasssellmanagersystem.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReviewController {
    @Autowired
    ReviewService reviewService;
    @Autowired
    CustomerService customerService;
    @RequestMapping("/user/customer/vip/openAddReviewPage/{id}")
    public String openAddReviewPage(@PathVariable(name = "id")Integer review_customerId, Model model){
        Customer customer = customerService.findCustomerById(review_customerId);
        String age = customerService.getCustomerAge(review_customerId);
        model.addAttribute("customer",customer);
        model.addAttribute("age",age);
        return "review-add-table";
    }

    @RequestMapping(value = "/user/customer/vip/addReview",method = RequestMethod.POST)
    @ResponseBody
    public void addReview(Review review){
        reviewService.addReview(review);
    }
    @RequestMapping("/user/customer/vip/findCustomerReview/{id}")
    public String findCustomerReview(@PathVariable(name = "id")Integer review_customerId,Model model,Integer pageIndex, Integer pageSize ){
        Customer customer = customerService.findCustomerById(review_customerId);
        String age = customerService.getCustomerAge(review_customerId);
        PageInfo<Review> reviewPageInfo = reviewService.findCustomerReviewByCustomerId(pageIndex, 2, review_customerId);
        model.addAttribute("pages",reviewPageInfo);
        model.addAttribute("customer",customer);
        model.addAttribute("age",age);
        return "customer-vip-review-list";
    }
    @RequestMapping("/user/customer/vip/deleteReview")
    @ResponseBody
    public void deleteReview(Integer review_id){
        reviewService.deleteReviewById(review_id);
    }
}
