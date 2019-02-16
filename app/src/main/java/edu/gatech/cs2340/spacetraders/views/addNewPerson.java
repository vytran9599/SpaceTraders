package edu.gatech.cs2340.spacetraders.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import edu.gatech.cs2340.spacetraders.R;


public class addNewPerson extends AppCompatActivity {

    private final int ABILITY_POINTS = 16;
    private int pilotPts = 0;
    private int engrPts = 0;
    private int tradePts = 0;
    private int fightPts = 0;
    private int pointsGiven = 0;
    private int totalPoints = 16;
    private TextView pilotText;
    private TextView fighterText;
    private TextView traderText;
    private TextView engineerText;
    private TextView totalPointsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_person);
        pilotText = (TextView) findViewById(R.id.pilotPoints);
        fighterText = (TextView) findViewById(R.id.fighterPoints);
        traderText = (TextView) findViewById(R.id.traderPoints);
        engineerText = (TextView) findViewById(R.id.engineerPoints);
        totalPointsText = (TextView) findViewById(R.id.totalPoints);
    }

    public void pilotPlusButtonOnClick(View v) {
        if (pilotPts < 10 && pointsGiven < ABILITY_POINTS) {
            pilotText.setText(Integer.toString(++pilotPts));
            pointsGiven++;
            totalPointsText.setText(Integer.toString(--totalPoints));
        }
    }

    public void pilotMinusButtonOnClick(View v) {
        TextView fighterText = (TextView) findViewById(R.id.pilotPoints);
        if (pilotPts > 0) {
            pilotText.setText(Integer.toString(--pilotPts));
            pointsGiven--;
            totalPointsText.setText(Integer.toString(++totalPoints));
        } else {
            pilotText.setText(Integer.toString(0));
        }
    }

    public void fighterPlusButtonOnClick(View v) {
        TextView fighterText = (TextView) findViewById(R.id.fighterPoints);
        if (fightPts < 10 && pointsGiven < ABILITY_POINTS) {
            fighterText.setText(Integer.toString(++fightPts));
            pointsGiven++;
            totalPointsText.setText(Integer.toString(--totalPoints));
        }
    }

    public void fighterMinusButtonOnClick(View v) {
        TextView fighterText = (TextView) findViewById(R.id.fighterPoints);
        if (fightPts > 0) {
            fighterText.setText(Integer.toString(--fightPts));
            pointsGiven--;
            totalPointsText.setText(Integer.toString(++totalPoints));
        } else {
            fighterText.setText(Integer.toString(0));
        }
    }

    public void traderPlusButtonOnClick(View v) {
        TextView fighterText = (TextView) findViewById(R.id.traderPoints);
        if (tradePts < 10 && pointsGiven < ABILITY_POINTS) {
            traderText.setText(Integer.toString(++tradePts));
            pointsGiven++;
            totalPointsText.setText(Integer.toString(--totalPoints));
        }
    }

    public void traderMinusButtonOnClick(View v) {
        TextView fighterText = (TextView) findViewById(R.id.traderPoints);
        if (tradePts > 0) {
            traderText.setText(Integer.toString(--tradePts));
            pointsGiven--;
            totalPointsText.setText(Integer.toString(++totalPoints));
        } else {
            traderText.setText(Integer.toString(0));
        }
    }

    public void engineerPlusButtonOnClick(View v) {
        TextView fighterText = (TextView) findViewById(R.id.engineerPoints);
        if (engrPts < 10 && pointsGiven < ABILITY_POINTS) {
            engineerText.setText(Integer.toString(++engrPts));
            pointsGiven++;
            totalPointsText.setText(Integer.toString(--totalPoints));
        }
    }

    public void engineerMinusButtonOnClick(View v) {
        TextView fighterText = (TextView) findViewById(R.id.engineerPoints);
        if (engrPts > 0) {
            engineerText.setText(Integer.toString(--engrPts));
            pointsGiven--;
            totalPointsText.setText(Integer.toString(++totalPoints));
        } else {
            engineerText.setText(Integer.toString(0));
        }
    }
}
