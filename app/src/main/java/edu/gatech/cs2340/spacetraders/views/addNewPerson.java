package edu.gatech.cs2340.spacetraders.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
=======
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;
>>>>>>> master

import edu.gatech.cs2340.spacetraders.R;
import edu.gatech.cs2340.spacetraders.model.DifficultyStanding;
import edu.gatech.cs2340.spacetraders.model.Player;


public class addNewPerson extends AppCompatActivity {
<<<<<<< HEAD

    private final int ABILITY_POINTS = 16;
    private boolean isNameGiven;
    private int pilotPts = 0, engrPts = 0, tradePts = 0, fightPts = 0;
    private int pointsGiven = 0;
    private int totalPoints = 16;
    private TextView pilotText, fighterText, traderText, engineerText, totalPointsText;
    private Button okButton;
    private Spinner difficultySpinner;
    private EditText playerNameTextbox;

=======
    public static final String EXTRA_NAME =
            "edu.gatech.cs2340.spacetraders.views.EXTRA_NAME";
    private EditText editPlayerName;
>>>>>>> master
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_person);
<<<<<<< HEAD
        pilotText = findViewById(R.id.pilotPoints);
        fighterText = findViewById(R.id.fighterPoints);
        traderText = findViewById(R.id.traderPoints);
        engineerText = findViewById(R.id.engineerPoints);
        totalPointsText = findViewById(R.id.totalPoints);
        playerNameTextbox = findViewById(R.id.playerName);
        okButton = findViewById(R.id.OkButton);
        difficultySpinner = findViewById(R.id.difficultyLevel);

        ArrayAdapter<DifficultyStanding> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, DifficultyStanding.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(adapter);

        playerNameTextbox.addTextChangedListener(nameFieldWatcher);
    }

    private TextWatcher nameFieldWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String playerName = playerNameTextbox.getText().toString();
            isNameGiven = !playerName.isEmpty();
            okButton.setEnabled(isNameGiven && totalPoints == 0);
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    public void pilotPlusButtonOnClick(View v) {
        if (pilotPts < 10 && pointsGiven < ABILITY_POINTS) {
            pilotText.setText(Integer.toString(++pilotPts));
            pointsGiven++;
            plusAbilityPointsText(totalPointsText);
        }
    }

    public void pilotMinusButtonOnClick(View v) {
        if (pilotPts > 0) {
            pilotText.setText(Integer.toString(--pilotPts));
            pointsGiven--;
            minusAbilityPointsText(totalPointsText);
        } else {
            pilotText.setText(Integer.toString(0));
        }
    }

    public void fighterPlusButtonOnClick(View v) {
        if (fightPts < 10 && pointsGiven < ABILITY_POINTS) {
            fighterText.setText(Integer.toString(++fightPts));
            pointsGiven++;
            plusAbilityPointsText(totalPointsText);
        }
    }

    public void fighterMinusButtonOnClick(View v) {
        if (fightPts > 0) {
            fighterText.setText(Integer.toString(--fightPts));
            pointsGiven--;
            minusAbilityPointsText(totalPointsText);
        } else {
            fighterText.setText(Integer.toString(0));
        }
    }

    public void traderPlusButtonOnClick(View v) {
        if (tradePts < 10 && pointsGiven < ABILITY_POINTS) {
            traderText.setText(Integer.toString(++tradePts));
            pointsGiven++;
            plusAbilityPointsText(totalPointsText);
        }
    }

    public void traderMinusButtonOnClick(View v) {
        if (tradePts > 0) {
            traderText.setText(Integer.toString(--tradePts));
            pointsGiven--;
            minusAbilityPointsText(totalPointsText);
        } else {
            traderText.setText(Integer.toString(0));
        }
    }

    public void engineerPlusButtonOnClick(View v) {
        if (engrPts < 10 && pointsGiven < ABILITY_POINTS) {
            engineerText.setText(Integer.toString(++engrPts));
            pointsGiven++;
            plusAbilityPointsText(totalPointsText);
        }
    }

    public void engineerMinusButtonOnClick(View v) {
        if (engrPts > 0) {
            engineerText.setText(Integer.toString(--engrPts));
            pointsGiven--;
            minusAbilityPointsText(totalPointsText);
        } else {
            engineerText.setText(Integer.toString(0));
        }
    }

    public void minusAbilityPointsText(TextView totalPointsText ) {
        totalPointsText.setText(Integer.toString(++totalPoints));
        okButton.setEnabled(false);
    }

    public void plusAbilityPointsText(TextView totalPointsText ) {
        totalPointsText.setText(Integer.toString(--totalPoints));
        okButton.setEnabled(totalPoints == 0 && isNameGiven);
    }

    public void onOkButtonPress(View v) {
        DifficultyStanding difficulty = (DifficultyStanding) difficultySpinner.getSelectedItem();
        String playerName = playerNameTextbox.getText().toString();
        new Player(playerName, difficulty, pilotPts, engrPts, tradePts, fightPts);
=======
        editPlayerName = findViewById(R.id.nameText);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add New Person");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.add_player_menu, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.save_person:
                savePerson();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }

    private void savePerson() {
        String name   = editPlayerName.getText().toString();

        Log.d("APP", "Making intent");
        Log.d("APP", "Data - " + name);
        Intent intent = new Intent();
        intent.putExtra(EXTRA_NAME, name);

        setResult(RESULT_OK, intent);

        finish();

>>>>>>> master
    }
}