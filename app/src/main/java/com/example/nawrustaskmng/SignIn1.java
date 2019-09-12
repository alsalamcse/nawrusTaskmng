package com.example.nawrustaskmng;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SignIn1 extends AppCompatActivity {
    private ImageView imgFlower;
    private EditText edtEmail;
    private Button btnSignIn;
    private Button btnSignOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in1);

        imgFlower=(ImageView) findViewById(R.id.imgFlower);
        edtEmail=(EditText)findViewById(R.id.edtEmail);
        btnSignIn=(Button)findViewById(R.id.btnSignIn);
        btnSignOut=(Button)findViewById(R.id.btnSave);



    }
}
