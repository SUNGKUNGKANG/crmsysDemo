package com.sungkang.crmsys.service;

import com.sungkang.crmsys.domain.Hr;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.xml.soap.SAAJResult;
import java.util.Map;

public interface HrService extends IService<Hr> {
    public Hr login(Hr hr);
}
