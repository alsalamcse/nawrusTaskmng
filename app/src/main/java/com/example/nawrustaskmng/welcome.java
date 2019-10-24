package com.example.nawrustaskmng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class welcome extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        Thread th=new Thread()
        {
            public void run()
            {
                try {
                    sleep(3*1000);
                    FirebaseAuth auth=FirebaseAuth.getInstance();
                    if(auth.getCurrentUser()==null || auth.getCurrentUser().getEmail()==null){
                        Intent i=new Intent(getApplication(),SignIn1.class);
                        startActivity(i);
                        finish();
                    }
                    else{
                        Intent i=new Intent(getApplication(),MainTasksActivity.class);
                        startActivity(i);
                        finish();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        th.start(); 
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }
}
