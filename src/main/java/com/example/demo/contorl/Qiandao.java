package com.example.demo.contorl;

import com.example.demo.common.Result;
import com.example.demo.data.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface Qiandao {

    Result qiandao(Integer id,Integer activityid, HttpServletResponse response) throws SQLException, IOException;

    List<Result> getActivityFormUser(Integer id,HttpServletResponse response);

}
