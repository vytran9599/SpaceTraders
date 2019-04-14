package edu.gatech.cs2340.spacetraders.views;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;


import edu.gatech.cs2340.spacetraders.R;
import edu.gatech.cs2340.spacetraders.model.Game;
import edu.gatech.cs2340.spacetraders.model.ModelFacade;

/**
 * Main activity class
 */
public class MainActivity extends AppCompatActivity {
    private static final String SAVE = "MySavedGameFile";
    private static final String SAVE_GAME = "SavedGame";
    private Gson myGson;
    //private Game saveGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Change alpha from fully visible to invisible
        final Animation animation = new AlphaAnimation(1, 0);
        animation.setDuration(1500); // duration - half a second
        animation.setInterpolator(new LinearInterpolator()); // do not alter animation rate
        animation.setRepeatCount(Animation.INFINITE); // Repeat animation infinitely
        // Reverse animation at the end so the button will fade back in
        animation.setRepeatMode(Animation.REVERSE);
        Button newPlayer = findViewById(R.id.newPlayer);
        newPlayer.startAnimation(animation);
        newPlayer.setOnClickListener(v -> {
            v.clearAnimation();
            startActivity(new Intent(MainActivity.this, addNewPerson.class));
        });
    }

    /**
     * Load game button on click
     * @param v view
     */
    public void loadGameButtonOnClick(View v) {
        if (myGson != null) {
            //System.out.println("myGson isn't null yay");
            SharedPreferences loadGame = getSharedPreferences(SAVE, 0);
            String myJson = loadGame.getString(SAVE_GAME, null);
            Game myGame = myGson.fromJson(myJson, Game.class);
            ModelFacade.getInstance().setGame(myGame);
            //System.out.println("name of player: " +
            // ModelFacade.getInstance().getGame().getPlayer().getName());
            startActivity(new Intent(MainActivity.this, MainGame.class));
//        try
//        {
//            // Reading the object from a file
//            FileInputStream file = new FileInputStream(filename);
//            ObjectInputStream in = new ObjectInputStream(file);
//
//            // Method for deserialization of object
//            object1 = (Game)in.readObject();
//
//            in.close();
//            file.close();
//
//            System.out.println("Object has been deserialized ");
//            System.out.println("a = " + object1.a);
//            System.out.println("b = " + object1.b);
//        }
//        }
                    Toast.makeText(getApplicationContext(),
                            "Game loaded successfully",
                            Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * save game button on click
     * @param v view
     */
    public void saveGameButtonOnClick(View v) {
        if (ModelFacade.getInstance().getGame() != null) {
            myGson = new Gson();
            Game myGame = ModelFacade.getInstance().getGame();
            String json = myGson.toJson(myGame);
//            Game myGame = ModelFacade.getInstance().getGame();
//            String filename = "file.ser";
//            try {
//                //Saving of object in a file
//                FileOutputStream file = new FileOutputStream(filename);
//                ObjectOutputStream out = new ObjectOutputStream(file);
//
//                // Method for serialization of object
//                out.writeObject(myGame);
//
//                out.close();
//                file.close();
//
//                System.out.println("Object has been serialized");
//            }
//            catch (IOException ex) {
//                System.out.println("IO Exception caught");
//            }
            SharedPreferences saveGame = getSharedPreferences(SAVE, MODE_PRIVATE);
            SharedPreferences.Editor editor = saveGame.edit();
            editor.putString(SAVE_GAME, json);
            editor.apply();
            Toast.makeText(getApplicationContext(),
                    "Game saved successfully",
                    Toast.LENGTH_SHORT).show();
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

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}