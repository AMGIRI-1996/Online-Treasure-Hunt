package com.example.anurag.onlinetreasurehunt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Anurag on 18-03-2016.
 */
public class Check extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check);
        Intent i=new Intent("android.intent.action.Clues");
        startActivity(i);
    }

}
