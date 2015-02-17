package com.danielqiu.stopreminder.Activity;

import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by danielqiu on 2/9/15.
 */
public class MapWebViewClient extends WebViewClient {

    private MapActivity mapActivity;
    public void setMapActivity(MapActivity mapActivity) {
        this.mapActivity = mapActivity;
    }



    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url)
    {
        if (url.contains("selectStationStart-"))
        {
            mapActivity.setStationStartID(url.split("-")[1]);
            Log.w("metro", "start:" + url.split("-")[1]);
            return true;
        }
        else if(url.contains("selectStationDes-"))
        {
            mapActivity.setStationDesID(url.split("-")[1]);
            Log.w("metro", "end:"+ url.split("-")[1]);
            return true;
        }



        return false;
    }



}
