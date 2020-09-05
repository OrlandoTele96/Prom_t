package com.example.prom_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    TextView tvWelcomeMessage;
    ImageView ivBrand,ivBackGround;
    ImageButton ibtnLogin,ibtnRegistration;
    EditText etEmail,etPswd;

    Animation frombg,frombrand,fromwhiteletters,frominit,frombg_trans;

    User user= new User("","","","","");;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);

        //tvNameapp = findViewById(R.id.tvNameapp);
        tvWelcomeMessage = findViewById(R.id.tvWelcomeMessage);
        //tvRegistration = findViewById(R.id.tvRegistration);
        ivBackGround = findViewById(R.id.ivBackGround);
        ivBrand = findViewById(R.id.ivbrand);
        ibtnLogin = findViewById(R.id.ibtnLogin);
        ibtnRegistration = findViewById(R.id.ibtnRegistration);
        etEmail = findViewById(R.id.etEmail);
        etPswd = findViewById(R.id.etPswd);

        //tvNameapp.setText(getResources().getString(R.string.Prom_app));
        //tvNameapp.setTextColor(getResources().getColor(R.color.White));
        tvWelcomeMessage.setText(getResources().getString(R.string.wel));
        etEmail.setHint(getResources().getString(R.string.txtemail));
        etPswd.setHint(getResources().getString(R.string.txtpswd));
        //tvRegistration.setText(getResources().getString(R.string.register));

        // Wait for database response
        /*Thread timer = new Thread(){
            public void run()
            {
                try {
                    sleep(2000);
                    Log.d("WELCOME","Connecting with servers...");
                }catch(Exception e){

                }
            }
        };*/
        //timer.start();

        if (Validation(user))
        {
            Log.d(getResources().getString(R.string.welcome),getResources().getString(R.string.wel_validated));
            //Entry to main activity
        }
        else
        {
            // Splash
            Log.d(getResources().getString(R.string.welcome),getResources().getString(R.string.wel_nvalidated));
            frombg = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.frombg);
            ivBackGround.setAnimation(frombg);
            ivBackGround.startAnimation(frombg);
            frombrand = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.frombrand);
            ivBrand.setAnimation(frombrand);
            ivBrand.startAnimation(frombrand);
            fromwhiteletters=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fromwhiteletters);
            //tvNameapp.setAnimation(fromwhiteletters);
            //tvNameapp.startAnimation(fromwhiteletters);
            tvWelcomeMessage.setAnimation(fromwhiteletters);
            tvWelcomeMessage.startAnimation(fromwhiteletters);
            frominit = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.init);
            ibtnLogin.setAnimation(frominit);
            ibtnLogin.startAnimation(frominit);
            etEmail.setAnimation(frominit);
            etEmail.startAnimation(frominit);
            etPswd.setAnimation(frominit);
            etPswd.startAnimation(frominit);
            //tvRegistration.setAnimation(frominit);
            ibtnLogin.startAnimation(frominit);
            ibtnRegistration.setAnimation(frominit);
        }


        ibtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Fields for log in
            }
        });

        ibtnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Activity for registration
                Intent intent = new Intent(WelcomeActivity.this,RegistrateActivity.class);
                startActivity(intent);
            }
        });

    }

    boolean Validation(User u)
    {
        /*This code validate a user*/
        if (u.getID().length()>0)
        {
            return true;
        }
        return false;
    };
}
