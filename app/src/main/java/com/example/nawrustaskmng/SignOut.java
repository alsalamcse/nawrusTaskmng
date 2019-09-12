package com.example.nawrustaskmng;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SignOut extends AppCompatActivity {
    private EditText edtName;
    private EditText edtLastName;
    private EditText edtPhone;
    private EditText edtEmail;
    private EditText edtPassword;
    private EditText edtRewritePassword;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_out);
        edtName=(EditText)findViewById(R.id.edtLastName);
        edtLastName=(EditText)findViewById(R.id.edtLastName);
        edtPhone=(EditText)findViewById(R.id.edtPhone);
        edtEmail=(EditText)findViewById(R.id.edtEmail);
        edtPassword=(EditText)findViewById(R.id.edtPassword);
        edtRewritePassword=(EditText)findViewById(R.id.edtRewritePassword);
        btnSave=(Button)findViewById(R.id.btnSave);
    }
}
