package com.example.nawrustaskmng;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class Setting extends AppCompatActivity {
    private TextView txtSound;
    private Switch scIsSound;
    private TextView textSize;
    private SeekBar sbSize;
    private Button btnSave;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        txtSound=(TextView)findViewById(R.id.txtSound);
        scIsSound=(Switch)findViewById(R.id.scIsSound);
        textSize=(TextView)findViewById(R.id.textSize);
        sbSize=(SeekBar)findViewById(R.id.sbSize);
        btnSave=(Button)findViewById(R.id.btnSave);


    }
}
