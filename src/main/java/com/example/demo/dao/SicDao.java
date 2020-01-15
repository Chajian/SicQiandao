package com.example.demo.dao;

import com.example.demo.data.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 签到数据库接口
 */
public interface SicDao {

//    public User getUser(int id);

    public Activity getActivity(int id);

    public Item getItem(int id);

    public ActivityRecord getRecord(int activity_id,int user_id);

    public void InsertRecord(ActivityRecord activityRecord);

    public void addUser(User user);

    public User getUser(String account);

    public Boolean login(String account,String pass);

    public List<Activity> getActivities();

    public void addActivity(Activity activity);

    public Boolean getActivitybyName(String activity_name);

}
