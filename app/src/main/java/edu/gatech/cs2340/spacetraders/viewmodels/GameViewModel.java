package edu.gatech.cs2340.spacetraders.viewmodels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import edu.gatech.cs2340.spacetraders.model.Player;

public class GameViewModel extends AndroidViewModel {
    public GameViewModel(@NonNull Application application) {
        super(application);
    }
    public void addPlayer(String name) {
        Player myPlayer = new Player(name, 4, 4, 4, 4);
    }
}
