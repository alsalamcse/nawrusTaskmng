package com.example.nawrustaskmng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    private EditText edtFirstName;
    private EditText etLastName;
    private EditText edtPhone;
    private EditText edtEmail;
    private EditText etPassword;
    private EditText edtRewritePassword;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edtFirstName=(EditText)findViewById(R.id.edtFirstName);
        etLastName=(EditText)findViewById(R.id.etLastName);
        edtPhone=(EditText)findViewById(R.id.edtPhone);
        edtEmail=(EditText)findViewById(R.id.edtEmail);
        etPassword=(EditText)findViewById(R.id.etPassword);
        edtRewritePassword=(EditText)findViewById(R.id.edtRewritePassword);
        btnSignUp=(Button)findViewById(R.id.btnSignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
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
        String passw1=etPassword.getText().toString();
        String fname=edtFirstName.getText().toString();
        String lname=etLastName.getText().toString();
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
            etPassword.setError("Have to be at least 8 char and the same password");
            isOk=false;
        }
        if(fname.length()==0)
        {
            edtFirstName.setError("enter name");
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
                    Toast.makeText(SignUp.this, "sign up succesful", Toast.LENGTH_SHORT).show();
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
