package com.danielqiu.stopreminder;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.danielqiu.stopreminder.Model.DatabaseHelper;
import com.j256.ormlite.android.apptools.OpenHelperManager;

/**
 * Created by YY on 2015/2/17.
 */
public class App extends Application {

    private static Context context;
    private static DatabaseHelper databaseHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        App.context = getApplicationContext();
        databaseHelper = OpenHelperManager.getHelper(context,DatabaseHelper.class);
    }

    public static Context getAppContext() {return App.context;}
    public static DatabaseHelper getDatabase() {return App.databaseHelper;}





}
