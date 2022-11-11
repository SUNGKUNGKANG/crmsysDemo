package com.sungkang.crmsys.service.impl;

import com.sungkang.crmsys.domain.Hr;
import com.sungkang.crmsys.mapper.HrMapper;
import com.sungkang.crmsys.service.HrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sungkang.crmsys.utils.MsgDigestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class HrServiceImpl extends ServiceImpl<HrMapper, Hr> implements HrService {

    @Autowired
    private HrMapper hrMapper;

    @Override
    public Hr login(Hr hr) {
        String password = hr.getPassword();
        String username = hr.getUsername();
        String pwd = MsgDigestUtil.digest(password.concat(username).getBytes(), MsgDigestUtil.MsgDigestAlgorithm.MD5, MsgDigestUtil.MsgDigestReturnType.STRING_TYPE);
        hr.setPassword(pwd);

        Hr getHr = hrMapper.selectToLogin(hr);
        if (getHr!=null) {
            //生成随机 token
            String token = UUID.randomUUID().toString();
            //持久化新的 token
            getHr.setRemark(token);
            //接口要求不返回密码
            getHr.setPassword("");
        }

        return getHr;
    }
}
