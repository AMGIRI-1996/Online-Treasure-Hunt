package com.example.anurag.onlinetreasurehunt;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.anurag.onlinetreasurehunt.R;

/**
 * Created by sarfraz on 23-02-2016.
 */
public class Home extends Activity implements View.OnClickListener{
    EditText pass,team;
    Button passBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        if(pref.getBoolean("end",false)) {
            startActivity(new Intent("android.intent.action.End"));
        }
        intitialize();
    }

    private void intitialize() {
        pass = (EditText)findViewById(R.id.pass);
        team=(EditText)findViewById(R.id.team);
        passBtn = (Button)findViewById(R.id.passBtn);
        passBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String userPass = pass.getText().toString();
        String teamName = team.getText().toString();
        int score;
        if(userPass.contentEquals("THUNT1234")){
            SharedPreferences.Editor EPref= PreferenceManager.getDefaultSharedPreferences(getBaseContext()).edit();

            SharedPreferences pref= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            score=pref.getInt("score", 0);


           // int flag=0;
           // while (flag==0) {
                new SiginActivity(this, EPref, pref, 3).execute(teamName, score + " ", "http://www.treasurehunt.terratechnica.in/insert.php");

              /*  switch (pref.getString("enterTeam", "")) {
                    case "updated_score":
                        flag = 1;
                        break;
                    case "score_update_failed":
                        flag = 0;
                        break;
                    case "inserted":
                        flag = 1;
                        break;
                    case "insert_failed":
                        flag = 0;
                        break;
                    case "query_failed":
                        flag = 0;
                        break;

                }
            }
            if(flag==1) {*/
                EPref.putString("team", teamName);
                EPref.commit();
                EPref.putBoolean("passwordMatch", true);
                EPref.commit();
                Intent i = new Intent("android.intent.action.Clues");
                startActivity(i);
            //}


        } else {
            Log.i("TAG", "index : hello");

            Toast.makeText(getApplicationContext(),
                    "Wrong Password",
                    Toast.LENGTH_LONG).show();
        }
    }
}
