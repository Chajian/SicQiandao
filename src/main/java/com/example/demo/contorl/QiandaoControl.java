package com.example.demo.contorl;

import com.alibaba.fastjson.JSON;
import com.example.demo.business.QiandaoBusiness;
import com.example.demo.common.Result;
import com.example.demo.common.ResultCode;
import com.example.demo.dao.SicDao;
import com.example.demo.data.Activity;
import com.example.demo.data.ActivityRecord;
import com.example.demo.data.ActivityType;
import com.example.demo.data.User;
import com.example.demo.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController("/api")
public class QiandaoControl implements Qiandao {

    @Value("${prop.upload-folder}")

    private String UPLOAD_FOLDER;
//LoggerFactory
    private Logger logger = LoggerFactory.getLogger(QiandaoControl.class);

    @PostMapping(value = "qiandao")
    @ResponseBody
    public Result qiandao(Integer id,Integer activityid,HttpServletResponse response) throws IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        QiandaoBusiness qiandaoBusiness = new QiandaoBusiness();
        return qiandaoBusiness.qiandao(id,activityid);
    }


    @Override
    public List<Result> getActivityFormUser(Integer id, HttpServletResponse response) {
        List<Result> lists = new ArrayList<>();
        return null;
    }

    /**
     * 获取所有活动的信息学
     * @param response
     * @return
     */
    @GetMapping(value = "activities")
    @ResponseBody
    public List<Result> getActivities(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        List<Result> lists = new ArrayList<>();
        for(Activity activity:MyBatis.getMyBatis().getQiandao().getActivities()){
            try {
                Activity activity1 = (Activity) activity.clone();
                System.out.println(activity.toString());
                activity1.setPicture_path("http://localhost:8081/Sic/bean/"+activity.getPicture_path());
                Result result = new Result(ResultCode.GET_ACTIVITY,activity1.getActivity_name(),activity1);
                lists.add(result);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return lists;
    }


    @CrossOrigin
    @PostMapping("/inputFile")
    public Result singleFileUpload(MultipartFile file,String name) {
        System.out.println(name);
        if (Objects.isNull(file) || file.isEmpty()) {
//            logger.error("文件为空");
//            System.out.println("文件为空");
            return ResultUtil.fail();
        }
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
            //如果没有files文件夹，则创建
            if (!Files.isWritable(path)) {
                Files.createDirectories(Paths.get(UPLOAD_FOLDER));
            }
            //文件写入指定路径
//            System.out.println("文件路径"+path.getFileName()+":"+UPLOAD_FOLDER);
            Files.write(path, bytes);
            return ResultUtil.success(null,ResultCode.NEW_ACTIVITY);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.fail();
        }
    }

    @PostMapping(value = "newActivity")
    public Result newActivity(String name,String descrip,int activitytype,String picturepath,HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Activity activity = new Activity();
        activity.setActivity_name(name);
        activity.setActivity_description(descrip);
        activity.setPicture_path(picturepath);
        activity.setType(activitytype);
        System.out.println(name);
        SicDao qiandao = MyBatis.getMyBatis().getQiandao();
        if(qiandao.getActivitybyName(name)==null||!qiandao.getActivitybyName(name)) {
            MyBatis.getMyBatis().getQiandao().addActivity(activity);
            MyBatis.getMyBatis().commit();
            System.out.println("新建成功");
            return ResultUtil.success(null,ResultCode.NEW_ACTIVITY);
        }
        else
            return ResultUtil.fail();
    }

    //    @PostMapping(value = "qiandao")
//    @ResponseBody
//    public Result test(Integer id,Integer activityid,HttpServletResponse response) throws IOException {
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        QiandaoBusiness qiandaoBusiness = new QiandaoBusiness();
//        return qiandaoBusiness.qiandao(id,activityid);
//    }
}
