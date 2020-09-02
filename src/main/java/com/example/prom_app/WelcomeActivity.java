package com.example.prom_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    TextView tvNameapp,tvWelcomeMessage;
    ImageView ivBrand,ivBackGround;
    ImageButton ibtnLogin;
    Animation fromloginbtn,fromappname;

    User user= new User("","","","","");;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);

        tvNameapp = findViewById(R.id.tvNameapp);
        tvWelcomeMessage = findViewById(R.id.tvWelcomeMessage);
        ivBackGround = findViewById(R.id.ivBackGround);
        ivBrand = findViewById(R.id.ivbrand);
        ibtnLogin = findViewById(R.id.ibtnLogin);

        tvNameapp.setText(getResources().getString(R.string.Prom_app));
        tvNameapp.setTextColor(getResources().getColor(R.color.White));
        tvWelcomeMessage.setText(getResources().getString(R.string.wel));

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
            Log.d("WELCOME","User ID is validated");
            //Entry to main activity
        }
        else
        {
            // Splash
            Log.d("WELCOME", "User is not validated");
            ivBackGround.animate().translationY(-900).setDuration(800).setStartDelay(1000);
            ivBrand.animate().translationY(-170).setDuration(800).setStartDelay(1100);
            fromloginbtn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fromloginbtn);
            //fromappname = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fromappname);
            ibtnLogin.setAnimation(fromloginbtn);
            ibtnLogin.startAnimation(fromloginbtn);
            //tvNameapp.setAnimation(fromappname);
            //tvNameapp.startAnimation(fromappname);
            tvNameapp.animate().translationY(-150).setDuration(800).setStartDelay(1100);
            tvNameapp.setTextColor(getResources().getColor(R.color.Black));
            tvWelcomeMessage.animate().alpha(0).setDuration(200).setStartDelay(1100);
            tvWelcomeMessage.setTextColor(getResources().getColor(R.color.Black));
        }
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
