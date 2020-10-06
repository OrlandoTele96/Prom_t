package com.example.prom_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
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
    EditText etUserName,etAddress;
    TextView tvGen,tvBD,tvYYMMDD;
    RadioGroup radioGroup;
    RadioButton rbtnGen;
    ImageButton ibtnnxt;

    DatePickerDialog.OnDateSetListener mDateListener;

    //User user=new User("","","","","","");

    String Gen;
    int y,m,d;


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
        ibtnnxt = findViewById(R.id.ibtnnxt);
        etAddress = findViewById(R.id.etAddress);


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
                //Log.d("REGISTRO","year : "+year+"month : "+month+"day : "+dayOfMonth);
                Log.d(getResources().getString(R.string.registrate),getResources().getString(R.string.reg_year)+year+getResources().getString(R.string.reg_month)+month+getResources().getString(R.string.reg_day)+dayOfMonth);
                y = year;
                m =month+1;
                d=dayOfMonth;
                tvYYMMDD.setHint(y+getResources().getString(R.string.guion)+m+getResources().getString(R.string.guion)+d);
            }
        };

        ibtnnxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    try{
                        Log.d(getResources().getString(R.string.registrate),getResources().getString(R.string.reg_uservalidated));
                        Log.d(getResources().getString(R.string.registrate),getResources().getString(R.string.reg_usrvl_name)+etUserName.getText().toString());
                        Log.d(getResources().getString(R.string.registrate),getResources().getString(R.string.reg_usrvl_gen)+Gen);
                        Log.d(getResources().getString(R.string.registrate),getResources().getString(R.string.reg_usrvl_bd)+y+getResources().getString(R.string.guion)+m+getResources().getString(R.string.guion)+d);
                        Log.d(getResources().getString(R.string.registrate),getResources().getString(R.string.reg_usrvl_add)+etAddress.getText().toString());
                        User user = new User(etUserName.getText().toString(),etAddress.getText().toString(),Gen,y,m,d);

                        Intent intent = new Intent(RegistrateActivity.this,activity_registrate_email.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable(getResources().getString(R.string.usr_bundle),user);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }catch (Exception e){

                    }
                }
            }
        });
    }

    public void checkButton(View v)
    {
        int rbtnID = radioGroup.getCheckedRadioButtonId();
        rbtnGen = findViewById(rbtnID);
        Log.d(getResources().getString(R.string.registrate),getResources().getString(R.string.reg_gen)+rbtnGen.getText());
        Gen=rbtnGen.getText().toString();
        //If otro appears other edit text
    }

    public boolean checkGen(){
        if (Gen != null){
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean checkDate(){

        String date = tvYYMMDD.getHint().toString();
        String y = date.substring(0,4);

        if(y!=getResources().getString(R.string.Y))
        {
            return true;
        }
        return false;
    }

    public boolean checkName(){
        if (etUserName.getText().length()!=0)
        {
            return true;
        }
        return false;
    }
    public boolean checkAddress(){
        if (etAddress.getText().length()!=0)
        {
            return true;
        }
        return false;
    }

    public boolean validate(){
        if(checkName()&checkGen()&checkDate()&checkAddress()){
            // Validate date
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            if(y>=year){
                Toast.makeText(RegistrateActivity.this,getResources().getString(R.string.Reg_datewrong),Toast.LENGTH_SHORT).show();
                return false;
            }
            return true;
        }
        else {
            return false;
        }
    }
}
