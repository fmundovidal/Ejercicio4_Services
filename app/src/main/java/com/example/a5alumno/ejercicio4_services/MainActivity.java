package com.example.a5alumno.ejercicio4_services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView dispInfo_TextView;
    private EditText edtTextInput;
    MyBoundService mBoundService;

    boolean isBound=false;
    private ServiceConnection mSrvConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mBoundService = new MyBoundService(iBinder);
            isBound=true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button start_Service_Btn = (Button) this.findViewById(R.id.btnStartService);
        final Button Disp_Info_Btn = (Button) this.findViewById(R.id.btnDispInfo);
        final Button start_BoundService_Btn = (Button) this.findViewById(R.id.btnStartBoundService);
        final Button start_IntentService_Btn = (Button) this.findViewById(R.id.btnStartIntentService);

        start_BoundService_Btn.setOnClickListener(this);
        Disp_Info_Btn.setOnClickListener(this);
        start_Service_Btn.setOnClickListener(this);
        start_IntentService_Btn.setOnClickListener(this);

        this.dispInfo_TextView = (TextView) this.findViewById(R.id.txtViewAction);
        this.edtTextInput = (EditText) this.findViewById(R.id.edtTxtInputInfo);


    }

    @Override
    public void onClick(View view) {

        Intent intentStartSrv = new Intent(this, MyService.class);
        Intent bindIntent = new Intent(this,MyBoundService.class);
        Intent intentServ = new Intent(this, MyIntentService.class);

        switch(view.getId()){
            case R.id.btnDispInfo:
                if(!isBound)
                    if(!this.edtTextInput.getText().toString().isEmpty())
                        this.dispInfo_TextView.setText(this.edtTextInput.getText().toString());

                    else
                        this.dispInfo_TextView.setText(getString(R.string.txt_view_disclaimer));
                else
                    this.dispInfo_TextView.setText(Integer.toString(mBoundService.getRandomNumber()));
                break;
            case R.id.btnStartService:
                if(isBound)
                    unbindService(mSrvConnection);
                isBound=false;
                startService(intentStartSrv);
                unbindService(mSrvConnection);
                break;
            case R.id.btnStartBoundService:
                 bindService(bindIntent, mSrvConnection, Context.BIND_AUTO_CREATE);
                //t.start();
                break;
            case R.id.btnStartIntentService:
                if(isBound)
                    unbindService(mSrvConnection);
                isBound=false;
                startService(intentServ);
                break;
        }

    }

}
