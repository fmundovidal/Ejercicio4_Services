package com.example.a5alumno.ejercicio4_services;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    private static final String TAG_STARTED_SERVICE = "In-StartedService";
    public MyIntentService(){
        super(MyIntentService.class.getName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        long endTime=  System.currentTimeMillis()+4000;
        long currentTime = System.currentTimeMillis();

        while(currentTime < endTime){
            currentTime = System.currentTimeMillis();
            Log.i(MyIntentService.TAG_STARTED_SERVICE,"Long time Intent service");
        }
    }

}
