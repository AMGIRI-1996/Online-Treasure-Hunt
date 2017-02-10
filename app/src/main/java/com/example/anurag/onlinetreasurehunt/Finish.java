package com.example.anurag.onlinetreasurehunt;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

/**
 * Created by kapil on 17/3/16.
 */
public class Finish extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactus);
        TextView mytextview=(TextView)findViewById(R.id.txtcontactus);
        mytextview.setMovementMethod(new ScrollingMovementMethod());
        String sourceString = "<b><u><h2 style='color:red'>Thanks For Participating</h2></u></b> <br><br>" +
                "   Treasure Hunt is Over   " ;
        mytextview.setText(Html.fromHtml(sourceString));
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
