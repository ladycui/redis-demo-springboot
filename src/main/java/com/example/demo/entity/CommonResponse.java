package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Cui Yanna on 2019/6/27
 */
@Data
@Getter
@Setter
public class CommonResponse {
    int code;
    String msg;

    public CommonResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
