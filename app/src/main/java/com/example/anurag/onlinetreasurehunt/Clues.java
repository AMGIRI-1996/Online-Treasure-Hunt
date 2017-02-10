package com.example.anurag.onlinetreasurehunt;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anurag.onlinetreasurehunt.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class Clues extends Activity implements View.OnClickListener {
    TextView clue, team, questionNumber, Score;
    MediaPlayer player=null;
    EditText answer;
    Button ansBtn, QRCode,music;
    String score;
    String cQuestion, sQuestion, userAnswer;
    ImageView img;
    public static String EXTRA_MESSAGE = "com.example.kapil.xmling.message";

    String teamName;
    String questions[] = {"1.Three roads diverge in our college\n" +
            "You will take the one less travelled by\n" +
            "Move on and \n" +
            "That will make all the difference.\n",

            "2.Listen!!\n" +
                    "Keep your bags in bags rack. \n",

            "3.\tRound the room the knowledge fly\n" +
                    "looking for the place to land\n" +
                    " comes ultimately in our hand.\n",
            "4.Listen....",

            "5.\t#include<stdio.h>\n" +
                    "int main()\n" +
                    "{\n" +
                    "int i;\n" +
                    " for(i=3;i>=1;i--)\n" +
                    " {\n" +
                    "int i = 50;\n" +
                    " printf(\"%c\",i);\n" +
                    "    }\n" +
                    "  return (0);\n" +
                    "}\n",


            "6.\tWhere merry go round and swings go high \n" +
                    "there you put your metal toys ,say why?\n",
            "7.\tU will find me ; I bet u will\n" +
                    " because I  am not moving  I am still.\n",

            "8.\t I have keys but I don’t open a door.\n" +
                    " You can use me for files, info and much more. \n" +
                    "With me here are many more.\n",

            "9.\tIdentify the picture here\n" +
                    "Find QR code \n" +
                    "Guess  it is where?\n",
            "10.\tStanding in the hall of fame\n" +
                    " I see a drawing I wanna claim\n" +
                    "In which there are two eyes to see one world.\n",

            "11.\tI like the way you beg in front of me\n" +
                    " but my generosity depends  on my mood ,\n" +
                    "sometimes I am good and  sometimes I am rude.\n",






            "12.\tIt’s a tree but with no fruit\n" +
                    "  growing on a concrete floor.\n",

            "13.\t# include<stdio.h>\n" +
                    "int main()\n" +
                    "{\n" +
                    "\tprintf(\"%d\",printf(\"lt\"));\n" +
                    "printf(“ ”)\n" +
                    "}\n",




            "14.\tRing-a-ring o’ roses,\n" +
                    "A basket full of posies,\n" +
                    "a step a step \n" +
                    "and we all jump high.\n",

            "15.\tTo reach the success you must rise above all,\n" +
                    " keep trying to go higher and \n" +
                    "wish that closed door may fall.\n",

            "16.\tKeep your eyes wide open,\n" +
                    " it will be a problem\n" +
                    " if things  go  unnoticed.\n",

            "17.\tYou stare at me but I dont blush,\n" +
                    " and turn me off when you're in a rush.\n"

    };
    String answers[] = {
            "KICK4546",
            "NIHA0102",
            "OOPS3635",
            "FLIP9897",
            "CSGO0870",
            "CODE7890",
            "ASDF9092",
            "BNML6543",
            "QWER9093",
            "TERM7865",
            "PLAY2425",
            "ZXCV0987",
            "GHJK6061",
            "ANIR9040",
            "ANUP4950",
            "KAPI5623",
            "ISHQ0007"};
    int index = 1;
    Thread tr;
    int max=17;
    Context y;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.clues);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        cQuestion = pref.getString("question", "0");
        if (cQuestion.equals("0")) {
            Log.i("TAG", "index : hello");

            Toast.makeText(getApplicationContext(),
                    "Not yet Started",
                    Toast.LENGTH_LONG).show();
        }
        y = getApplicationContext();
        tr = new Thread() {
            @Override
            public void run() {
                qCheck(this);
            }

        };
        tr.start();
        init();


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void init() {
        clue = (TextView) findViewById(R.id.clue);
        team = (TextView) findViewById(R.id.team);
        Score = (TextView) findViewById(R.id.score);
        questionNumber = (TextView) findViewById(R.id.question);
        answer = (EditText) findViewById(R.id.answer);
        ansBtn = (Button) findViewById(R.id.ansBtn);
        QRCode = (Button) findViewById(R.id.QRCode);
        music = (Button) findViewById(R.id.music);
        img=(ImageView)findViewById(R.id.image);

        questionNumber.setVisibility(View.GONE);
        team.setVisibility(View.GONE);
        Score.setVisibility(View.GONE);
        img.setImageResource(R.drawable.audi);
        ansBtn.setOnClickListener(this);
        QRCode.setOnClickListener(this);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        if (pref.getBoolean("end", false)) {
            startActivity(new Intent("android.intent.action.End"));
        }

        teamName = pref.getString("team", "unknown");
        getScore();
        score = pref.getString("score", "0");
        Score.setText(score);
        team.setText(teamName);
        questionNumber.setText(cQuestion);
        int x;
        try {

            x= Integer.parseInt(cQuestion);
            if (x == 0) {

            } else {if(x==10)
            {
                String s="Standing in the hall of fame<br> I see a drawing I wanna claim<br>In which there <b><u>are two</u></b> eyes to <b><u>see one</u></b> world.";
                clue.setText(Html.fromHtml(s));
            }
                else
                clue.setText(questions[x - 1]);
            }
        } catch (Exception e) {

            x=0;

        }
        if(x>max){
            finish();
            startActivity(new Intent("android.intent.action.Finish"));
        }
        switch (x){
            case -1:
                finish();
                startActivity(new Intent("android.intent.action.Finish"));
                break;
            case 9:
                img.setVisibility(View.VISIBLE);
                break;
            case 4:
                music.setVisibility(View.VISIBLE);
                break;
            default:
                img.setVisibility(View.GONE);
                music.setVisibility(View.GONE);

        }


    }
    public void playMusic(View v)
    {
        if(player!=null)
        { player.release();
            player=null;}
        player= MediaPlayer.create(this, R.raw.many);
        player.start();


    }

    @Override
    public void onClick(View v) {
        /*String userAnswer = answer.getText().toString();
        boolean c=check(index, userAnswer);
        Intent i = new Intent(Clues.this, TakePhoto.class);
        Bundle b= new Bundle();
        b.putInt("index", index);
        b.putBoolean("right",c);
        i.putExtras(b);
        startActivity(i);*/
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        switch (v.getId()) {
            case R.id.ansBtn:

                getUserAnswer();
                if (!userAnswer.equals("")) {
                    Log.i("TAG", "index : hello");

                    Toast.makeText(getApplicationContext(),
                            "Submitted Succesfully",
                            Toast.LENGTH_LONG).show();
                    if (checkUserAnser()) {
                        Log.i("TAG", "index : hello");

                        Toast.makeText(getApplicationContext(),
                                "Correct Answer",
                                Toast.LENGTH_LONG).show();
                        updateScore();
                    } else {
                        Log.i("TAG", "index : hello");

                        Toast.makeText(getApplicationContext(),
                                "Wrong Answer",
                                Toast.LENGTH_LONG).show();
                        reduseScore();
                        getScore();

                        checkScore();
                    }
                } else {
                    Log.i("TAG", "index : hello");

                    Toast.makeText(getApplicationContext(),
                            "Field is empty",
                            Toast.LENGTH_LONG).show();
                }
                getScore();
                Score.setText(pref.getString("score", "0"));

                break;
            case R.id.QRCode:
                sendMessage(v);
                break;
        }
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, QRMainActivity.class);
        TextView editText = (TextView) findViewById(R.id.txt);
        String message = "send data";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, 101);

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            if (resultCode == RESULT_OK) {
                String stredittext = data.getStringExtra("edittextvalue");
                answer.setText(stredittext);
            }
        }
    }


    private void getScore() {
        SharedPreferences.Editor EPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext()).edit();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        new SiginActivity(this, EPref, pref, 1).execute("score", teamName, "http://www.treasurehunt.terratechnica.in/score.php");

    }

    private void checkScore() {
        SharedPreferences.Editor EPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext()).edit();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        score = pref.getString("score", "0");
      //  if(score==null)
        //    score= String.valueOf('0');
        int val;
        try {
             val=Integer.parseInt(score);
        }catch (NumberFormatException e){
          val=0;
        }
        if (val < 0) {
            EPref.putBoolean("end", true);
            EPref.commit();
            startActivity(new Intent("android.intent.action.End"));
        }

    }

    private void reduseScore() {
        SharedPreferences.Editor EPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext()).edit();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        new SiginActivity(this, EPref, pref, 5).execute(teamName, "http://www.treasurehunt.terratechnica.in/reduceScore.php");


    }

    private void updateScore() {
        SharedPreferences.Editor EPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext()).edit();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        new SiginActivity(this, EPref, pref, 4).execute(teamName, cQuestion, "http://www.treasurehunt.terratechnica.in/updateScore.php");


    }


    private void changeInDB() {

    }

    private boolean checkUserAnser() {
        int x = Integer.parseInt(cQuestion);
        if (userAnswer.equals(answers[x - 1])) {
            return true;
        } else {
            return false;
        }
    }

    private void getUserAnswer() {
        userAnswer = answer.getText().toString();
    }


    public void qCheck(Thread x) {
        while (true) {
            try {
                x.sleep(5000);

                SharedPreferences.Editor EPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext()).edit();
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                getScore();

                new SiginActivity(this, EPref, pref, 1).execute("question", "bhgh", "http://www.treasurehunt.terratechnica.in/question.php");
                sQuestion = pref.getString("question", "0");

                if (sQuestion.equals("0")) {
                    continue;
                }
                if (cQuestion.equals(sQuestion)) {
                    continue;
                } else {
                    cQuestion = sQuestion;
                    Intent i = new Intent("android.intent.action.Check");
                    startActivity(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        if (pref.getBoolean("end", false)) {
            finish();
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Clues Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.anurag.onlinetreasurehunt/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Clues Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.anurag.onlinetreasurehunt/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.appmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        SharedPreferences.Editor EPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext()).edit();
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        switch (item.getItemId()) {
            case R.id.aboutus:
                goToAboutUs();

                return true;

            case R.id.contactus:
                goToContactUs();

                return true;


            case R.id.scoreboard:
                new SiginActivity(this, EPref, pref, 1).execute("scoreboard", "bhgh", "http://www.treasurehunt.terratechnica.in/allScore.php");

                goToScoreboard();
                return true;



            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void goToAboutUs()
    {
        Intent intent = new Intent(this, AboutUs.class);

        startActivity(intent);


    }
    public void goToContactUs()
    {
        Intent intent = new Intent(this, ContactUs.class);

        startActivity(intent);


    }

    public void goToScoreboard()
    {

        Intent intent = new Intent("android.intent.action.Scoreboard");

        startActivity(intent);


    }

    public void goToAnswers()
    {
        Intent intent = new Intent(this, Answers.class);

        startActivity(intent);


    }
}