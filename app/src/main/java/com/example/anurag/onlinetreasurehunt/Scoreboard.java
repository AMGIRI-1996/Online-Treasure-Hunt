package com.example.anurag.onlinetreasurehunt;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

/**
 * Created by Anurag on 18-03-2016.
 */
public class Scoreboard extends Activity {

    TextView scorecard;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scoreboard);

         scorecard=(TextView)findViewById(R.id.scoreboardtxt);
       /*new SiginActivity(this,scorecard,1).execute("scoreboard","asd","http://www.treasurehunt.terratechnica.in/allScore.php");
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        scorecard.setText(pref.getString("scoreboard","Empty"));*/
String source="You can see Real-Time Scores of all the Team by<br> <a href='http://www.treasurehunt.terratechnica.in/allScore.php'>Clicking Here!!!</a>";

      //String source="asd";
       scorecard.setText(Html.fromHtml(source));
       scorecard.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    private void setScoreBoard(String score)
    {
       scorecard.setText(scorecard.getText()+"\n"+score);

    }
}
