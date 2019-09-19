package com.example.nawrustaskmng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class welcome extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Thread th=new Thread()
        {
            public void run()
            {
                try {
                    sleep(3*1000);
                    Intent i=new Intent(getApplication(),SignIn1.class);
                    startActivity(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        th.start();

    }
}
