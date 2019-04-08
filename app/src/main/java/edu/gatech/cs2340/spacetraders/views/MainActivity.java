package edu.gatech.cs2340.spacetraders.views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.Toast;

import edu.gatech.cs2340.spacetraders.R;
import edu.gatech.cs2340.spacetraders.model.ModelFacade;

/**
 * Main activity class
 */
public class MainActivity extends AppCompatActivity {
    public static final String SAVE = "MySavedGameFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Change alpha from fully visible to invisible
        final Animation animation = new AlphaAnimation(1 , 0);
        animation.setDuration(1500); // duration - half a second
        animation.setInterpolator(new LinearInterpolator()); // do not alter animation rate
        animation.setRepeatCount(Animation.INFINITE); // Repeat animation infinitely
        // Reverse animation at the end so the button will fade back in
        animation.setRepeatMode(Animation.REVERSE);
        Button newPlayer = findViewById(R.id.newPlayer);
        newPlayer.startAnimation(animation);
        newPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.clearAnimation();
                startActivity(new Intent(MainActivity.this, addNewPerson.class));
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loadGameButtonOnClick(View v) {
        SharedPreferences loadGame = getSharedPreferences(SAVE, 0);
        //playerOne = loadGame.getInt("Saved player name", 0);
        Toast.makeText(getApplicationContext(),
                "Game loaded successfully",
                Toast.LENGTH_SHORT).show();
    }
    public void saveGameButtonOnClick(View v) {
        if (ModelFacade.getInstance().getGame() != null) {
            SharedPreferences saveGame = getSharedPreferences(SAVE, MODE_PRIVATE);
            SharedPreferences.Editor editor = saveGame.edit();
            editor.putString("Saved player name", ModelFacade.getInstance().getGame().getPlayer().getName());
            editor.apply();
            Toast.makeText(getApplicationContext(),
                    "Game saved successfully",
                    Toast.LENGTH_SHORT).show();
        }

    }
}