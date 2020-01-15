package com.example.demo.data;

import java.io.Serializable;

public class ActivityRecord implements Serializable {
    public static final Long seriaUID = 567L;
    private int userid;
    private int activityid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getActivityid() {
        return activityid;
    }

    public void setActivityid(int activityid) {
        this.activityid = activityid;
    }

    @Override
    public String toString() {
        return "ActivityRecord{" +
                "userid=" + userid +
                ", activityid=" + activityid +
                '}';
    }
}
