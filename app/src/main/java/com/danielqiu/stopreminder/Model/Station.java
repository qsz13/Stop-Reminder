package com.danielqiu.stopreminder.Model;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by YY on 2015/2/17.
 */
@DatabaseTable(tableName = "station")
public class Station  {

    @DatabaseField(id = true)
    private Integer id;
    @DatabaseField
    private String name;

    public Station() { }

    public Station(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}