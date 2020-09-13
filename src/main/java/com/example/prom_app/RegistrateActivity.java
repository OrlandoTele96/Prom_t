package com.example.prom_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class RegistrateActivity extends AppCompatActivity {

    ImageButton ibtnAddPhoto;
    EditText etUserName;
    TextView tvGen,tvBD,tvYYMMDD;
    RadioGroup radioGroup;
    RadioButton rbtnGen;

    DatePickerDialog.OnDateSetListener mDateListener;

    User user=new User("","","","","","");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrate);

        ibtnAddPhoto = findViewById(R.id.ibtnAddPhoto);
        etUserName=findViewById(R.id.etUserName);
        tvGen = findViewById(R.id.tvGen);
        radioGroup = findViewById(R.id.radioGroup);
        tvBD =findViewById(R.id.tvBD);
        tvYYMMDD = findViewById(R.id.tvYYMMDD);

        tvYYMMDD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(RegistrateActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,mDateListener,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Log.d("REGISTRO","year : "+year+"month : "+month+"day : "+dayOfMonth);
            }
        };
    }

    public void checkButton(View v)
    {
        int rbtnID = radioGroup.getCheckedRadioButtonId();
        rbtnGen = findViewById(rbtnID);
        Toast.makeText(this,"Selected button : "+rbtnGen.getText(),Toast.LENGTH_SHORT).show();
    }
}
