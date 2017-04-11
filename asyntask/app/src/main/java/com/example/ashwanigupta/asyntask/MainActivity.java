package com.example.ashwanigupta.asyntask;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Button btnStart;
    TextView tvTime,tvStatus;
    public static final String TAG = "async";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button) findViewById(R.id.btnStart);
        tvTime = (TextView) findViewById(R.id.tvTime);
        tvStatus= (TextView) findViewById(R.id.tvStatus);


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvStatus.setText("Started...wait.");
                Mytask task = new Mytask();
              //  task.execute();
                //task.execute(0,1,2);   //parameters..integer param
                task.execute(10);
            }
        });
    }

    class Mytask extends AsyncTask<Integer, Float, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Float... values) {

            super.onProgressUpdate(values);

            tvTime.setText("Progress is "+ String.valueOf(values[0]));
        }

        //Integer params works like an array of parameters
        @Override
        protected String doInBackground(Integer... params) {

            for(int i=0;i<params[0];i++)
            {
                loopOneSecond();
                publishProgress((float)i/(float)params[0]);
            }
            return "completed";
        }

        @Override
        protected void onPostExecute(String s) {

            tvStatus.setText(s);

            super.onPostExecute(s);
        }

        //        @Override
//        protected Void doInBackground(Void... params) {
//
//            int i;
//            for(i=0;i<10;i++)
//            {
//                loopOneSecond();
//                Log.d(TAG, "doInBackground: "+i);
//                final int c=i ;
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        tvTime.setText(c+" seconds passed");
//                    }
//                });
//
//            }
//            return null;
//        }
    }


    static void loopOneSecond()
    {
        long startTime= System.currentTimeMillis();
        while(System.currentTimeMillis()-startTime <1000)
        {

        }
    }



}
