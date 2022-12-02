package com.sungkang.crmsys.service;

import com.sungkang.crmsys.domain.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sungkang.crmsys.domain.EmployeeRequest;
import com.sungkang.crmsys.domain.EmployeeResult;

import java.util.HashMap;
import java.util.List;

public interface EmployeeService extends IService<Employee> {

    public List<EmployeeResult> getByPage(Integer pageNo, Integer pageSize);

    public HashMap<String, Object> getByPageAndConditions(
            int pageNo, int pageSize,
            String name, String idCard,
            String departmentName, String beginDate);

    public boolean workState(EmployeeRequest employee);

    public boolean deleteByIds(List<String> ids);
}
