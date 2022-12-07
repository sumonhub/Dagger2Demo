package com.app.dagger2demo.data.model;

import java.util.ArrayList;

public class DataModel {
    ArrayList<User> data = new ArrayList<User>();

    public ArrayList<User> getData() {
        return data;
    }

    public void setData(ArrayList<User> data) {
        this.data = data;
    }
}
