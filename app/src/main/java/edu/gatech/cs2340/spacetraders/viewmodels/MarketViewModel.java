package edu.gatech.cs2340.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import edu.gatech.cs2340.spacetraders.model.Market;
import edu.gatech.cs2340.spacetraders.model.Planet;


public class MarketViewModel extends AndroidViewModel {
    private Market myMarket;

    public MarketViewModel(Application application) {
        super(application);
    }
    public void setMarket(Planet p) {
        myMarket = p.getMarket();
    }
    public Market getMyMarket() {
        return myMarket;
    }
}
