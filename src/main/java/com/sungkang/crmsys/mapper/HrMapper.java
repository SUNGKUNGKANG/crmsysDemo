package com.sungkang.crmsys.mapper;

import com.sungkang.crmsys.domain.Hr;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HrMapper extends BaseMapper<Hr> {

    public Hr selectToLogin(Hr hr);

    public boolean updateRemark(Hr hr);
}
