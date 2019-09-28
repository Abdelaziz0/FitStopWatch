package com.example.fitstopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvSplash, tvSupSplash;
    Button btnget;
    Animation atg, btgone, btgtow;
    ImageView viSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSplash = (TextView) findViewById(R.id.tvSplash);
        tvSupSplash = (TextView) findViewById(R.id.tvSupSplash);
        btnget = (Button) findViewById(R.id.btnget);
        viSplash = (ImageView) findViewById(R.id.ivSplash);

        // load animation
        atg = AnimationUtils.loadAnimation(this, R.anim.atg);
        btgone = AnimationUtils.loadAnimation(this, R.anim.btgone);
        btgtow = AnimationUtils.loadAnimation(this, R.anim.btgtow);

        // passing animation
        viSplash.startAnimation(atg);
        tvSplash.startAnimation(btgone);
        tvSupSplash.startAnimation(btgone);
        btnget.startAnimation(btgtow);

        // passing event
        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StopWatchActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
            }
        });

        // import font
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf");

        // customize font
        tvSplash.setTypeface(MRegular);
        tvSupSplash.setTypeface(MLight);
        btnget.setTypeface(MMedium);


    }
}
