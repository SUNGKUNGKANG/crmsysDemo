package com.sungkang.crmsys.service.impl;

import com.sungkang.crmsys.domain.Department;
import com.sungkang.crmsys.mapper.DepartmentMapper;
import com.sungkang.crmsys.service.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getAll() {
        return departmentMapper.getAll();
    }

}
