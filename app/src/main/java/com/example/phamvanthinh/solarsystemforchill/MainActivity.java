package com.example.phamvanthinh.solarsystemforchill;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imgLogothis = (ImageView)this.findViewById(R.id.imgLogoMainActivity);
        // Hoat dong cua logo
        setAnimation(imgLogothis);

        // Di chuyen toi man hinh chinh
        GoToMain();
    }

    int GoToMain(){
        Handler ha = new Handler();
        ha.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(
                        MainActivity.this,
                        ManHinhChinh.class
                ));
                finish();
            }
        },4000);

        return 0;
    }

    void setAnimation(ImageView img){
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.animation_of_logo_main_activity);
        img.setAnimation(animation);
    }
}
