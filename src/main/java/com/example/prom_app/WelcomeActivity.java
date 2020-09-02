package com.example.prom_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    TextView tvNameapp,tvWelcomeMessage,tvRegistration;
    ImageView ivBrand,ivBackGround;
    ImageButton ibtnLogin,ibtnRegistration;
    Animation frominit;

    User user= new User("","","","","");;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);

        tvNameapp = findViewById(R.id.tvNameapp);
        tvWelcomeMessage = findViewById(R.id.tvWelcomeMessage);
        tvRegistration = findViewById(R.id.tvRegistration);
        ivBackGround = findViewById(R.id.ivBackGround);
        ivBrand = findViewById(R.id.ivbrand);
        ibtnLogin = findViewById(R.id.ibtnLogin);
        ibtnRegistration = findViewById(R.id.ibtnRegistration);

        tvNameapp.setText(getResources().getString(R.string.Prom_app));
        tvNameapp.setTextColor(getResources().getColor(R.color.White));
        tvWelcomeMessage.setText(getResources().getString(R.string.wel));
        tvRegistration.setText(getResources().getString(R.string.register));

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
            ivBackGround.animate().translationY(-900).setDuration(800).setStartDelay(1000);
            ivBrand.animate().translationY(-170).setDuration(800).setStartDelay(1100);
            frominit = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.init);
            ibtnLogin.setAnimation(frominit);
            ibtnLogin.startAnimation(frominit);
            tvNameapp.animate().alpha(0).translationY(-150).setDuration(800).setStartDelay(1100);
            tvNameapp.setTextColor(getResources().getColor(R.color.Black));
            tvWelcomeMessage.animate().alpha(0).setDuration(200).setStartDelay(1100);
            tvRegistration.setAnimation(frominit);
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
