package com.danielqiu.stopreminder.Model;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by YY on 2015/2/17.
 */
@DatabaseTable(tableName = "line")
public class Line {

    @DatabaseField
    private int id;
    @DatabaseField
    private String name;
    @DatabaseField
    private boolean is_circle;
    @DatabaseField
    private String station;

    public Line() {}

    public Line(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIs_circle() {
        return is_circle;
    }

    public void setIs_circle(boolean is_circle) {
        this.is_circle = is_circle;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }




}
