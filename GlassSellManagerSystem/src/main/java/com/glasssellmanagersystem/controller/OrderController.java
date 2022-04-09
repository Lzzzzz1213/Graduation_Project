package com.glasssellmanagersystem.controller;

import com.glasssellmanagersystem.pojo.*;
import com.glasssellmanagersystem.service.*;
import com.glasssellmanagersystem.utils.DateFormatUtil;
import com.glasssellmanagersystem.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    CustomerService customerService;
    @Autowired
    ProductService productService;
    @Autowired
    ProductPackageService productPackageService;
    @Autowired
    UserService userService;
    @Autowired
    RegisterInfoService registerInfoService;

    @RequestMapping(value = "/user/order/createOrder",method = RequestMethod.POST)
    @ResponseBody
    public void createOrder(Order order, HttpServletResponse response){
        int a = orderService.findOrderByRegisterInfoId(order.getOrder_registerInfoId());
        if (a==0){
            orderService.createOrder(order);
            Customer customer = new Customer();
            customer.setCustomer_id(order.getOrder_customerId());
            DateFormatUtil getDate  = new DateFormatUtil();
            customer.setCustomer_createOrderDate(getDate.getDate());
            customerService.updateCustomerCreateOrderDate(customer);
        }else{
            try {
                response.sendError(500);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping(value = "/user/order/findOrder")
    public String findOrder(Model model, Integer pageIndex, Integer pageSize){
        PageInfo<Order> orderPageInfo = orderService.findPageInfo(pageIndex,pageSize);
        model.addAttribute("pages",orderPageInfo);
        return "order-list";
    }

    @RequestMapping(value = "/user/order/editCustomerOrder/{customer_id}/{order_id}")
    public String editCustomerOrder(@PathVariable(name = "customer_id") Integer customer_id,@PathVariable(name = "order_id") Integer order_id,Model model){
        Customer customer = customerService.findCustomerById(customer_id);
        List<Product> products = productService.findAllProduct();
        List<ProductPackage> productPackages = productPackageService.findAllProductPackage();
        String age = customerService.getCustomerAge(customer_id);
        model.addAttribute("customer",customer);
        model.addAttribute("age",age);
        model.addAttribute("products",products);
        model.addAttribute("productPackages",productPackages);
        model.addAttribute("order_id",order_id);
        return "order-edit";
    }
    @RequestMapping(value = "/user/order/updateCustomerOrder")
    @ResponseBody
    public void updateCustomerOrder(Order order,String frameNumber,String glassNumber,Integer customer_id){
        orderService.updateOrder(order);

        Customer customer = new Customer();
        customer.setCustomer_id(customer_id);
        customer.setCustomer_glassesDegree(order.getOrder_customerDegreeInfo());
        customer.setCustomer_framesType(frameNumber.substring(0,frameNumber.indexOf(":")));
        customer.setCustomer_glassesType(glassNumber.substring(0,frameNumber.indexOf(":")));
        customerService.updateCustomerGlassAndFrame(customer);

        Order thisOrder = orderService.findOrderById(order.getOrder_id());
        int registerId = thisOrder.getOrder_registerInfoId();
        registerInfoService.updateRegisterSupport(registerId,frameNumber.substring(0,frameNumber.indexOf(":")));
    }
    @RequestMapping(value = "/user/order/changePaymentState")
    @ResponseBody
    public void changePaymentState(Integer order_id,String order_paymentState){
        int a = orderService.updatePaymentStateById(order_id,order_paymentState);
    }
    @RequestMapping(value = "/user/order/openUpdateOrderLogisticsPage/{id}")
    public String openUpdateOrderLogisticsPage(@PathVariable(value = "id")Integer order_id,Model model){
        model.addAttribute("order_id",order_id);
        return "order-logis";
    }

    @RequestMapping(value = "/user/order/updateOrderLogistics")
    @ResponseBody
    public void updateOrderLogistics(Integer order_id,String order_logisticsName){
        orderService.updateOrderStateById(order_id,"已发货等待签收");
        orderService.updateOrderLogisticsById(order_id,order_logisticsName,"已发货");
    }
    @RequestMapping(value = "/user/order/openOrderSuccessPage/{id}")
    public String openOrderSuccessPage(@PathVariable(name = "id") Integer order_id,Model model){
        model.addAttribute("order_id",order_id);
        return "order-success";
    }

    @RequestMapping(value = "/user/order/orderSuccess")
    @ResponseBody
    public void orderSuccess(String password,Integer id,Integer order_id,HttpServletResponse httpServletResponse){
        int a = userService.checkUserPassById(id, MD5Util.MD5EncodeUtf8(password));
        if (a==0){
            try {
                httpServletResponse.sendError(403);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            DateFormatUtil getDate = new DateFormatUtil();
            int b = orderService.updateOrderStateById(order_id,"订单已完成");
            int c = orderService.updateOrderSuccessDate(order_id,getDate.getDate());
            Order order = orderService.findOrderById(order_id);
            customerService.updateCustomerVipById(order.getOrder_customerId());
            customerService.updateCustomerGetGlassDate(order.getOrder_customerId(),getDate.getDate());
        }
    }

    @RequestMapping(value = "/user/order/openOrderDeletePage/{id}")
    public String openOrderDeletePage(@PathVariable(name = "id") Integer order_id,Model model){
        model.addAttribute("order_id",order_id);
        return "order-delete";
    }
    @RequestMapping(value = "/user/order/orderDelete")
    @ResponseBody
    public void orderDelete(String password,Integer id,Integer order_id,HttpServletResponse httpServletResponse){
        int a = userService.checkUserPassById(id,MD5Util.MD5EncodeUtf8(password));
        if (a==0){
            try {
                httpServletResponse.sendError(403);
            }catch (IOException e){
                e.printStackTrace();
            }
        }else {
            orderService.deleteOrderById(order_id);
        }
    }
    @RequestMapping(value = "/user/order/orderMessage/{id}")
    public String orderMessage(@PathVariable(name = "id") Integer order_id,Model model){
        Order order = orderService.findOrderById(order_id);
        order.setOrder_productDescribe(order.getOrder_productDescribe()+"    "+"配镜参数:"+order.getOrder_customerDegreeInfo());
        model.addAttribute("order",order);
        return "order-message";
    }
}
