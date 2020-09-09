package com.example.prom_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrateActivity extends AppCompatActivity {

    ImageButton ibtnAddPhoto;
    EditText etUserName;
    TextView tvGen;
    RadioGroup radioGroup;
    RadioButton rbtnGen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrate);

        ibtnAddPhoto = findViewById(R.id.ibtnAddPhoto);
        etUserName=findViewById(R.id.etUserName);
        tvGen = findViewById(R.id.tvGen);
        radioGroup = findViewById(R.id.radioGroup);


    }

    public void checkButton(View v)
    {
        int rbtnID = radioGroup.getCheckedRadioButtonId();
        rbtnGen = findViewById(rbtnID);
        Toast.makeText(this,"Selected button : "+rbtnGen.getText(),Toast.LENGTH_SHORT).show();
    }
}
