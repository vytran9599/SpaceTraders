package edu.gatech.cs2340.spacetraders.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import edu.gatech.cs2340.spacetraders.R;
import edu.gatech.cs2340.spacetraders.model.ModelFacade;
import edu.gatech.cs2340.spacetraders.model.Player;
import edu.gatech.cs2340.spacetraders.model.Ship;

public class ShipStatsActivity extends AppCompatActivity {

    private Player myPlayer;
    private Ship myShip;
    private int fuelCapacity, fuelCurrent, creditsCurrent;

    private TextView fuel, credits, fifFuelCost, maxFuelCost, maxFuel;
    private ProgressBar fuelBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ship_stats);

        myPlayer = ModelFacade.getInstance().getGame().getPlayer();
        myShip = myPlayer.getMyShip();
        fuelCapacity = myShip.getFuelCapacity();
        fuelCurrent = myShip.getFuel();
        creditsCurrent = myPlayer.getCredit();

        set();
        updateText();
        updateFuelBar();
    }

    private void set() {
        fuel = findViewById(R.id.fuel);
        maxFuel = findViewById(R.id.maxFuel);
        credits = findViewById(R.id.credits);
        fifFuelCost = findViewById(R.id.fifFuelCredits);
        maxFuelCost = findViewById(R.id.maxFuelCredits);

        fuelBar = findViewById(R.id.fuelBar);
        fuelBar.setScaleY(3);
        fuelBar.setMax(fuelCapacity);
    }

    private void updateText() {
        fuel.setText(Integer.toString(fuelCurrent));
        maxFuel.setText(Integer.toString(fuelCapacity));
        credits.setText(Integer.toString(creditsCurrent));
        fifFuelCost.setText(Integer.toString(50));
        int fuelPurchase = fuelCapacity - fuelCurrent;
        if (fuelPurchase > creditsCurrent) {
            maxFuelCost.setText(Integer.toString(creditsCurrent));
        } else {
            maxFuelCost.setText(Integer.toString(fuelCapacity - fuelCurrent));
        }
    }

    private void updatePlayerStats() {
        myShip.setFuel(fuelCurrent);
    }

    private void updateFuelBar() {
        fuelBar.setProgress(myPlayer.getMyShip().getFuel());
    }

    public void fiftyFuelOnClick(View v) {
        int fuelPurchase = fuelCapacity - fuelCurrent;
        if (fuelPurchase >= 50) {
            if (creditsCurrent >= 50) {
                creditsCurrent -= 50;
                fuelCurrent += 50;
            }
            updateText();
            updatePlayerStats();
            updateFuelBar();
        }
    }

    public void maxFuelOnClick(View v) {
        int fuelPurchase = fuelCapacity - fuelCurrent;
        if (fuelPurchase != 0) {
            if (creditsCurrent >= fuelPurchase) {
                fuelCurrent = fuelCapacity;
                creditsCurrent -= fuelPurchase;
            } else {
                fuelCurrent += creditsCurrent / 2;
                creditsCurrent = 0;
            }
            updateText();
            updatePlayerStats();
            updateFuelBar();
        }
    }
}
