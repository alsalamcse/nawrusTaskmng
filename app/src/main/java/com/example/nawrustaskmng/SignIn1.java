package com.example.nawrustaskmng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn1 extends AppCompatActivity {
    private ImageView imgFlower;
    private EditText edtEmail;
    private Button btnSignIn;
    private Button btnSignOut;
    private EditText edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in1);

        imgFlower=(ImageView) findViewById(R.id.imgFlower);
        edtEmail=(EditText)findViewById(R.id.edtEmail);
        btnSignIn=(Button)findViewById(R.id.btnSignIn);
        btnSignOut=(Button)findViewById(R.id.btnSave);
        edtPass=(EditText)findViewById(R.id.edtPass);


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });



    }

    private void dataHandler()
    {
        String email=edtEmail.getText().toString();
        String password=edtPass.getText().toString();
        boolean isok=true;
//        if(email.length()<4)
//        {
//            edtEmail.setError("Email length error");
//            isok=false;
//        }
//        if(email.indexOf("@")<0|| email.indexOf(".")<0)
//        {
//            edtEmail.setError("email wrong format");
//            isok=false;
//        }
        if(isValidEmailAddress(email)==false)
        {
            edtEmail.setError("Invalid Email");
            isok=false;
        }
        if(password.length()<8)
        {
            edtPass.setError("Password length error");
            isok=false;
        }
        if(isok){
            signIn(email,password);

        }
    }
    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
    private void signIn(String email, String password ){
        FirebaseAuth auth=FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //BF7S AZA TM TNFEZ AL3MLYA BNJA7
                if(task.isSuccessful()){

                    //todo go to main screen(all task activity)
                    Intent i=new Intent(getApplication(),TempAllTaskActivity.class);
                    startActivity(i);

                }
                else
                {
                    edtEmail.setError("email or password is wrong");
                }


            }
        });
    }

}
