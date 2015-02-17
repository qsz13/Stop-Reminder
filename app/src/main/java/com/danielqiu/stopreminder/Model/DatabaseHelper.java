package com.danielqiu.stopreminder.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.danielqiu.stopreminder.R;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by YY on 2015/2/17.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String DATABASE_NAME = "metro_new.db";

    private static final int DATABASE_VERSION = 1;

    private Dao<Station, Integer> idDao = null;
    private RuntimeExceptionDao<Station, Integer> idRuntimeExceptionDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onCreate");
            TableUtils.createTable(connectionSource, Station.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onUpgrade");
            TableUtils.dropTable(connectionSource, Station.class, true);

            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        }
    }

    public Dao<Station, Integer> getDao() throws SQLException {
        if (idDao == null) {
            idDao = getDao(Station.class);
        }
        return idDao;
    }

    public RuntimeExceptionDao<Station, Integer> getIdDao() {
        if (idRuntimeExceptionDao == null) {
            idRuntimeExceptionDao = getRuntimeExceptionDao(Station.class);
        }
        return idRuntimeExceptionDao;
    }
    @Override
    public void close() {
        super.close();
        idDao = null;
        idRuntimeExceptionDao = null;
    }
}