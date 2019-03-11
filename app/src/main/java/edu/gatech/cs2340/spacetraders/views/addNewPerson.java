package edu.gatech.cs2340.spacetraders.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import edu.gatech.cs2340.spacetraders.R;
import edu.gatech.cs2340.spacetraders.model.DifficultyStanding;
import edu.gatech.cs2340.spacetraders.model.Game;
import edu.gatech.cs2340.spacetraders.model.Player;
import edu.gatech.cs2340.spacetraders.model.Universe;


public class addNewPerson extends AppCompatActivity {

    public Universe myUniverse;

    private final int ABILITY_POINTS = 16;
    private boolean isNameGiven;
    private int pilotPts = 0, engrPts = 0, tradePts = 0, fightPts = 0;
    private int pointsGiven = 0;
    private int totalPoints = 16;
    private TextView pilotText, fighterText, traderText, engineerText, totalPointsText;
    private Button okButton;
    private Spinner difficultySpinner;
    private EditText playerNameTextbox;
    private Player myPlayer;
    //private Game myGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_person);
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
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DifficultyStanding difficulty = (DifficultyStanding) difficultySpinner.getSelectedItem();
                String playerName = playerNameTextbox.getText().toString();
                myPlayer = new Player(playerName, difficulty, pilotPts, engrPts, tradePts, fightPts);
                myUniverse = new Universe();
                Game myGame = new Game(difficulty, myPlayer);
                startActivity(new Intent(addNewPerson.this, MainGame.class));
                Log.d("My Game's Information", myGame.toString());
                Log.d("My Universe Information", myUniverse.toString());
            }
        });
        for (int i = 0; i < 9; i++) {
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            Button btn = new Button(this);
        }
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

    public Universe getMyUniverse() {
        return myUniverse;
    }

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

}
