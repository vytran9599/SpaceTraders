package edu.gatech.cs2340.spacetraders.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashSet;

import edu.gatech.cs2340.spacetraders.R;
import edu.gatech.cs2340.spacetraders.model.Market;
import edu.gatech.cs2340.spacetraders.model.Universe;
import edu.gatech.cs2340.spacetraders.views.addNewPerson;
import edu.gatech.cs2340.spacetraders.model.SolarSystem;

public class marketplace extends AppCompatActivity {

    addNewPerson newPerson = new addNewPerson();
    Universe myUniverse = newPerson.getMyUniverse();
    HashSet<SolarSystem> solarSystems = myUniverse.getSolarSystems();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketplace);
    }


}
