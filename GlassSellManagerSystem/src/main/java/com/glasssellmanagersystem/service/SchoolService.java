package com.glasssellmanagersystem.service;

import com.glasssellmanagersystem.pojo.PageInfo;
import com.glasssellmanagersystem.pojo.School;

import java.util.List;

public interface SchoolService {

    List<School> findAllSchool();

    PageInfo<School> getAllSchoolsList(Integer pageIndex, Integer pageSize);

    int deleteSchool(Integer school_id);

    int addSchool(School school);

    int findSchoolByName(String school_name);
}
