package com.sungkang.crmsys.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResult {
    private Integer id;
    private String name;
    private String gender;
    private LocalDate birthday;
    @TableField("idCard")
    private String idcard;
    private String email;
    private String phone;
    private String departmentname;
    @TableField("workState")
    private String workstate;
    @TableField("beginDate")
    private LocalDate begindate;
}
