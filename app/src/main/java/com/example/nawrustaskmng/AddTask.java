package com.example.nawrustaskmng;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class AddTask extends AppCompatActivity {

    private EditText edtTitle;
    private EditText edtSubject;
    private TextView txtPriorty;
    private SeekBar skbpriorty;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        edtTitle=(EditText)findViewById(R.id.edtTitle);
        edtSubject=(EditText)findViewById(R.id.edtSubject);
        txtPriorty=(TextView)findViewById(R.id.txtPriorty);
        skbpriorty=(SeekBar)findViewById(R.id.skbPriorty);



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
    }

}
