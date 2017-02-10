package com.example.anurag.onlinetreasurehunt;
import android.app.Activity;
import android.os.Bundle;

/**
 * Created by kapil on 17/3/16.
 */
public class AboutUs extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
