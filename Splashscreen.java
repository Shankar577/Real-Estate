package com.example.hp.realestateapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);


        Thread d=new Thread()
        {
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                }
                catch(Exception e)
                {

                }
                finally
                {
                    Intent in=new Intent(Splashscreen.this,MainActivity.class);
                    startActivity(in);
                }
            }
        };
        d.start();

    }
}
