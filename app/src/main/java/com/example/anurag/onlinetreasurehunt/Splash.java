package com.example.anurag.onlinetreasurehunt;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.example.anurag.onlinetreasurehunt.R;

public class Splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        setContentView(R.layout.content_splash);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {

                    SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                    boolean check=pref.getBoolean("passwordMatch", false);
                    boolean end=pref.getBoolean("end", false);
                    if(end){
                        startActivity(new Intent("android.intent.action.End"));
                    }
                    if(check){
                        startActivity(new Intent("android.intent.action.Clues"));
                    }else{
                        startActivity(new Intent("android.intent.action.Home"));
                    }

                }
            }
        };
        timer.start();
    }
    @Override
    protected void onPause(){
        super.onPause();
        finish();                   //kill this activity on pause
    }
}
