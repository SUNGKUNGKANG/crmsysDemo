package com.sungkang.crmsys.controller;


import com.sungkang.crmsys.domain.Hr;
import com.sungkang.crmsys.domain.R;
import com.sungkang.crmsys.domain.UserResult;
import com.sungkang.crmsys.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class HrController {

    @Autowired
    private HrService service;

    @PostMapping("/login")
    public R login(@RequestBody Hr hr) {
        Hr check = service.login(hr);
        if (check != null) {
            return new R("200", "success", new UserResult(check), null);
        } else
            return new R("501", "数据异常", "用户名或密码错误", null);
    }

}
