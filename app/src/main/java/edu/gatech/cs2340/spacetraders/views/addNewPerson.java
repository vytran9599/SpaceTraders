package edu.gatech.cs2340.spacetraders.views;

//import android.arch.lifecycle.ViewModelProviders;
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
import android.widget.Spinner;
import android.widget.TextView;

import edu.gatech.cs2340.spacetraders.R;
import edu.gatech.cs2340.spacetraders.model.DifficultyStanding;
import edu.gatech.cs2340.spacetraders.model.Game;
import edu.gatech.cs2340.spacetraders.model.ModelFacade;
import edu.gatech.cs2340.spacetraders.model.Player;
import edu.gatech.cs2340.spacetraders.model.Universe;
import edu.gatech.cs2340.spacetraders.viewmodels.ConfigurationViewModel;

/**
 * Class that adds new person
 */
public class addNewPerson extends AppCompatActivity {


    private final int ABILITY_POINTS = 16;
    private boolean isNameGiven;
    private int pilotPts = 0, engrPts = 0, tradePts = 0, fightPts = 0;
    private int pointsGiven = 0;
    private int totalPoints = 16;
    private TextView pilotText, fighterText, traderText, engineerText, totalPointsText;
    private Button okButton;
    private Spinner difficultySpinner;
    private EditText playerNameTextbox;
    private Game myGame;

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

        ArrayAdapter<DifficultyStanding> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_item, DifficultyStanding.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpinner.setAdapter(adapter);
        //ConfigurationViewModel configVM;
        //configVM = ViewModelProviders.of(this).get(ConfigurationViewModel.class);

        playerNameTextbox.addTextChangedListener(nameFieldWatcher);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DifficultyStanding difficulty =
                        (DifficultyStanding) difficultySpinner.getSelectedItem();
                String playerName = playerNameTextbox.getText().toString();
                Player myPlayer =
                        new Player(playerName, difficulty, pilotPts, engrPts, tradePts, fightPts);
                Universe myUniverse = new Universe();
                //configVM.createGame(difficulty, myPlayer, myUniverse);
                myGame = new Game(difficulty, myPlayer, myUniverse);
                ModelFacade.getInstance().setGame(myGame);
                Log.d("My Game's Information", ModelFacade.getInstance().getGame().toString());
                Log.d("My Universe Information",
                        ModelFacade.getInstance().getGame().getMyUniverse().toString());
                startActivity(new Intent(addNewPerson.this, MainGame.class));

            }
        });
    }

    //added final
    private final TextWatcher nameFieldWatcher = new TextWatcher() {
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


    /**
     * Add value when clicked
     * @param v view
     */
    public void pilotPlusButtonOnClick(View v) {
        if (pilotPts < 10 && pointsGiven < ABILITY_POINTS) {
            pilotText.setText(Integer.toString(++pilotPts));
            pointsGiven++;
            plusAbilityPointsText(totalPointsText);
        }
    }

    /**
     * Delete value when clicked
     * @param v view
     */
    public void pilotMinusButtonOnClick(View v) {
        if (pilotPts > 0) {
            pilotText.setText(Integer.toString(--pilotPts));
            pointsGiven--;
            minusAbilityPointsText(totalPointsText);
        } else {
            pilotText.setText(Integer.toString(0));
        }
    }

    /**
     * Add value when clicked
     * @param v view
     */
    public void fighterPlusButtonOnClick(View v) {
        if (fightPts < 10 && pointsGiven < ABILITY_POINTS) {
            fighterText.setText(Integer.toString(++fightPts));
            pointsGiven++;
            plusAbilityPointsText(totalPointsText);
        }
    }

    /**
     * Delete value when clicked
     * @param v view
     */
    public void fighterMinusButtonOnClick(View v) {
        if (fightPts > 0) {
            fighterText.setText(Integer.toString(--fightPts));
            pointsGiven--;
            minusAbilityPointsText(totalPointsText);
        } else {
            fighterText.setText(Integer.toString(0));
        }
    }

    /**
     * Add value when clicked
     * @param v view
     */
    public void traderPlusButtonOnClick(View v) {
        if (tradePts < 10 && pointsGiven < ABILITY_POINTS) {
            traderText.setText(Integer.toString(++tradePts));
            pointsGiven++;
            plusAbilityPointsText(totalPointsText);
        }
    }

    /**
     * Delete value when clicked
     * @param v view
     */
    public void traderMinusButtonOnClick(View v) {
        if (tradePts > 0) {
            traderText.setText(Integer.toString(--tradePts));
            pointsGiven--;
            minusAbilityPointsText(totalPointsText);
        } else {
            traderText.setText(Integer.toString(0));
        }
    }

    /**
     * Add value when clicked
     * @param v view
     */
    public void engineerPlusButtonOnClick(View v) {
        if (engrPts < 10 && pointsGiven < ABILITY_POINTS) {
            engineerText.setText(Integer.toString(++engrPts));
            pointsGiven++;
            plusAbilityPointsText(totalPointsText);
        }
    }

    /**
     * Delete value when clicked
     * @param v view
     */
    public void engineerMinusButtonOnClick(View v) {
        if (engrPts > 0) {
            engineerText.setText(Integer.toString(--engrPts));
            pointsGiven--;
            minusAbilityPointsText(totalPointsText);
        } else {
            engineerText.setText(Integer.toString(0));
        }
    }

    //was public

    /**
     * Delete value when clicked
     * @param totalPointsText points
     */
    private void minusAbilityPointsText(TextView totalPointsText ) {
        totalPointsText.setText(Integer.toString(++totalPoints));
        okButton.setEnabled(false);
    }

    //was public

    /**
     * Total point
     * @param totalPointsText points
     */
    private void plusAbilityPointsText(TextView totalPointsText ) {
            totalPointsText.setText(Integer.toString(--totalPoints));
            okButton.setEnabled(totalPoints == 0 && isNameGiven);
        }

}
