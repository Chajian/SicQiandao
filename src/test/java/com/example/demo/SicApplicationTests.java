package com.example.demo;

import com.example.demo.contorl.MyBatis;
import com.example.demo.data.ActivityRecord;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SicApplicationTests {

    @Test
    void contextLoads() {
        ActivityRecord activityRecord = new ActivityRecord();
        activityRecord.setUserid(1);
        activityRecord.setActivityid(10);
        MyBatis.getMyBatis().getQiandao().InsertRecord(activityRecord);
        MyBatis.getMyBatis().getQiandao().InsertRecord(activityRecord);
        MyBatis.getMyBatis().commit();
    }

}
