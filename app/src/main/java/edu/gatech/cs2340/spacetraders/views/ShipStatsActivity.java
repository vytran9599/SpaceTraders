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

    private TextView fuel, credits, fifFuelCost, maxFuelCost;
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
    }

    private void set() {
        fuel = findViewById(R.id.fuel);
        credits = findViewById(R.id.credits);
        fifFuelCost = findViewById(R.id.fifFuelCredits);
        maxFuelCost = findViewById(R.id.maxFuelCredits);

        fuelBar = findViewById(R.id.fuelBar);
        fuelBar.setScaleY(3);
        fuelBar.setMax(fuelCapacity);
    }

    private void updateText() {
        fuel.setText(Integer.toString(fuelCurrent));
        credits.setText(Integer.toString(creditsCurrent));
        maxFuelCost.setText(Integer.toString((fuelCapacity - fuelCurrent) * 2));
        fifFuelCost.setText(Integer.toString(100));
    }

    public void fiftyFuelOnClick(View v) {
        int fuelPurchase = fuelCapacity - fuelCurrent;
        int cost = fuelPurchase * 2;
        if (fuelPurchase >= 50 && creditsCurrent >= cost) {
            creditsCurrent -= 100;
            fuelCurrent += 50;
        } else if (creditsCurrent >= cost) {
            creditsCurrent -= cost;
            fuelCurrent = fuelCapacity;
        }
        updateText();
    }

    private void updateMaxFuelCost() {
        int fuelPurchase = fuelCapacity - fuelCurrent;
        int cost = fuelPurchase * 2;

    }

    public void maxFuelOnClick(View v) {
        int fuelPurchase = fuelCapacity - fuelCurrent;
        int cost = fuelPurchase * 2;
        if (creditsCurrent >= fuelPurchase) {
            fuelCurrent = fuelCapacity;
            creditsCurrent -= cost;
        } else {
            if (creditsCurrent % 2 == 0) {
                fuelCurrent += creditsCurrent / 2;
                creditsCurrent = 0;
            } else {
                fuelCurrent += creditsCurrent / 2;
                creditsCurrent = 1;
            }
        }
        updateText();
    }
}
