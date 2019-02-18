package edu.gatech.cs2340.spacetraders.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import edu.gatech.cs2340.spacetraders.viewmodels.GameViewModel;

public class MainActivity extends AppCompatActivity {
    private GameViewModel gameViewModel;
    public static final int ADD_PERSON_REQUEST_ID = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Animation animation = new AlphaAnimation(1 , 0); // Change alpha from fully visible to invisible
        animation.setDuration(1500); // duration - half a second
        animation.setInterpolator(new LinearInterpolator()); // do not alter animation rate
        animation.setRepeatCount(Animation.INFINITE); // Repeat animation infinitely
        animation.setRepeatMode(Animation.REVERSE); // Reverse animation at the end so the button will fade back in
        Button newPlayer = findViewById(R.id.newPlayer);
        newPlayer.startAnimation(animation);
        newPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.clearAnimation();
                startActivity(new Intent(MainActivity.this, addNewPerson.class));
                startActivityForResult(new Intent(MainActivity.this, addNewPerson.class), ADD_PERSON_REQUEST_ID);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Log.d("APP", "resultCode = " + String.valueOf(resultCode) "  r");

        if (requestCode == ADD_PERSON_REQUEST_ID && resultCode == RESULT_OK) {
            String name = data.getStringExtra(addNewPerson.EXTRA_NAME);
            gameViewModel.addPlayer(name);
        } else {
            Toast.makeText(this, "player not added!", Toast.LENGTH_SHORT).show();
        }
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
