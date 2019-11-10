package com.example.nawrustaskmng;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import data.Mytask;

public class AddTask extends AppCompatActivity {

    private EditText edtTitle;
    private EditText edtSubject;
    private TextView txtPriorty;
    private SeekBar skbpriorty;
    private Button savebt;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        edtTitle=(EditText)findViewById(R.id.edtTitle);
        edtSubject=(EditText)findViewById(R.id.edtSubject);
        txtPriorty=(TextView)findViewById(R.id.txtPriorty);
        skbpriorty=(SeekBar)findViewById(R.id.skbPriorty);
        savebt=(Button)findViewById(R.id.savebt);

        savebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });





    }
    private void dataHandler()
    {
        String title=edtTitle.getText().toString();
        String subject=edtSubject.getText().toString();
        int  seekbar=skbpriorty.getProgress();
        boolean isOk=true;
        if(title.length()<1)
        {
            edtTitle.setError("title length error");
            isOk=false;

        }
        if(subject.length()<1)
        {
            edtSubject.setError(" subject length error ");
            isOk=false;
        }
        if(isOk)
        {
            Mytask t=new Mytask();
            t.setTitle(title);
            createMyTask(t);

        }

    }

    private void createMyTask(Mytask t) {
        //.1
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        //.2
        DatabaseReference reference = database.getReference();
        FirebaseAuth auth=FirebaseAuth.getInstance();//to get the user uid(or other details like email)
        String uid= auth.getCurrentUser().getUid();
        String key = reference.child("task").push().getKey();
        reference.child("task").child(uid).child(key).setValue(t).addOnCompleteListener(AddTask.this, new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(AddTask.this,"add successful",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else {
                    Toast.makeText(AddTask.this,"add failed"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();

                }
            }
        });
    }
}
