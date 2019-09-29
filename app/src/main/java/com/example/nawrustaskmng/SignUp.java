package com.example.nawrustaskmng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
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
        setContentView(R.layout.activity_sign_up);
        edtName=(EditText)findViewById(R.id.edtLastName);
        edtLastName=(EditText)findViewById(R.id.edtLastName);
        edtPhone=(EditText)findViewById(R.id.edtPhone);
        edtEmail=(EditText)findViewById(R.id.edtEmail);
        edtPassword=(EditText)findViewById(R.id.edtPassword);
        edtRewritePassword=(EditText)findViewById(R.id.edtRewritePassword);
        btnSave=(Button)findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });
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
        if((passw1.length()<8)||passw1.equals(passw2)==false)
        {
            edtRewritePassword.setError("Have to be at least 8 char and the same password");
            edtPassword.setError("Have to be at least 8 char and the same password");
            isOk=false;
        }
        if(fname.length()==0)
        {
            edtName.setError("enter name");
            isOk=false;
        }
        if(isOk)
        {
            createAcount(email,passw1,fname,lname,phone);//createAcount(email,passw1)
        }
    }

    private void createAcount(String email, String passw1, String fname, String lname, String phone) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email, passw1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    finish();

            }
                else
                {
                    edtEmail.setError("sign n up failed");
                }
        }

    });
    }

}
