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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        edtTitle=(EditText)findViewById(R.id.edtPassword);
        edtSubject=(EditText)findViewById(R.id.edtLastName);
        txtPriorty=(TextView)findViewById(R.id.txtPriorty);
        skbpriorty=(SeekBar)findViewById(R.id.skbPriorty);
    }
}
