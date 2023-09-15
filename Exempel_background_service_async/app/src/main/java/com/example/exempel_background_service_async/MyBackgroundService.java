package com.example.exempel_background_service_async;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyBackgroundService extends Service {

    @Override
    public void onStart(Intent intent, int startId){
        Log.e("TAG", "onStart: ");
        MyAsyncTask mat = new MyAsyncTask(this, startId);
        mat.execute();
    }

    public void onDestroy(){
        Log.d("MyService", "Service is now dead");
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
