package com.example.chuan.closed;
/*
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private int mInterval = 60000; // 60 seconds by default, can be changed later
    private Handler mHandler;
    private TextView textView;
    private TextView textView2;
    private EditText editText;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView2 = (TextView) findViewById(R.id.textView2);
        try {
            new MyAsyncTask().execute(new URL("https://courses.illinois.edu/"));
        }catch (Exception e){
            //TODO
        }
        mHandler = new Handler();
        startRepeatingTask();

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        stopRepeatingTask();
    }

    Runnable mStatusChecker = new Runnable() {
        @Override
        public void run() {
            setInterval();
            textView = (TextView) findViewById(R.id.textView);
            textView.setText("Updated at : " + DateFormat.format("dd/MM/yy HH:mm:ss", new Date().getTime()));
            try {
                new MyAsyncTask().execute(new URL("https://courses.illinois.edu/"));
            }catch (Exception e){
                //TODO
            }
            mHandler.postDelayed(mStatusChecker, mInterval);
        }
    };

    void startRepeatingTask() {
        mStatusChecker.run();
    }

    void stopRepeatingTask() {
        mHandler.removeCallbacks(mStatusChecker);
    }

    public void setInterval(){
        editText = (EditText)findViewById(R.id.editText);
        try{
            int interval = Integer.parseInt(editText.getText().toString());
            if (interval < 10000){
                interval = 10000;
            }
            mInterval = interval;
        }
        catch (Exception e){
            mInterval = 60000;
        }
    }

    public class MyAsyncTask extends AsyncTask<URL, Void, String> {


        public MyAsyncTask(){}

        @Override
        protected String doInBackground(URL... params) {

            try {
                return Main.status();
            } catch (Exception e) {
                Log.d("MoviesAsyncTask", "failed to get data from network", e);
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            textView2.setText("Status : " + s);
        }
    }
}
*/

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private int interval = 60000; // 60 seconds by default, can be changed later
    private Handler handler;
    private TextView time;
    private FloatingActionButton add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

}
