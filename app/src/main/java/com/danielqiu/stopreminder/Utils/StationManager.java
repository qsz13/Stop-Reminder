//package com.danielqiu.stopreminder.Utils;
//
//import android.content.Context;
//import android.database.Cursor;
//
//import com.danielqiu.stopreminder.Model.Line;
//import com.danielqiu.stopreminder.Model.Station;
//
//import java.util.ArrayList;
//
///**
//* Created by danielqiu on 2/9/15.
//*/
//public class StationManager extends ArrayList<Line> {
//
//    private static StationManager mSingleton;
//    private boolean isLineLoaded = false;
//    public ArrayList<Station> mStation = new ArrayList();
//
//    public static StationManager getSingleton()
//    {
//        if (mSingleton == null)
//            mSingleton = new StationManager();
//        return mSingleton;
//    }
//
//
//    public Station getStationByID(String paramString)
//    {
//        for (int i = 0; ; i++)
//        {
//            if (i >= this.mStation.size())
//                return null;
//            if (((Station)this.mStation.get(i)).getStationID().equals(paramString))
//                return (Station)this.mStation.get(i);
//        }
//    }
//
//
//    public final void loadAllStations(Context context)
//    {
//
//
//    }
//
//}
//
