package edu.gatech.cs2340.spacetraders.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import edu.gatech.cs2340.spacetraders.R;
import edu.gatech.cs2340.spacetraders.model.ModelFacade;
import edu.gatech.cs2340.spacetraders.model.Player;
import edu.gatech.cs2340.spacetraders.model.Ship;
import edu.gatech.cs2340.spacetraders.model.SolarSystem;
import edu.gatech.cs2340.spacetraders.model.Universe;

public class MainGame extends AppCompatActivity {

    private Universe myUniverse;
    private SolarSystem selectedSS;
    private Player myPlayer;
    private ArrayList<SolarSystem> SSTravelList;


    private int indexSS;
    private TextView planetText, resText, techText, govText, polText, pirText, fuelText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_info);
        myUniverse = ModelFacade.getInstance().getGame().getMyUniverse();
        myPlayer = ModelFacade.getInstance().getGame().getPlayer();
        SSTravelList = myUniverse.getSolarSystemsToTravel(myPlayer.getMyShip().getFuel());
        selectedSS = SSTravelList.get(indexSS);
        setText();
        updateText();
    }

    public void setText() {
        planetText = findViewById(R.id.planetText);
        resText = findViewById(R.id.resText);
        techText = findViewById(R.id.techText);
        govText = findViewById(R.id.govText);
        polText = findViewById(R.id.polText);
        pirText = findViewById(R.id.pirText);
        fuelText = findViewById(R.id.fuelText);
    }

    public void updateText() {
        planetText.setText(selectedSS.getName());
        resText.setText(selectedSS.getResource().toString());
        techText.setText(selectedSS.getTechLevel().toString());
        govText.setText(selectedSS.getGovLevel().toString());
        polText.setText(selectedSS.getPoliceLevel().toString());
        pirText.setText(selectedSS.getPirateLevel().toString());
        fuelText.setText(Integer.toString(myPlayer.getMyShip().getFuel()));
    }

    public void marketplaceButtonOnClick(View v) {
        startActivity(new Intent(MainGame.this, marketplace.class));
    }

    public void currentSSInfoButtonOnClick(View v) {
        startActivity(new Intent(MainGame.this, CurrentSS.class));
    }


    public void SSLeftButtonOnClick(View v) {
        if (indexSS == 0) {
            indexSS = SSTravelList.size();
        }
        selectedSS = SSTravelList.get(--indexSS);
        updateText();
    }

    public void SSRightButtonOnClick(View v) {
        selectedSS = SSTravelList.get(++indexSS % SSTravelList.size());
        if (indexSS == SSTravelList.size()) {
            indexSS = 0;
        }
        updateText();
    }

    public void travelButtonOnClick(View v) {
        myUniverse.travel(selectedSS.getName(), myPlayer);
        SSTravelList = myUniverse.getSolarSystemsToTravel(myPlayer.getMyShip().getFuel());
        indexSS = 0;
        selectedSS = SSTravelList.get(indexSS);
        updateText();
    }
}
