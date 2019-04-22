package edu.gatech.cs2340.spacetraders.views;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import edu.gatech.cs2340.spacetraders.R;

public class PoliceEncounterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_encounter);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(PoliceEncounterActivity.this, PoliceConfrontActivity.class));
                finish();
            }
        }, 1500);
    }
}
