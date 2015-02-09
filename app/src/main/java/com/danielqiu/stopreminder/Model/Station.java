package com.danielqiu.stopreminder.Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by danielqiu on 2/6/15.
 */
public class Station implements Serializable {

    private String stationID;
    private String nameChs;
    private String namePY;
    private double latitude;
    private double longitude;
    private int position;
    private int mapX;
    private int mapY;
    private ArrayList<Line> linesBelongsTo;



    public String getName()
    {
        return this.nameChs;
    }


}
