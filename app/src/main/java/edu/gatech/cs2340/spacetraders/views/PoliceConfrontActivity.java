package edu.gatech.cs2340.spacetraders.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import edu.gatech.cs2340.spacetraders.R;
import edu.gatech.cs2340.spacetraders.model.ModelFacade;
import edu.gatech.cs2340.spacetraders.model.Player;

public class PoliceConfrontActivity extends AppCompatActivity {

    private Player myPlayer;
    private TextView credits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_confront);

        myPlayer = ModelFacade.getInstance().getGame().getPlayer();
        set();
        update();
    }

    private void set() {
        credits = findViewById(R.id.credits);
    }

    private void update() {
        credits.setText(Integer.toString(myPlayer.getCredit()));
    }

    public void searchButtonOnClick(View v) {
        int[] goods = myPlayer.getPersonalGoodCounts();
        if (goods[5] > 0 || goods[8] > 0 || goods[9] > 0) {
            Toast.makeText(this,"YOU ARE UNDER ARREST", Toast.LENGTH_LONG).show();
            Toast.makeText(this,"GAME OVER", Toast.LENGTH_LONG).show();
            myPlayer.setCredit(0);
            myPlayer.getMyShip().setFuel(0);
        } else {
            Toast.makeText(this,"Nothing illegal here", Toast.LENGTH_LONG).show();
            onBackPressed();
        }
    }

    public void bribeButtonOnClick(View v) {
        if (myPlayer.getCredit() >= 150) {
            myPlayer.setCredit(myPlayer.getCredit() - 150);
            update();
            onBackPressed();
        }
    }

    public void runAwayButtonOnClick(View v) {
        Toast.makeText(this,"You got away", Toast.LENGTH_LONG).show();
        onBackPressed();
    }
}
