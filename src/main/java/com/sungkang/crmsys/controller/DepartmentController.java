package com.sungkang.crmsys.controller;


import com.sungkang.crmsys.domain.Department;
import com.sungkang.crmsys.domain.R;
import com.sungkang.crmsys.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping
    public R getAll() {

        List<Department> list = service.getAll();

        if (list != null) {
            return new R("200", "success", list, null);
        } else {
            return new R("502", "身份信息过期", null, null);
        }

    }
}
