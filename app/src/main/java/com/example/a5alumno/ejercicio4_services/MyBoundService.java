package com.example.a5alumno.ejercicio4_services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

public class MyBoundService extends Service {
    private static final String TAG_STARTED_SERVICE = "In-StartedService";
    private String TAG = "BoundService";
    private final Random numGenerator = new Random();

    private IBinder myBinder = new MyBinder();
    public MyBoundService() {
    }

    public MyBoundService(IBinder whichBinder) {
        this.myBinder = whichBinder;
    }


    @Override
    public IBinder onBind(Intent intent){
        /*long endTime=  System.currentTimeMillis()+4000;
        long currentTime = System.currentTimeMillis();

        while(currentTime < endTime){
            currentTime = System.currentTimeMillis();
            Log.i(MyBoundService.TAG_STARTED_SERVICE,"Long time Bound service");
        }
        Log.e(TAG, "onBind done");*/
        t.start();
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return false;
    }

    public class MyBinder extends Binder {
        MyBoundService getService(){ return MyBoundService.this;}
    }

    public int getRandomNumber(){
        return this.numGenerator.nextInt(100);
    }

    Thread t= new Thread() {
        @Override
        public void run() {
            long endTime=  System.currentTimeMillis()+4000;
            long currentTime = System.currentTimeMillis();

            while(currentTime < endTime){
                currentTime = System.currentTimeMillis();
                Log.i(MyBoundService.TAG_STARTED_SERVICE,"Long time Bound service");
            }
            Log.e(TAG, "onBind done");
        }


    };
}
