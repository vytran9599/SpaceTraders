package edu.gatech.cs2340.spacetraders.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;

import java.util.ArrayList;

import edu.gatech.cs2340.spacetraders.R;
import edu.gatech.cs2340.spacetraders.model.ModelFacade;
import edu.gatech.cs2340.spacetraders.model.Player;
import edu.gatech.cs2340.spacetraders.model.SolarSystem;
import edu.gatech.cs2340.spacetraders.model.Universe;

public class MainGame extends AppCompatActivity {

    private Universe myUniverse;
    private SolarSystem selectedSS, currentSS;
    private Player myPlayer;
    private ArrayList<SolarSystem> SSTravelList;

    private ProgressBar fuelBar;
    private GraphView map;
    private int indexSS;
    private Button travelButton;
    private TextView planetText, resText, techText, govText, polText, pirText, fuelText, costText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);

        myUniverse = ModelFacade.getInstance().getGame().getMyUniverse();
        currentSS = ModelFacade.getInstance().getGame().getMyUniverse().getCurrentSolarSystem();
        myPlayer = ModelFacade.getInstance().getGame().getPlayer();
        SSTravelList = myUniverse.getSolarSystemsToTravel(myPlayer.getMyShip().getFuel());

        map = findViewById(R.id.map);

        indexSS = 0;
        if (indexSS < SSTravelList.size()) {
            selectedSS = SSTravelList.get(indexSS);
        } else {
            Log.d("Error:", " not enough fuel to travel to any solar systems");
        }
        for (SolarSystem s:SSTravelList) {
            System.out.print(s.getName() + " ");
        }
        System.out.println("\nselected ss: " + selectedSS.getName() + " should be: " + SSTravelList.get(0).getName());
        set();
        updateText();
    }

    public void set() {
        planetText = findViewById(R.id.planetText);
        resText = findViewById(R.id.resText);
        techText = findViewById(R.id.techText);
        govText = findViewById(R.id.govText);
        polText = findViewById(R.id.polText);
        pirText = findViewById(R.id.pirText);
        fuelText = findViewById(R.id.fuelText);
        costText = findViewById(R.id.costText);

        fuelBar = findViewById(R.id.fuelBar);
        fuelBar.setScaleY(3);
        fuelBar.setMax(myPlayer.getMyShip().getFuel());

        travelButton = findViewById(R.id.travelButton);
    }

    public void updateText() {
        planetText.setText(selectedSS.getName());
        resText.setText(selectedSS.getResource().toString());
        techText.setText(selectedSS.getTechLevel().toString());
        govText.setText(selectedSS.getGovLevel().toString());
        polText.setText(selectedSS.getPoliceLevel().toString());
        pirText.setText(selectedSS.getPirateLevel().toString());
        fuelText.setText(Integer.toString(myPlayer.getMyShip().getFuel()));
        int a = selectedSS.getCoordinate().getX() + selectedSS.getCoordinate().getY();
        int b = currentSS.getCoordinate().getX() + currentSS.getCoordinate().getY();
        int distance = Math.abs(a - b);
        costText.setText(Integer.toString(distance));

        fuelBar.setProgress(myPlayer.getMyShip().getFuel());
    }

    public void updateStuck() {
        planetText.setText("none");
        resText.setText("none");
        techText.setText("none");
        govText.setText("none");
        polText.setText("none");
        pirText.setText("none");
        costText.setText(Integer.toString(0));

        travelButton.setEnabled(false);
    }

    public void marketplaceButtonOnClick(View v) {
        startActivity(new Intent(MainGame.this, marketplace.class));
    }

    public void currentSSInfoButtonOnClick(View v) {
        startActivity(new Intent(MainGame.this, CurrentSS.class));
    }


    public void SSLeftButtonOnClick(View v) {
        if (SSTravelList.size() == 0) {
            Log.d("Sad Life: ","Not enough fuel to travel to any other solar system, you're stuck on " + selectedSS.getName());
        } else {
            if (indexSS == 0) {
                indexSS = SSTravelList.size();
            }
            selectedSS = SSTravelList.get(--indexSS);
            updateText();
        }
    }

    public void SSRightButtonOnClick(View v) {
        if (SSTravelList.size() == 0) {
            Log.d("Sad Life: ","Not enough fuel to travel to any other solar system, you're stuck on " + selectedSS.getName());
        } else {
            selectedSS = SSTravelList.get(++indexSS % SSTravelList.size());
            if (indexSS == SSTravelList.size()) {
                indexSS = 0;
            }
            updateText();
        }
    }

    public void travelButtonOnClick(View v) {
        myUniverse.travel(selectedSS.getName(), myPlayer);
        SSTravelList = myUniverse.getSolarSystemsToTravel(myPlayer.getMyShip().getFuel());
        currentSS = ModelFacade.getInstance().getGame().getMyUniverse().getCurrentSolarSystem();
        pirateEncounter();
        updateText();
        if (SSTravelList.size() == 0) {
            Log.d("Error: ","You don't have enough fuel to travel to any other solar systems");
            updateStuck();
        } else {
            indexSS = 0;
            selectedSS = SSTravelList.get(indexSS);
            updateText();
        }
    }

    public void pirateEncounter() {
        int pirateLvl = currentSS.getPirateLevel().getValue();
        int chance = (int) (Math.random() * 10);
        if (pirateLvl >= chance) {
            startActivity(new Intent(MainGame.this, PirateEncounterActivity.class));
        }
    }
}
