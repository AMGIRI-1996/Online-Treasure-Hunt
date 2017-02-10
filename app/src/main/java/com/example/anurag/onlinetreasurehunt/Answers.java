package com.example.anurag.onlinetreasurehunt;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

/**
 * Created by Anurag on 18-03-2016.
 */
public class Answers extends Activity {

    TextView scorecard;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoreboard);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        scorecard = (TextView) findViewById(R.id.scoreboard);
        scorecard.setText(pref.getString("answers", "Empty"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
