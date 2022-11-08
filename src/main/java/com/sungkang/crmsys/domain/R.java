package com.sungkang.crmsys.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class R {
    private String code;
    private String info;
    private Object data;
    private String count;

    public R(Object data) {
        code = "501";
        info = "数据异常";
        this.data = data;
        count = null;
    }
}
