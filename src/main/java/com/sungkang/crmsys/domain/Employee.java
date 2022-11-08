package com.sungkang.crmsys.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 出生日期
     */
    private LocalDate birthday;

    /**
     * 身份证号
     */
    @TableField("idCard")
    private String idcard;

    /**
     * 婚姻状况
     */
    private String wedlock;

    /**
     * 民族
     */
    @TableField("nationId")
    private Integer nationid;

    /**
     * 籍贯
     */
    @TableField("nativePlace")
    private String nativeplace;

    /**
     * 政治面貌
     */
    @TableField("politicId")
    private Integer politicid;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 所属部门
     */
    @TableField("departmentId")
    private Integer departmentid;

    /**
     * 职称ID
     */
    @TableField("jobLevelId")
    private Integer joblevelid;

    /**
     * 职位ID
     */
    @TableField("posId")
    private Integer posid;

    /**
     * 聘用形式
     */
    @TableField("engageForm")
    private String engageform;

    /**
     * 最高学历
     */
    @TableField("tiptopDegree")
    private String tiptopdegree;

    /**
     * 所属专业
     */
    private String specialty;

    /**
     * 毕业院校
     */
    private String school;

    /**
     * 入职日期
     */
    @TableField("beginDate")
    private LocalDate begindate;

    /**
     * 在职状态
     */
    @TableField("workState")
    private String workstate;

    /**
     * 工号
     */
    @TableField("workID")
    private String workid;

    /**
     * 合同期限
     */
    @TableField("contractTerm")
    private Double contractterm;

    /**
     * 转正日期
     */
    @TableField("conversionTime")
    private LocalDate conversiontime;

    /**
     * 离职日期
     */
    @TableField("notWorkDate")
    private LocalDate notworkdate;

    /**
     * 合同起始日期
     */
    @TableField("beginContract")
    private LocalDate begincontract;

    /**
     * 合同终止日期
     */
    @TableField("endContract")
    private LocalDate endcontract;

    /**
     * 工龄
     */
    @TableField("workAge")
    private Integer workage;


}
