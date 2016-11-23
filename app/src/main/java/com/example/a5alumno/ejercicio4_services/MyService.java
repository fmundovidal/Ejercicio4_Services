package com.example.a5alumno.ejercicio4_services;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG_STARTED_SERVICE = "In-StartedService";

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {


        long endTime=  System.currentTimeMillis()+4000;
        long currentTime = System.currentTimeMillis();

        while(currentTime < endTime){
            currentTime = System.currentTimeMillis();
            Log.i(MyService.TAG_STARTED_SERVICE,"Long time service");
        }
        return Service.START_NOT_STICKY;
    }
}
