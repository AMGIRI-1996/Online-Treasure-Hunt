package com.example.anurag.onlinetreasurehunt;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

/**
 * Created by kapil on 17/3/16.
 */
public class ContactUs extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactus);
        TextView mytextview=(TextView)findViewById(R.id.txtcontactus);
        mytextview.setMovementMethod(new ScrollingMovementMethod());
        String sourceString = "<b><u><h2 style='color:red'>Contact Us</h2></u></b> <br>" +
                "In case you get stuck and need our help, or you have any query of any type.<br> <h5>Contact us at:<h5><br><br><h4><b>Anurag Giri  9555224774 </b></h4>"
                +"<br><h4><b>Anirudh Gupta   9045677424 </b></h4><br><h4><b>Kapil kumar  7404527768  </b></h4>";
        mytextview.setText(Html.fromHtml(sourceString));
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
