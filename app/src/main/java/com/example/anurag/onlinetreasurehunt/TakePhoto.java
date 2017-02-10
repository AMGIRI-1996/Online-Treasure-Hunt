package com.example.anurag.onlinetreasurehunt;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anurag.onlinetreasurehunt.R;

public class TakePhoto extends Activity implements View.OnClickListener{
    ImageView img;
    ImageButton imgBtn;
    Button submitImg;
    Intent i;
    Bitmap bmp;
    int index;
    boolean c;
    TextView gotIndex;
    String msg;
    final static int cameraData = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.take_photo);
        initializevars();
        receive();
    }

    private void receive() {
        Bundle gotBasket = getIntent().getExtras();
        index = gotBasket.getInt("index");
        c = gotBasket.getBoolean("right");
        msg = String.format("Index received is %d", index);
        gotIndex.setText(msg);
    }

    private void initializevars() {
        img = (ImageView)findViewById(R.id.imageView);
        imgBtn = (ImageButton)findViewById(R.id.ib);
        submitImg = (Button)findViewById(R.id.submitImg);
        gotIndex = (TextView)findViewById(R.id.tv);
        imgBtn.setOnClickListener(this);
        submitImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib:
                i= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, cameraData);
                break;
            case R.id.submitImg:
                if(c){
                    index++;
                    //send this data to server
                    Log.i("TAG", "index1 : submitted");
                    Toast.makeText(getApplicationContext(),
                            "Answer Submitted Successfully",
                            Toast.LENGTH_LONG).show();
                    startActivity(new Intent("android.intent.action.Clues"));
                }else{
                    Log.i("TAG", "index1 : submitted");
                    Toast.makeText(getApplicationContext(),
                            "Uff..!! You Missed",
                            Toast.LENGTH_LONG).show();
                    finish();
                }
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            bmp = (Bitmap)extras.get("data");
            img.setImageBitmap(bmp);
        }

    }
}