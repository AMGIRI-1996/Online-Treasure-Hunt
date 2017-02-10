package com.example.anurag.onlinetreasurehunt;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

/**
 * Created by Anurag on 17-03-2016.
 */
public class End extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    ends();

                }
            }
        };
        timer.start();

    }

    private void ends() {
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }


}
