package com.danielqiu.stopreminder.Activity;

import android.app.Activity;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

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
            mapActivity.setStationStart(url.split("-")[1]);
//            Log.i("metro", "start:"+url.split("-")[1]);
            return true;
        }
        else if(url.contains("selectStationDes-"))
        {
            mapActivity.setStationDes(url.split("-")[1]);
//            Log.i("metro", "end:"+stationID);
            return true;
        }



        return false;
    }



}
