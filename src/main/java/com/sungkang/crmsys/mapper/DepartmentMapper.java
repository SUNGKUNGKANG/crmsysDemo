package com.sungkang.crmsys.mapper;

import com.sungkang.crmsys.domain.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {

    public List<Department> getAll();

}
