package edu.gatech.cs2340.spacetraders.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.View;

import edu.gatech.cs2340.spacetraders.model.DifficultyStanding;
import edu.gatech.cs2340.spacetraders.model.Player;
import edu.gatech.cs2340.spacetraders.viewmodels.GameViewModel;
import edu.gatech.cs2340.spacetraders.R;

/*
* This class displays the opening dialog and gets the user inputs.
*
*
*
* */
public class ConfigurationActivity extends AppCompatActivity {
    private GameViewModel viewModel;
    private Spinner difficultySpinner;
    private Player player;
    private boolean editing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_person);

        difficultySpinner = findViewById(R.id.difficultyLevel);

        ArrayAdapter<DifficultyStanding> difficultyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, DifficultyStanding.values());
        difficultyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setSelection(player.getDS().ordinal());
        difficultySpinner.setAdapter(difficultyAdapter);
    }
    public void onAddPressed(View view) {
        player.setDS((DifficultyStanding) difficultySpinner.getSelectedItem());
        finish();
    }
}