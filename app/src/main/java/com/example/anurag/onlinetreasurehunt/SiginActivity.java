package com.example.anurag.onlinetreasurehunt;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class SiginActivity extends AsyncTask<String,Void,String>{

    private Context context;
    TextView t;
    private int byGetOrPost = 0;
    SharedPreferences.Editor EPref;
    SharedPreferences pref;
    String type;
    int which;

    //flag 0 means get and 1 means post.(By default it is get.)
    public SiginActivity(Context context,SharedPreferences.Editor EPref,SharedPreferences pref,  int flag) {
        which=1;
        this.context = context;
        this.EPref=EPref;
        this.pref=pref;
        byGetOrPost = flag;
    }
    public SiginActivity(Context context,TextView x,  int flag) {
        which=2;
        this.context = context;
        this.t=x;
        byGetOrPost = flag;
    }

    protected void onPreExecute(){

    }

    @Override
    protected String doInBackground(String... arg0) {
        if(byGetOrPost == 0){ //means by Get Method

            try{
                String team = (String)arg0[0];
                String question = (String)arg0[1];
                String time = (String)arg0[2];
                String link = (String)arg0[3];
                link += "?team="+team+"&question="+question;
                type="update";
                URL url = new URL(link);
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI(link));
                HttpResponse response = client.execute(request);
                BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                StringBuffer sb = new StringBuffer("");
                String line="";

                while ((line = in.readLine()) != null) {
                    sb.append(line);
                    break;
                }
                in.close();
                return sb.toString();
            }

            catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }
        else if(byGetOrPost ==1){
            try{
                String username = (String)arg0[0];
                String team = (String)arg0[1];
                String link = (String)arg0[2];
                type=username;
                String data  = URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8");
                data += "&" + URLEncoder.encode("team", "UTF-8") + "=" + URLEncoder.encode(team, "UTF-8");

                URL url = new URL(link);
                URLConnection conn = url.openConnection();

                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                wr.write( data );
                wr.flush();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                StringBuilder sb = new StringBuilder();
                String line = null;

                // Read Server Response
                while((line = reader.readLine()) != null)
                {
                    sb.append(line);
                    break;
                }
                return sb.toString();
            }
            catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }else if(byGetOrPost==2){
            try{
                String team = (String)arg0[0];
                String question = (String)arg0[1];
                String link = (String)arg0[2];
                type="answerUpdate";
                String data  = URLEncoder.encode("team", "UTF-8") + "=" + URLEncoder.encode(team, "UTF-8");
                data += "&" + URLEncoder.encode("question", "UTF-8") + "=" + URLEncoder.encode(question, "UTF-8");

                URL url = new URL(link);
                URLConnection conn = url.openConnection();

                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                wr.write( data );
                wr.flush();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                StringBuilder sb = new StringBuilder();
                String line = null;

                // Read Server Response
                while((line = reader.readLine()) != null)
                {
                    sb.append(line);
                    break;
                }
                return sb.toString();
            }
            catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }else if(byGetOrPost==3){
            try{
                String team = (String)arg0[0];
                String score = (String)arg0[1];
                String link = (String)arg0[2];
                type="enterTeam";
                String data  = URLEncoder.encode("team", "UTF-8") + "=" + URLEncoder.encode(team, "UTF-8");
                data += "&" + URLEncoder.encode("score", "UTF-8") + "=" + URLEncoder.encode(score, "UTF-8");

                URL url = new URL(link);
                URLConnection conn = url.openConnection();

                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                wr.write( data );
                wr.flush();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                StringBuilder sb = new StringBuilder();
                String line = null;

                // Read Server Response
                while((line = reader.readLine()) != null)
                {
                    sb.append(line);
                    break;
                }
                return sb.toString();
            }
            catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }else if(byGetOrPost==4){
            try{
                String team = (String)arg0[0];
                String question = (String)arg0[1];
                String link = (String)arg0[2];
                type="enterTeam";
                String data  = URLEncoder.encode("team", "UTF-8") + "=" + URLEncoder.encode(team, "UTF-8");
                data += "&" + URLEncoder.encode("question", "UTF-8") + "=" + URLEncoder.encode(question, "UTF-8");

                URL url = new URL(link);
                URLConnection conn = url.openConnection();

                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                wr.write( data );
                wr.flush();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                StringBuilder sb = new StringBuilder();
                String line = null;

                // Read Server Response
                while((line = reader.readLine()) != null)
                {
                    sb.append(line);
                    break;
                }
                return sb.toString();
            }
            catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }else if(byGetOrPost==5){
            try{
                String team = (String)arg0[0];

                String link = (String)arg0[1];
                type="enterTeam";
                String data  = URLEncoder.encode("team", "UTF-8") + "=" + URLEncoder.encode(team, "UTF-8");

                URL url = new URL(link);
                URLConnection conn = url.openConnection();

                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                wr.write( data );
                wr.flush();

                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                StringBuilder sb = new StringBuilder();
                String line = null;

                // Read Server Response
                while((line = reader.readLine()) != null)
                {
                    sb.append(line);
                    break;
                }
                return sb.toString();
            }
            catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result){
        if(which==1) {
            switch (type) {
                case "question":

                    EPref.putString("question", result);
                    EPref.commit();
                    break;
                case "time":

                    EPref.putString("time", result);
                    EPref.commit();
                    break;
                case "answerUpdate":

                    if (result.equals("done")) {
                        EPref.putBoolean("status", true);

                    } else {
                        EPref.putBoolean("status", false);
                    }
                    EPref.commit();
                    break;

                case "enterTeam":
                    EPref.putString("enterTeam", result);
                    EPref.commit();
                    break;
                case "score":
                    EPref.putString("score", result);
                    EPref.commit();
                    break;
                case "scoreboard":
                    EPref.putString("scoreboard", result);
                    EPref.commit();
                    break;
                case "answers":
                    EPref.putString("answers", result);
                    EPref.commit();
                    break;

            }
        }else{
            t.setText(result);
        }

    }


}