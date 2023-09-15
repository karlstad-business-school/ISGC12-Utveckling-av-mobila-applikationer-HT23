package com.example.exempel_background_service_async;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

public class MyAsyncTask extends AsyncTask<Void, Void, Void> {
    private Context ctx;
    private int id;

    public MyAsyncTask(Context ctx, int id){
        this.ctx = ctx;
        this.id = id;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        for(int i = 0; i < 10; i++){
            synchronized (this){
                try{
                    Log.d("MyService", "Waiting: " + i);
                    wait(1000);
                }catch(Exception e){
                    Log.e("MyService", "Error: " + e);
                }
            }
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);

        Intent intent = new Intent(ctx, MyBackgroundService.class);
        ctx.stopService(intent);
    }

}
