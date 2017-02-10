package com.example.anurag.onlinetreasurehunt;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;



/**
 * Created by kapil on 17/3/16.
 */
public class InitializeScanner extends AppCompatActivity{


    public static String EXTRA_MESSAGE="com.example.kapil.xmling.message";

    MediaPlayer player=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionactivity);
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
            if(resultCode == RESULT_OK){
                String stredittext=data.getStringExtra("edittextvalue");
                TextView editText = (TextView) findViewById(R.id.txt);
                editText.setText(stredittext);
            }
        }
    }


    public void playMusic(View v)
    {
if(player!=null)
{ player.release();
       player=null;}
         player=MediaPlayer.create(this,R.raw.many);
player.start();


    }


    @Override
    protected void onPause() {
        super.onPause();
       if(player!=null)
player.release();

    }







    private int group1Id = 1;

    int testId = Menu.FIRST;

    int aboutusId = Menu.FIRST +1;
    int contactusId = Menu.FIRST +2;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.appmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.aboutus:
                 goToAboutUs();
                Toast msg = Toast.makeText(this, "Menu 1", Toast.LENGTH_LONG);
                msg.show();
                return true;

            case R.id.contactus:
                goToContactUs();

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


}

