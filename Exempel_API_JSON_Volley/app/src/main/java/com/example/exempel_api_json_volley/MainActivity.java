package com.example.exempel_api_json_volley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements VolleyCallback{

    //https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY + "&mode=json

    private APICall apiCall;
    private TextView cityTV, skyTV, tempTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityTV = findViewById(R.id.city_tv);
        skyTV = findViewById(R.id.sky_tv);
        tempTV = findViewById(R.id.temp_tv);

        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024);
        Network network = new BasicNetwork(new HurlStack());
        RequestQueue requestQueue = new RequestQueue(cache, network);
        requestQueue.start();

        String API_KEY = "d50be115ef1adabf05de20350eff1cd7";
        String city = "Karlstad";
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY + "&mode=json";

        apiCall = new APICall();

        apiCall.get(requestQueue, this, url);

    }

    @Override
    public void onSuccess(JSONObject object) {
        try{
            Log.e("TAG", object.toString());
            String name = object.get("name").toString();
            String temp = object.getJSONObject("main").get("temp").toString();

            JSONArray weather = object.getJSONArray("weather");
            String sky = weather.getJSONObject(0).get("main").toString();

            cityTV.setText(name);
            tempTV.setText(temp);
            skyTV.setText(sky);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(Exception e) {
        Log.e("MAIN ACTIVITY!", "onFailure: " + e.toString());
    }
}