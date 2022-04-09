package com.glasssellmanagersystem.service;

import com.glasssellmanagersystem.dao.SchoolMapper;
import com.glasssellmanagersystem.pojo.PageInfo;
import com.glasssellmanagersystem.pojo.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SchoolServiceImp implements SchoolService{
    @Autowired
    SchoolMapper schoolMapper;

    @Override
    public List<School> findAllSchool() {
        return schoolMapper.findAllSchool();
    }

    @Override
    public PageInfo<School> getAllSchoolsList(Integer pageIndex, Integer pageSize) {
        PageInfo<School> schoolPageInfo = new PageInfo<School>();
        schoolPageInfo.setPageIndex(pageIndex);
        schoolPageInfo.setPageSize(pageSize);
        int totalCount = schoolMapper.totalCount();
        if (totalCount > 0){
            schoolPageInfo.setTotalCount(totalCount);
            List<School> schoolList = schoolMapper.getAllSchoolsList((schoolPageInfo.getPageIndex() - 1) * schoolPageInfo.getPageSize(), schoolPageInfo.getPageSize());
            schoolPageInfo.setList(schoolList);
        }
        return schoolPageInfo;
    }

    @Override
    public int deleteSchool(Integer school_id) {
        return schoolMapper.deleteSchool(school_id);
    }

    @Override
    public int addSchool(School school) {
        return schoolMapper.addSchool(school);
    }

    @Override
    public int findSchoolByName(String school_name) {
        return schoolMapper.findSchoolByName(school_name);
    }

}
