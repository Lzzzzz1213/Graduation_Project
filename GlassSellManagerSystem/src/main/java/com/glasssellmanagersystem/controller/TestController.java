package com.glasssellmanagersystem.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class TestController {
    @CrossOrigin
    @PostMapping(value = "/user/test")
    @ResponseBody
    public void testController(String name,String pass, HttpServletResponse httpServletResponse){
        if (name.equals("123") && pass.equals("123")){
            System.out.println(name);
            System.out.println(pass);
            try {
                httpServletResponse.sendError(505);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println(name);
            System.out.println(pass);
        }

    }
}
