package com.sungkang.crmsys.controller;


import com.alibaba.fastjson.JSON;
import com.sungkang.crmsys.domain.EmployeeRequest;
import com.sungkang.crmsys.domain.EmployeeResult;
import com.sungkang.crmsys.domain.R;
import com.sungkang.crmsys.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    //假分页-实际为取出全部数据，根据页面取集合索引范围。
    //TODO:完成分页，返回条件查询总条数和页面内容
    @GetMapping("/conditions")
    public R getByPageAndConditions(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit,
                                    @RequestParam("name") String name, @RequestParam("idCard") String idCard,
                                    @RequestParam("department") String departmentName,
                                    @RequestParam("begindate") String beginDate) {

        HashMap<String, Object> result = service.getByPageAndConditions(page, limit, name, idCard, departmentName, beginDate);

        return new R("0", "success", result.get("resultList"), (String) result.get("resultCount"));
    }

    @PatchMapping
    public R workState(@RequestBody EmployeeRequest employee) {
        if (service.workState(employee)) {
            return new R("200", "success", null, null);
        } else {
            return new R("50X", "数据异常", null, null);
        }
    }

    //真删除-从数据库中完全删除信息
    //TODO:假删除，员工表增加delete字段，删除操作不做删除而是修改delete字段
    @DeleteMapping
    public R deleteByIds(@RequestBody String ids) {
        List<String> idList = JSON.parseArray(JSON.parseObject(ids).getString("ids"), String.class);
        service.deleteByIds(idList);
        return new R("200", "success", null, null);
    }

}
