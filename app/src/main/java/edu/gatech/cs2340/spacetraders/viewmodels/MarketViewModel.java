package edu.gatech.cs2340.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import edu.gatech.cs2340.spacetraders.model.Market;
import edu.gatech.cs2340.spacetraders.model.Planet;

/**
 * Market view model class
 */
public class MarketViewModel extends AndroidViewModel {
    private Market myMarket;

    /**
     * Constructor
     * @param application application
     */
    public MarketViewModel(Application application) {
        super(application);
    }

    /**
     * settes method
     * @param p planet
     */
    public void setMarket(Planet p) {
        myMarket = p.getMarket();
    }

    /**
     * getters method
     * @return market
     */
    public Market getMyMarket() {
        return myMarket;
    }
}
