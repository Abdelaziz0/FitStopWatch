package com.example.fitstopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

import static android.view.animation.Animation.INFINITE;

public class StopWatchActivity extends AppCompatActivity {

    Button btnstart, btnstop;
    ImageView icanchor;
    Animation roundingalone, roundingalonestop;
    Chronometer timerHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        btnstart = (Button) findViewById(R.id.btnstart);
        btnstop = (Button) findViewById(R.id.btnstop);
        icanchor = (ImageView) findViewById(R.id.icanchor);
        timerHere = (Chronometer) findViewById(R.id.timerHere);

        // create option animation
        btnstop.setAlpha(0);

        // load animation
        roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);
        roundingalonestop = AnimationUtils.loadAnimation(this, R.anim.roundingalonestop);

        // import font
        Typeface MLight = Typeface.createFromAsset(getAssets(), "fonts/MLight.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MMedium.ttf");
        Typeface MRegular = Typeface.createFromAsset(getAssets(), "fonts/MRegular.ttf");

        // customize font
        btnstart.setTypeface(MMedium);

        // passing event
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // passing animation
                icanchor.startAnimation(roundingalone);
                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstart.animate().alpha(0).setDuration(300).start();
                timerHere.setBase(SystemClock.elapsedRealtime());
                timerHere.start();
            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // passing animation
                icanchor.startAnimation(roundingalonestop);
                btnstart.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstop.animate().alpha(0).setDuration(300).start();
                timerHere.stop();
            }
        });
    }


}
