package com.danielqiu.stopreminder.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.android.DatabaseTableConfigUtil;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.TableUtils;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.sql.SQLException;

/**
 * Created by YY on 2015/2/17.
 */
public class DatabaseHelper extends SQLiteAssetHelper {

    protected AndroidConnectionSource mConnectionSource = new AndroidConnectionSource(this);

    private static final String DATABASE_NAME = "metro_new.db";

    private static final int DATABASE_VERSION = 1;

    private Dao<Station, Integer> stationDao = null;
    private Dao<Station, Integer> lineDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

//    @Override
//    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
//        try {
//            Log.i(DatabaseHelper.class.getName(), "onCreate");
//            TableUtils.createTable(connectionSource, Station.class);
//            TableUtils.createTable(connectionSource, Line.class);
//
//        } catch (SQLException e) {
//            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
//            throw new RuntimeException(e);
//        }
//
//
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
//        try {
//            Log.i(DatabaseHelper.class.getName(), "onUpgrade");
//            TableUtils.dropTable(connectionSource, Station.class, true);
//            TableUtils.dropTable(connectionSource, Line.class, true);
//            onCreate(db, connectionSource);
//        } catch (SQLException e) {
//            Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
//            throw new RuntimeException(e);
//        }
//    }


    public Dao<Station, Integer> getStationDao() throws SQLException {
        if (stationDao == null) {
            stationDao = getDao(Station.class);

        }

        return stationDao;

    }



    private <D extends Dao<T, ?>, T> D getDao(Class<T> clazz) throws SQLException {
        // lookup the dao, possibly invoking the cached database config
        Dao<T, ?> dao = DaoManager.lookupDao(mConnectionSource, clazz);
        if (dao == null) {
            // try to use our new reflection magic
            DatabaseTableConfig<T> tableConfig = DatabaseTableConfigUtil.fromClass(mConnectionSource, clazz);
            if (tableConfig == null) {
                dao = (Dao<T, ?>) DaoManager.createDao(mConnectionSource, clazz);
            } else {
                dao = (Dao<T, ?>) DaoManager.createDao(mConnectionSource, tableConfig);
            }
        }

        @SuppressWarnings("unchecked")
        D castDao = (D) dao;
        return castDao;
    }

    @Override
    public void close() {
        super.close();
        stationDao = null;
    }
}