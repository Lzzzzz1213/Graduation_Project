package com.glasssellmanagersystem.controller;

import com.glasssellmanagersystem.pojo.PageInfo;
import com.glasssellmanagersystem.pojo.School;
import com.glasssellmanagersystem.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class SchoolController {
    @Autowired
    SchoolService schoolService;

    @RequestMapping("/user/school/findSchools")
    public String findSchools(Integer pageIndex, Integer pageSize, Model model){
        PageInfo<School> schoolPageInfo = schoolService.getAllSchoolsList(pageIndex, pageSize);
        model.addAttribute("pages",schoolPageInfo);
        return "school-list";
    }

    @RequestMapping("/user/school/deleteSchool")
    @ResponseBody
    public void deleteSchool(Integer school_id){
        schoolService.deleteSchool(school_id);
    }

    @RequestMapping("/user/school/openAddSchoolPage")
    public String  openAddSchoolPage() {
        return "school-add";
    }

    @RequestMapping("/user/school/addSchool")
    @ResponseBody
    public void addSchool(School school, HttpServletResponse httpServletResponse){
        int a = schoolService.findSchoolByName(school.getSchool_name());
        if (a==0){
            schoolService.addSchool(school);
        }else{
            try {
                httpServletResponse.sendError(403);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
