package com.example.exempel_api_xml;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final String API_KEY = "MY_API_KEY";
    private TextView cityText, sunText, setText, tempText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        cityText = findViewById(R.id.tv_city);
        sunText = findViewById(R.id.tv_sun);
        setText = findViewById(R.id.tv_set);
        tempText = findViewById(R.id.tv_temp);


        getData();
    }

    private void getData(){
        String city = "Karlstad";
        URL url;
        String apiString = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY + "&mode=xml";

        try {
            url = new URL(apiString);

            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserCreator.newPullParser();
            parser.setInput(url.openStream(), null);


            int parserEvent = parser.getEventType();
            String tagName;

            while(parserEvent != XmlPullParser.END_DOCUMENT){
                if(parserEvent == XmlPullParser.START_TAG){
                    tagName = parser.getName();

                    if(tagName.contains("city")){
                        String name = parser.getAttributeValue(null, "name");

                        cityText.setText("City: " + name);
                    }

                    if(tagName.contains("sun")){
                        String rise = parser.getAttributeValue(0);
                        String set = parser.getAttributeValue(1);

                        sunText.setText("Sun rise: " + rise);
                        setText.setText("Sun set: " + set);
                    }

                    if(tagName.contains("temperature")){
                        String temp = parser.getAttributeValue(null, "value");
                        float tempFloat = Float.parseFloat(temp);
                        float c = tempFloat - 273.15f;
                        tempText.setText("Temperature: " + c + "C");
                    }

                    Log.e("Tag name",  tagName);
                }


                parserEvent = parser.next();
            }
        }catch(Exception e){

        }
    }
}