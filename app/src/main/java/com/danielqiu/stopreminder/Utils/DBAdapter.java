//package com.danielqiu.stopreminder.Utils;
//
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteException;
//
//import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;
//import java.io.File;
//
///**
// * Created by danielqiu on 2/9/15.
// */
//public class DBAdapter extends SQLiteAssetHelper {
//    private SQLiteDatabase db;
//    private static final String DATABASE_NAME = "metro.db";
//    private static final int DATABASE_VERSION = 1;
//    public DBAdapter(Context context)
//    {
//        super(context, DATABASE_NAME, null, DATABASE_VERSION);
//        db = getReadableDatabase();
//
//    }
//
//    public Cursor queryLineInfo()
//    {
//        Cursor localCursor = this.db.rawQuery("select * from LineInfo", null);
//        if (localCursor == null)
//            localCursor = null;
//        return localCursor;
//    }
//
//    public Cursor queryRouteInfo(String selectOri, String selectDes)
//    {
//        Cursor cursor = this.db.rawQuery("select * from Route where OriginStationID = " + selectOri + " and DestinationStationID =" + selectDes, null);
//        String passStations = cursor.getString(cursor.getColumnIndex("PassStations"));
//        String icTimes = cursor.getString(cursor.getColumnIndex("ICTimes"));
//        String time = cursor.getString(cursor.getColumnIndex("Time"));
//        String fare = cursor.getString(cursor.getColumnIndex("Fare"));
//        String stations = cursor.getString(cursor.getColumnIndex("Stations"));
////        String str6 = Constants.correctTime(localCursor.getString(localCursor.getColumnIndex("FirstDeparture")));
////        String str7 = Constants.correctTime(localCursor.getString(localCursor.getColumnIndex("LastDeparture")));
//
//    }
//
//
//}
