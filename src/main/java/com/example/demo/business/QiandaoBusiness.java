package com.example.demo.business;

import com.example.demo.common.Result;
import com.example.demo.common.ResultCode;
import com.example.demo.contorl.MyBatis;
import com.example.demo.dao.SicDao;
import com.example.demo.data.ActivityRecord;
import com.example.demo.data.ActivityType;
import com.example.demo.data.User;
import com.example.demo.util.ResultUtil;

public class QiandaoBusiness {


    public Result qiandao(int userid, int activityid){
        SicDao myBatis =  MyBatis.getMyBatis().getQiandao();
        User user = myBatis.getUser(userid+"");
        if(user != null)
            if(myBatis.getRecord(ActivityType.qiandao,user.getId())==null) {
                ActivityRecord activityRecord = new ActivityRecord();
                activityRecord.setUserid(activityid);
                activityRecord.setActivityid(0);
                myBatis.InsertRecord(activityRecord);
                MyBatis.getMyBatis().commit();
                return ResultUtil.success(user, ResultCode.GET_QIANDAO);
            }
        return ResultUtil.fail();
    }

//    public Result qiandao(int userid, int activityid){
//        SicDao myBatis =  MyBatis.getMyBatis().getQiandao();
//        User user = myBatis.getUser(userid);
//        if(user != null)
//            if(myBatis.getRecord(ActivityType.qiandao,user.getId())==null) {
//                ActivityRecord activityRecord = new ActivityRecord();
//                activityRecord.setUserid(activityid);
//                activityRecord.setActivityid(userid);
//                myBatis.InsertRecord(activityRecord);
//                MyBatis.getMyBatis().commit();
//                return ResultUtil.success(user);
//            }
//        return ResultUtil.fail();
//    }


}
