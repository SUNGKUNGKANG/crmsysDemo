package com.sungkang.crmsys.mapper;

import com.sungkang.crmsys.domain.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sungkang.crmsys.domain.EmployeeRequest;
import com.sungkang.crmsys.domain.EmployeeResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

    public List<EmployeeResult> getByPage(@Param("firstIndex") Integer firstIndex, @Param("lastIndex") Integer pageSize);

    public List<EmployeeResult> getByConditions(
            @Param("firstIndex") Integer firstIndex, @Param("pageSize") Integer pageSize,
            @Param("name") String name, @Param("idcard") String idCard,
            @Param("department") String department,
            @Param("begindate") String beginDate);

    public boolean workState(@Param("employee") EmployeeRequest employee, @Param("time") String time);

    public boolean deleteByIds(@Param("ids") List<String> ids);

    public String getByConditionsCount(@Param("name") String name, @Param("idcard") String idCard,
                                       @Param("department") String department,
                                       @Param("begindate") String beginDate);
}
