package com.sungkang.crmsys.controller;


import com.alibaba.fastjson.JSON;
import com.sungkang.crmsys.domain.EmployeeRequest;
import com.sungkang.crmsys.domain.EmployeeResult;
import com.sungkang.crmsys.domain.R;
import com.sungkang.crmsys.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public R getByPage(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
        List<EmployeeResult> data = service.getByPage(page, limit);
        String count = String.valueOf(service.count());
        return new R("0", "success", data, count);
    }

    @GetMapping("/conditions")
    public R getByPageAndConditions(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit,
                                    @RequestParam("name") String name, @RequestParam("idCard") String idCard,
                                    @RequestParam("department") String departmentName,
                                    @RequestParam("begindate") String beginDate) {
        int firstIndex = (page - 1) * limit;
        int lastIndex = firstIndex + limit;

        List<EmployeeResult> results = service.getByPageAndConditions(name, idCard, departmentName, beginDate);

        if (firstIndex > results.size()) {
            firstIndex = results.size() / limit * limit;
        }
        if (lastIndex > results.size()) {
            lastIndex = results.size();
        }

        return new R("0", "success", results.subList(firstIndex, lastIndex), String.valueOf(results.size()));
    }

    @PatchMapping
    public R workState(@RequestBody EmployeeRequest employee) {
        if (service.workState(employee)) {
            return new R("200", "success", null, null);
        } else {
            return new R("50X", "数据异常", null, null);
        }
    }

    @DeleteMapping
    public R deleteByIds(@RequestBody String ids) {
        List<String> idList = JSON.parseArray(JSON.parseObject(ids).getString("ids"), String.class);
        service.deleteByIds(idList);
        return new R("200", "success", null, null);
    }

}
