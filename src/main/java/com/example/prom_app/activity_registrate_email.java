package com.example.prom_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class activity_registrate_email extends AppCompatActivity {

    EditText etEmail_r, etPsswd_r;
    ImageButton ibtnSendInfo;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrate_email);

        etEmail_r = findViewById(R.id.etEmail_r);
        etPsswd_r = findViewById(R.id.etPsswd_r);
        ibtnSendInfo = findViewById(R.id.ibtnSendInfo);

        Bundle bundle = new Bundle();
        bundle = getIntent().getExtras();
        user = (User) bundle.getSerializable(getResources().getString(R.string.usr_bundle));

        ibtnSendInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(val())
                {
                    try{
                        Log.d(getResources().getString(R.string.EMAILPSSWD),getResources().getString(R.string.empss_vlted));
                        Log.d(getResources().getString(R.string.EMAILPSSWD),getResources().getString(R.string.empss_email)+etEmail_r.getText().toString());
                        user.calcID();
                        Log.d(getResources().getString(R.string.EMAILPSSWD),getResources().getString(R.string.empss_id_gen)+user.getID());
                        Intent intent = new Intent(activity_registrate_email.this,MainActivity.class);
                        startActivity(intent);
                    }catch (Exception e)
                    {

                    }
                }
            }
        });
    }

    public boolean val(){
        return true;
    }
}