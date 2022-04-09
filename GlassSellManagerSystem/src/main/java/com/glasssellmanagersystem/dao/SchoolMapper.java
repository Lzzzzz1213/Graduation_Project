package com.glasssellmanagersystem.dao;

import com.glasssellmanagersystem.pojo.Customer;
import com.glasssellmanagersystem.pojo.School;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SchoolMapper {

    List<School> findAllSchool();

    List<School> getAllSchoolsList(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

    int totalCount();

    int deleteSchool(Integer school_id);

    int addSchool(School school);

    int findSchoolByName(String school_name);
}
