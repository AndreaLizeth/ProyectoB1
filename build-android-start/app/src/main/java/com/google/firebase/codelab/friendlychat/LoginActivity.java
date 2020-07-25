package com.google.firebase.codelab.friendlychat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        Animation animacion1= AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo);
        Animation animacion2= AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba);

        TextView tvBienvenido= findViewById(R.id.tvBienvenido);
        TextView tvTopicos= findViewById(R.id.tvTopicos);
        ImageView imageView= findViewById(R.id.imageView);

        tvBienvenido.setAnimation(animacion1);
        tvTopicos.setAnimation(animacion1);
        imageView.setAnimation(animacion2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent= new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 4000);
    }
}