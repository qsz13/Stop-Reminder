package com.danielqiu.stopreminder.Activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.danielqiu.stopreminder.R;
//import com.danielqiu.stopreminder.Utils.DBAdapter;
//import com.danielqiu.stopreminder.Utils.StationManager;


public class MapActivity extends Activity {

    private WebView mapWebView;
    private String stationStart = "";
    private String stationDes = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMapWebView();



    }


    @SuppressLint({"SetJavaScriptEnabled"})
    private void initMapWebView()
    {
        mapWebView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = mapWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mapWebView.getSettings().setBuiltInZoomControls(true);
        mapWebView.getSettings().setDisplayZoomControls(false);
        mapWebView.getSettings().setUseWideViewPort(true);
        mapWebView.setInitialScale(50);
        mapWebView.loadUrl("file:///android_asset/metromap/route_map.htm");
        MapWebViewClient webViewClient = new MapWebViewClient();
        webViewClient.setMapActivity(this);
        mapWebView.setWebViewClient(webViewClient);
    }

    public void setStationStart(String stationStart) {
        this.stationStart = stationStart;
    }

    public void setStationDes(String stationDes) {
        this.stationDes = stationDes;
    }






}
