package edu.gatech.cs2340.spacetraders.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import edu.gatech.cs2340.spacetraders.R;

public class MainGame extends AppCompatActivity {

    private TextView planetText, resourcesText, techText, govText, policeText, pirateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);
    }

    public void marketplaceButtonOnClick(View v) {
        startActivity(new Intent(MainGame.this, marketplace.class));
    }
}
