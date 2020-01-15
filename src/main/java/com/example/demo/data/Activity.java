package com.example.demo.data;

import java.io.Serializable;

public class Activity implements Serializable,Cloneable {
    public static final Long seriaUID = 456L;
    private int id;
    private int type;
    private String activity_name;
    private String activity_description;
    private String picture_path;
    private int join_nummber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public String getActivity_description() {
        return activity_description;
    }

    public void setActivity_description(String activity_description) {
        this.activity_description = activity_description;
    }

    public int getJoin_nummber() {
        return join_nummber;
    }

    public void setJoin_nummber(int join_nummber) {
        this.join_nummber = join_nummber;
    }

    public String getPicture_path() {
        return picture_path;
    }

    public void setPicture_path(String picture_path) {
        this.picture_path = picture_path;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", type=" + type +
                ", activity_name='" + activity_name + '\'' +
                ", activity_description='" + activity_description + '\'' +
                ", picture_path='" + picture_path + '\'' +
                ", join_nummber=" + join_nummber +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Object o = null;
        o = super.clone();
        return o;
    }
}
