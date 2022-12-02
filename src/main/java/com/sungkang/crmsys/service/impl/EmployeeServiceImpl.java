package com.sungkang.crmsys.service.impl;

import com.sungkang.crmsys.domain.Employee;
import com.sungkang.crmsys.domain.EmployeeRequest;
import com.sungkang.crmsys.domain.EmployeeResult;
import com.sungkang.crmsys.mapper.EmployeeMapper;
import com.sungkang.crmsys.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<EmployeeResult> getByPage(Integer pageNo, Integer pageSize) {

        return employeeMapper.getByPage(getFirstIndex(pageNo, pageSize), pageSize);
    }

    @Override
    public HashMap<String, Object> getByPageAndConditions(
            int pageNo, int pageSize,
            String name, String idCard,
            String departmentName, String beginDate) {

        HashMap<String, Object> resultMap = new HashMap<>();

        resultMap.put("resultList", employeeMapper.getByConditions(getFirstIndex(pageNo, pageSize), pageSize,
                name, idCard, departmentName, beginDate));
        resultMap.put("resultCount", employeeMapper.getByConditionsCount(name, idCard, departmentName, beginDate));

        return resultMap;
    }

    @Override
    public boolean workState(EmployeeRequest employee) {
        if (employee.getValue().equals("在职")) {
            return employeeMapper.workState(employee, "beginDate");
        } else if (employee.getValue().equals("离职")) {
            return employeeMapper.workState(employee, "notWorkDate");
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteByIds(List<String> ids) {
        return employeeMapper.deleteByIds(ids);
    }

    private static int getFirstIndex(int page, int pageSize) {
        return (page - 1) * pageSize;
    }

}
