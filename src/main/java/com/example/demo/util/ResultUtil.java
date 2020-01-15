package com.example.demo.util;

import com.example.demo.common.Result;
import com.example.demo.common.ResultCode;

/**
 * 封装请求信息
 */
public class ResultUtil {
    public static Result success(Object data,int resultCode) {
        return new Result(resultCode, "success", data);
    }

    public static Result fail() {
        return new Result(ResultCode.failed, "fail", null);
    }
}
