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
    private void dataHandler()
    {
        boolean isOk=true;//if all fields filled well
        String email=edtEmail.getText().toString();
        String passw1=edtPassword.getText().toString();
        String fname=edtName.getText().toString();
        String lname=edtLastName.getText().toString();
        String phone=edtPhone.getText().toString();
        String passw2=edtRewritePassword.getText().toString();
        if(email.length()<4 || email.indexOf('@')<0 || email.indexOf('.')<0)
        {
            edtEmail.setError("wrong Email");
            isOk=false;

        }
        if(passw1.length()<8)||passw1.equals(passw2)==false)
        {
            edtRewritePassword.setError("Have to be at least 8 char and the same password");
            edtPassword.setError("Have to be at least 8 char and the same password");
            isOk=fslse;
        }

    }
}
