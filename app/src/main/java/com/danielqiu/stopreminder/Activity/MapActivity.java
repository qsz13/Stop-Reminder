package com.danielqiu.stopreminder.Activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.danielqiu.stopreminder.App;
import com.danielqiu.stopreminder.Model.DatabaseHelper;
import com.danielqiu.stopreminder.Model.Station;
import com.danielqiu.stopreminder.R;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;


public class MapActivity extends Activity {

    private WebView mapWebView;
    private String stationStartID = "";
    private String stationDesID = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMapWebView();

        Station station = null;
        try {
            station = App.getDatabase().getStationDao().queryForId(164);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(station==null)
        {
            Log.i("","null");
        }

        Log.i("db",station.getName());
    }


    @SuppressLint({"SetJavaScriptEnabled"})
    private void initMapWebView()
    {
        mapWebView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = mapWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setUseWideViewPort(true);
        mapWebView.setInitialScale(50);
        mapWebView.loadUrl("file:///android_asset/metromap/route_map.htm");
        MapWebViewClient webViewClient = new MapWebViewClient();
        webViewClient.setMapActivity(this);
        mapWebView.setWebViewClient(webViewClient);
    }

    public void setStationStartID(String stationStartID) {
        this.stationStartID = stationStartID;
    }

    public void setStationDesID(String stationDesID) {
        this.stationDesID = stationDesID;
    }






}
