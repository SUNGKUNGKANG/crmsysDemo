package com.sungkang.crmsys.service;

import com.sungkang.crmsys.domain.Department;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface DepartmentService extends IService<Department> {

    public List<Department> getAll();

}
