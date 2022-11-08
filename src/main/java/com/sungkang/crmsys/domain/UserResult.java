package com.sungkang.crmsys.domain;

import lombok.Data;

@Data
public class UserResult {
    Hr userinfo;

    public UserResult(Hr userinfo) {
        this.userinfo = userinfo;
    }
}
