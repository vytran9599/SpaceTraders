package edu.gatech.cs2340.spacetraders.views;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import edu.gatech.cs2340.spacetraders.R;
import edu.gatech.cs2340.spacetraders.model.Market;
import edu.gatech.cs2340.spacetraders.model.ModelFacade;
import edu.gatech.cs2340.spacetraders.model.Player;
import edu.gatech.cs2340.spacetraders.model.TradeGood;
import edu.gatech.cs2340.spacetraders.model.Universe;
import edu.gatech.cs2340.spacetraders.viewmodels.ConfigurationViewModel;
import edu.gatech.cs2340.spacetraders.viewmodels.MarketViewModel;

public class marketplace extends AppCompatActivity {

    private int capacity, capacityLimit;
    private TextView capacityLimitText, capacityText;
    //private MarketViewModel marketVM;

    private int playerWater, playerFurs, playerFood, playerOre, playerGames,
            playerFirearms, playerMedicine, playerMachines, playerNarcotics,
            playerRobots;
    private int sellerWater, sellerFurs, sellerFood, sellerOre, sellerGames,
            sellerFirearms, sellerMedicine, sellerMachines, sellerNarcotics,
            sellerRobots;
    private int waterSellPrice, fursSellPrice, foodSellPrice, oreSellPrice, gamesSellPrice,
            firearmsSellPrice, medicineSellPrice, machinesSellPrice, narcoticsSellPrice, robotsSellPrice;
    private int waterBuyPrice, fursBuyPrice, foodBuyPrice, oreBuyPrice, gamesBuyPrice,
            firearmsBuyPrice, medicineBuyPrice, machinesBuyPrice, narcoticsBuyPrice, robotsBuyPrice;
    private TextView playerWaterText, playerFursText, playerFoodText, playerOreText, playerGamesText,
            playerFirearmsText, playerMedicineText, playerMachinesText, playerNarcoticsText,
            playerRobotsText;
    private TextView sellerWaterText, sellerFursText, sellerFoodText, sellerOreText, sellerGamesText,
            sellerFirearmsText, sellerMedicineText, sellerMachinesText, sellerNarcoticsText,
            sellerRobotsText;
    private TextView waterSellPriceText, fursSellPriceText, foodSellPriceText, oreSellPriceText, gamesSellPriceText,
            firearmsSellPriceText, medicineSellPriceText, machinesSellPriceText, narcoticsSellPriceText, robotsSellPriceText;
    private TextView waterBuyPriceText, fursBuyPriceText, foodBuyPriceText, oreBuyPriceText, gamesBuyPriceText,
            firearmsBuyPriceText, medicineBuyPriceText, machinesBuyPriceText, narcoticsBuyPriceText, robotsBuyPriceText;
    private TextView creditsText;
    private int creditsTotal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketplace);

        //market view model
        //marketVM = ViewModelProviders.of(this).get(MarketViewModel.class);
        //ConfigurationViewModel configVM = ViewModelProviders.of(this).get(ConfigurationViewModel.class);
        Player myPlayer = ModelFacade.getInstance().getGame().getPlayer();
        Market myMarket = ModelFacade.getInstance().getGame().getMyUniverse().getCurrentPlanet().getMarket();
        //Player myPlayer = configVM.getPlayer();
        //marketVM.setMarket(ModelFacade.getInstance().getGame().getMyUniverse().getCurrentPlanet());


        creditsText = findViewById(R.id.creditsText);
        creditsTotal = myPlayer.getCredit();
        creditsText.setText(Integer.toString(creditsTotal));

        playerWaterText = findViewById(R.id.playerWater);
        playerFursText = findViewById(R.id.playerFurs);
        playerFoodText = findViewById(R.id.playerFood);
        playerOreText = findViewById(R.id.playerOre);
        playerGamesText = findViewById(R.id.playerGames);
        playerFirearmsText = findViewById(R.id.playerFirearms);
        playerMedicineText = findViewById(R.id.playerMedicine);
        playerMachinesText = findViewById(R.id.playerMachines);
        playerNarcoticsText = findViewById(R.id.playerNarcotics);
        playerRobotsText = findViewById(R.id.playerRobots);
        sellerWaterText = findViewById(R.id.sellerWater);
        sellerFursText = findViewById(R.id.sellerFurs);
        sellerFoodText = findViewById(R.id.sellerFood);
        sellerOreText = findViewById(R.id.sellerOre);
        sellerGamesText = findViewById(R.id.sellerGames);
        sellerFirearmsText = findViewById(R.id.sellerFirearms);
        sellerMedicineText = findViewById(R.id.sellerMedicine);
        sellerMachinesText = findViewById(R.id.sellerMachines);
        sellerNarcoticsText = findViewById(R.id.sellerNarcotics);
        sellerRobotsText = findViewById(R.id.sellerRobots);

        waterBuyPriceText = findViewById(R.id.waterBuyPrice);
        fursBuyPriceText = findViewById(R.id.fursBuyPrice);
        foodBuyPriceText = findViewById(R.id.foodBuyPrice);
        oreBuyPriceText = findViewById(R.id.oreBuyPrice);
        gamesBuyPriceText = findViewById(R.id.gamesBuyPrice);
        firearmsBuyPriceText = findViewById(R.id.firearmsBuyPrice);
        medicineBuyPriceText = findViewById(R.id.medicineBuyPrice);
        machinesBuyPriceText = findViewById(R.id.machinesBuyPrice);
        narcoticsBuyPriceText = findViewById(R.id.narcoticsBuyPrice);
        robotsBuyPriceText = findViewById(R.id.robotsBuyPrice);

        waterSellPriceText = findViewById(R.id.waterSellPrice);
        fursSellPriceText = findViewById(R.id.fursSellPrice);
        foodSellPriceText = findViewById(R.id.foodSellPrice);
        oreSellPriceText = findViewById(R.id.oreSellPrice);
        gamesSellPriceText = findViewById(R.id.gamesSellPrice);
        firearmsSellPriceText = findViewById(R.id.firearmsSellPrice);
        medicineSellPriceText = findViewById(R.id.medicineSellPrice);
        machinesSellPriceText = findViewById(R.id.machinesSellPrice);
        narcoticsSellPriceText = findViewById(R.id.narcoticsSellPrice);
        robotsSellPriceText = findViewById(R.id.robotsSellPrice);

        //updatePlayerInfo
        int[] personalCounts = myPlayer.getPersonalGoodCounts();
        playerWater = personalCounts[0];
        playerFurs = personalCounts[1];
        playerFood = personalCounts[2];
        playerOre = personalCounts[3];
        playerGames = personalCounts[4];
        playerFirearms = personalCounts[5];
        playerMedicine = personalCounts[6];
        playerMachines = personalCounts[7];
        playerNarcotics = personalCounts[8];
        playerRobots = personalCounts[9];

        playerWaterText.setText(Integer.toString(playerWater));
        playerFursText.setText(Integer.toString(playerFurs));
        playerFoodText.setText(Integer.toString(playerFood));
        playerOreText.setText(Integer.toString(playerOre));
        playerGamesText.setText(Integer.toString(playerGames));
        playerFirearmsText.setText(Integer.toString(playerFirearms));
        playerMedicineText.setText(Integer.toString(playerMedicine));
        playerMachinesText.setText(Integer.toString(playerMachines));
        playerNarcoticsText.setText(Integer.toString(playerNarcotics));
        playerRobotsText.setText(Integer.toString(playerRobots));

        //updateSellerValues(marketVM.getMyMarket());

        int[] marketCounts = myMarket.getMarketGoodCounts();
        sellerWater = marketCounts[0];
        sellerFurs = marketCounts[1];
        sellerFood = marketCounts[2];
        sellerOre = marketCounts[3];
        sellerGames = marketCounts[4];
        sellerFirearms = marketCounts[5];
        sellerMedicine = marketCounts[6];
        sellerMachines = marketCounts[7];
        sellerNarcotics = marketCounts[8];
        sellerRobots = marketCounts[9];

        sellerWaterText.setText(Integer.toString(sellerWater));
        sellerFursText.setText(Integer.toString(sellerFurs));
        sellerFoodText.setText(Integer.toString(sellerFood));
        sellerOreText.setText(Integer.toString(sellerOre));
        sellerGamesText.setText(Integer.toString(sellerGames));
        sellerFirearmsText.setText(Integer.toString(sellerFirearms));
        sellerMedicineText.setText(Integer.toString(sellerMedicine));
        sellerMachinesText.setText(Integer.toString(sellerMachines));
        sellerNarcoticsText.setText(Integer.toString(sellerNarcotics));
        sellerRobotsText.setText(Integer.toString(sellerRobots));

        //updatePricesValue(marketVM.getMyMarket());

        TradeGood[] goods = myMarket.getGoods();
        int[] prices = new int[10];
        for (int i = 0; i < goods.length; i++) {
            prices[i] = goods[i].getFinalPrice();
        }

        waterBuyPrice = prices[0];
        fursBuyPrice = prices[1];
        foodBuyPrice = prices[2];
        oreBuyPrice = prices[3];
        gamesBuyPrice = prices[4];
        firearmsBuyPrice = prices[5];
        medicineBuyPrice = prices[6];
        machinesBuyPrice = prices[7];
        narcoticsBuyPrice = prices[8];
        robotsBuyPrice = prices[9];

        waterSellPrice = prices[0];
        fursSellPrice = prices[1];
        foodSellPrice = prices[2];
        oreSellPrice = prices[3];
        gamesSellPrice = prices[4];
        firearmsSellPrice = prices[5];
        medicineSellPrice = prices[6];
        machinesSellPrice = prices[7];
        narcoticsSellPrice = prices[8];
        robotsSellPrice = prices[9];

        waterBuyPriceText.setText(Integer.toString(waterBuyPrice));
        fursBuyPriceText.setText(Integer.toString(fursBuyPrice));
        foodBuyPriceText.setText(Integer.toString(foodBuyPrice));
        oreBuyPriceText.setText(Integer.toString(oreBuyPrice));
        gamesBuyPriceText.setText(Integer.toString(gamesBuyPrice));
        firearmsBuyPriceText.setText(Integer.toString(firearmsBuyPrice));
        medicineBuyPriceText.setText(Integer.toString(medicineBuyPrice));
        machinesBuyPriceText.setText(Integer.toString(machinesBuyPrice));
        narcoticsBuyPriceText.setText(Integer.toString(narcoticsBuyPrice));
        robotsBuyPriceText.setText(Integer.toString(robotsBuyPrice));

        waterSellPriceText.setText(Integer.toString(waterSellPrice));
        fursSellPriceText.setText(Integer.toString(fursSellPrice));
        foodSellPriceText.setText(Integer.toString(foodSellPrice));
        oreSellPriceText.setText(Integer.toString(oreSellPrice));
        gamesSellPriceText.setText(Integer.toString(gamesSellPrice));
        firearmsSellPriceText.setText(Integer.toString(firearmsSellPrice));
        medicineSellPriceText.setText(Integer.toString(medicineSellPrice));
        machinesSellPriceText.setText(Integer.toString(machinesSellPrice));
        narcoticsSellPriceText.setText(Integer.toString(narcoticsSellPrice));
        robotsSellPriceText.setText(Integer.toString(robotsSellPrice));





        capacity = playerWater +
                playerFurs +
                playerFood +
                playerOre +
                playerGames +
                playerFirearms +
                playerMedicine +
                playerNarcotics +
                playerMachines +
                playerRobots;

        capacityLimit = 20;

        capacityText = findViewById(R.id.capacityText);
        capacityText.setText(Integer.toString(capacity));
        capacityLimitText = findViewById(R.id.capacityLimitText);
        capacityLimitText.setText(Integer.toString(capacityLimit));

    }

    public void waterBuyOnClick(View v) {
        if (sellerWater > 0 && creditsTotal >= waterBuyPrice &&  capacity < capacityLimit) {
            playerWaterText.setText(Integer.toString(++playerWater));
            sellerWaterText.setText(Integer.toString(--sellerWater));
            creditsTotal -= waterBuyPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(++capacity));
        }
    }

    public void waterSellOnClick(View v) {
        if (playerWater > 0) {
            playerWaterText.setText(Integer.toString(--playerWater));
            sellerWaterText.setText(Integer.toString(++sellerWater));
            creditsTotal += waterSellPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(--capacity));
        }
    }

//    public void updatePlayerValues(Player p) {
//        int[] personalCounts = p.getPersonalGoodCounts();
//        playerWater = personalCounts[0];
//        playerFurs = personalCounts[1];
//        playerFood = personalCounts[2];
//        playerOre = personalCounts[3];
//        playerGames = personalCounts[4];
//        playerFirearms = personalCounts[5];
//        playerMedicine = personalCounts[6];
//        playerMachines = personalCounts[7];
//        playerNarcotics = personalCounts[8];
//        playerRobots = personalCounts[9];
//
//        playerWaterText.setText(Integer.toString(playerWater));
//        playerFursText.setText(Integer.toString(playerFurs));
//        playerFoodText.setText(Integer.toString(playerFood));
//        playerOreText.setText(Integer.toString(playerOre));
//        playerGamesText.setText(Integer.toString(playerGames));
//        playerFirearmsText.setText(Integer.toString(playerFirearms));
//        playerMedicineText.setText(Integer.toString(playerMedicine));
//        playerMachinesText.setText(Integer.toString(playerMachines));
//        playerNarcoticsText.setText(Integer.toString(playerNarcotics));
//        playerRobotsText.setText(Integer.toString(playerRobots));
//
//    }

//    public void updateSellerValues(Market m) {
//        int[] marketCounts = m.getMarketGoodCounts();
//        sellerWater = marketCounts[0];
//        sellerFurs = marketCounts[1];
//        sellerFood = marketCounts[2];
//        sellerOre = marketCounts[3];
//        sellerGames = marketCounts[4];
//        sellerFirearms = marketCounts[5];
//        sellerMedicine = marketCounts[6];
//        sellerMachines = marketCounts[7];
//        sellerNarcotics = marketCounts[8];
//        sellerRobots = marketCounts[9];
//
//        sellerWaterText.setText(Integer.toString(sellerWater));
//        sellerFursText.setText(Integer.toString(sellerFurs));
//        sellerFoodText.setText(Integer.toString(sellerFood));
//        sellerOreText.setText(Integer.toString(sellerOre));
//        sellerGamesText.setText(Integer.toString(sellerGames));
//        sellerFirearmsText.setText(Integer.toString(sellerFirearms));
//        sellerMedicineText.setText(Integer.toString(sellerMedicine));
//        sellerMachinesText.setText(Integer.toString(sellerMachines));
//        sellerNarcoticsText.setText(Integer.toString(sellerNarcotics));
//        sellerRobotsText.setText(Integer.toString(sellerRobots));
//    }

//    public void updatePricesValue(Market m) {
//        TradeGood[] goods = m.getGoods();
//        int[] prices = new int[10];
//        for (int i = 0; i < goods.length; i++) {
//            prices[i] = goods[i].getFinalPrice();
//        }
//
//        waterBuyPrice = prices[0];
//        fursBuyPrice = prices[1];
//        foodBuyPrice = prices[2];
//        oreBuyPrice = prices[3];
//        gamesBuyPrice = prices[4];
//        firearmsBuyPrice = prices[5];
//        medicineBuyPrice = prices[6];
//        machinesBuyPrice = prices[7];
//        narcoticsBuyPrice = prices[8];
//        robotsBuyPrice = prices[9];
//
//        waterSellPrice = prices[0];
//        fursSellPrice = prices[1];
//        foodSellPrice = prices[2];
//        oreSellPrice = prices[3];
//        gamesSellPrice = prices[4];
//        firearmsSellPrice = prices[5];
//        medicineSellPrice = prices[6];
//        machinesSellPrice = prices[7];
//        narcoticsSellPrice = prices[8];
//        robotsSellPrice = prices[9];
//
//        waterBuyPriceText.setText(Integer.toString(waterBuyPrice));
//        fursBuyPriceText.setText(Integer.toString(fursBuyPrice));
//        foodBuyPriceText.setText(Integer.toString(foodBuyPrice));
//        oreBuyPriceText.setText(Integer.toString(oreBuyPrice));
//        gamesBuyPriceText.setText(Integer.toString(gamesBuyPrice));
//        firearmsBuyPriceText.setText(Integer.toString(firearmsBuyPrice));
//        medicineBuyPriceText.setText(Integer.toString(medicineBuyPrice));
//        machinesBuyPriceText.setText(Integer.toString(machinesBuyPrice));
//        narcoticsBuyPriceText.setText(Integer.toString(narcoticsBuyPrice));
//        robotsBuyPriceText.setText(Integer.toString(robotsBuyPrice));
//
//        waterSellPriceText.setText(Integer.toString(waterSellPrice));
//        fursSellPriceText.setText(Integer.toString(fursSellPrice));
//        foodSellPriceText.setText(Integer.toString(foodSellPrice));
//        oreSellPriceText.setText(Integer.toString(oreSellPrice));
//        gamesSellPriceText.setText(Integer.toString(gamesSellPrice));
//        firearmsSellPriceText.setText(Integer.toString(firearmsSellPrice));
//        medicineSellPriceText.setText(Integer.toString(medicineSellPrice));
//        machinesSellPriceText.setText(Integer.toString(machinesSellPrice));
//        narcoticsSellPriceText.setText(Integer.toString(narcoticsSellPrice));
//        robotsSellPriceText.setText(Integer.toString(robotsSellPrice));
//    }


    public void fursBuyOnClick(View v) {
        if (sellerFurs > 0 && creditsTotal >= fursBuyPrice && capacity < capacityLimit) {
            playerFursText.setText(Integer.toString(++playerFurs));
            sellerFursText.setText(Integer.toString(--sellerFurs));
            creditsTotal -= fursBuyPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(++capacity));
        }
    }

    public void fursSellOnClick(View v) {
        if (playerFurs > 0) {
            playerFursText.setText(Integer.toString(--playerFurs));
            sellerFursText.setText(Integer.toString(++sellerFurs));
            creditsTotal += fursSellPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(--capacity));
        }
    }

    public void foodBuyOnClick(View v) {
        if (sellerFood > 0 && creditsTotal >= foodBuyPrice && capacity < capacityLimit) {
            playerFoodText.setText(Integer.toString(++playerFood));
            sellerFoodText.setText(Integer.toString(--sellerFood));
            creditsTotal -= foodBuyPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(++capacity));
        }
    }

    public void foodSellOnClick(View v) {
        if (playerFood > 0) {
            playerFoodText.setText(Integer.toString(--playerFood));
            sellerFoodText.setText(Integer.toString(++sellerFood));
            creditsTotal += foodSellPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(--capacity));
        }
    }

    public void oreBuyOnClick(View v) {
        if (sellerOre > 0 && creditsTotal >= oreBuyPrice && capacity < capacityLimit) {
            playerOreText.setText(Integer.toString(++playerOre));
            sellerOreText.setText(Integer.toString(--sellerOre));
            creditsTotal -= oreBuyPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(++capacity));
        }
    }

    public void oreSellOnClick(View v) {
        if (playerOre > 0) {
            playerOreText.setText(Integer.toString(--playerOre));
            sellerOreText.setText(Integer.toString(++sellerOre));
            creditsTotal += oreSellPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(--capacity));
        }
    }

    public void gamesBuyOnClick(View v) {
        if (sellerGames > 0 && creditsTotal >= gamesBuyPrice && capacity < capacityLimit) {
            playerGamesText.setText(Integer.toString(++playerGames));
            sellerGamesText.setText(Integer.toString(--sellerGames));
            creditsTotal -= firearmsBuyPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(++capacity));
        }
    }

    public void gamesSellOnClick(View v) {
        if (playerGames > 0) {
            playerGamesText.setText(Integer.toString(--playerGames));
            sellerGamesText.setText(Integer.toString(++sellerGames));
            creditsTotal += gamesSellPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(--capacity));
        }
    }

    public void firearmsBuyOnClick(View v) {
        if (sellerFirearms > 0 && creditsTotal >= firearmsBuyPrice && capacity < capacityLimit) {
            playerFirearmsText.setText(Integer.toString(++playerFirearms));
            sellerFirearmsText.setText(Integer.toString(--sellerFirearms));
            creditsTotal -= firearmsBuyPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(++capacity));
        }
    }

    public void firearmsSellOnClick(View v) {
        if (playerFirearms > 0) {
            playerFirearmsText.setText(Integer.toString(--playerFirearms));
            sellerFirearmsText.setText(Integer.toString(++sellerFirearms));
            creditsTotal += firearmsSellPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(--capacity));
        }
    }

    public void medicineBuyOnClick(View v) {
        if (sellerMedicine > 0 && creditsTotal >= medicineBuyPrice && capacity < capacityLimit) {
            playerMedicineText.setText(Integer.toString(++playerMedicine));
            sellerMedicineText.setText(Integer.toString(--sellerMedicine));
            creditsTotal -= medicineBuyPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(++capacity));
        }
    }

    public void medicineSellOnClick(View v) {
        if (playerMedicine > 0 ) {
            playerMedicineText.setText(Integer.toString(--playerMedicine));
            sellerMedicineText.setText(Integer.toString(++sellerMedicine));
            creditsTotal += medicineSellPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(--capacity));
        }
    }

    public void machinesBuyOnClick(View v) {
        if (sellerMachines > 0 && creditsTotal >= machinesBuyPrice && capacity < capacityLimit) {
            playerMachinesText.setText(Integer.toString(++playerMachines));
            sellerMachinesText.setText(Integer.toString(--sellerMachines));
            creditsTotal -= machinesBuyPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(++capacity));
        }
    }

    public void machinesSellOnClick(View v) {
        if (playerMachines > 0) {
            playerMachinesText.setText(Integer.toString(--playerMachines));
            sellerMachinesText.setText(Integer.toString(++sellerMachines));
            creditsTotal += machinesSellPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(--capacity));
        }
    }

    public void narcoticsBuyOnClick(View v) {
        if (sellerNarcotics > 0 && creditsTotal >= narcoticsBuyPrice && capacity < capacityLimit) {
            playerNarcoticsText.setText(Integer.toString(++playerNarcotics));
            sellerNarcoticsText.setText(Integer.toString(--sellerNarcotics));
            creditsTotal -= narcoticsBuyPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(++capacity));
        }
    }

    public void narcoticsSellOnClick(View v) {
        if (playerNarcotics > 0) {
            playerNarcoticsText.setText(Integer.toString(--playerNarcotics));
            sellerNarcoticsText.setText(Integer.toString(++sellerNarcotics));
            creditsTotal += narcoticsSellPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(--capacity));
        }
    }

    public void robotsBuyOnClick(View v) {
        if (sellerRobots > 0 && creditsTotal >= robotsBuyPrice && capacity < capacityLimit) {
            playerRobotsText.setText(Integer.toString(++playerRobots));
            sellerRobotsText.setText(Integer.toString(--sellerRobots));
            creditsTotal -= robotsBuyPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(++capacity));
        }
    }

    public void robotsSellOnClick(View v) {
        if (playerRobots > 0) {
            playerRobotsText.setText(Integer.toString(--playerRobots));
            sellerRobotsText.setText(Integer.toString(++sellerRobots));
            creditsTotal += robotsSellPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(--capacity));
        }
    }

    public void waterAllOnClick(View v) {
        if (playerWater > 0) {
            creditsTotal += playerWater * waterSellPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            sellerWater += playerWater;
            capacity -= playerWater;
            capacityText.setText(Integer.toString(capacity));
            sellerWaterText.setText(Integer.toString(sellerWater));
            playerWater = 0;
            playerWaterText.setText(Integer.toString(playerWater));
        }
    }

    public void fursAllOnClick(View v) {
        if (playerFurs > 0) {
            creditsTotal += playerFurs * fursSellPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            sellerFurs += playerFurs;
            capacity -= playerFurs;
            capacityText.setText(Integer.toString(capacity));
            sellerFursText.setText(Integer.toString(sellerFurs));
            playerFurs = 0;
            playerFursText.setText(Integer.toString(playerFurs));
        }
    }

    public void foodAllOnClick(View v) {
        if (playerFood > 0) {
            creditsTotal += playerFood * foodSellPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            sellerFood += playerFood;
            capacity -= playerFood;
            capacityText.setText(Integer.toString(capacity));
            sellerFoodText.setText(Integer.toString(sellerFood));
            playerFood = 0;
            playerFoodText.setText(Integer.toString(playerFood));
        }
    }

    public void oreAllOnClick(View v) {
        if (playerOre > 0) {
            creditsTotal += playerOre * oreSellPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            sellerOre += playerOre;
            capacity -= playerOre;
            capacityText.setText(Integer.toString(capacity));
            sellerOreText.setText(Integer.toString(sellerOre));
            playerOre = 0;
            playerOreText.setText(Integer.toString(playerOre));
        }
    }

    public void gamesAllOnClick(View v) {
        if (playerGames > 0) {
            creditsTotal += playerGames * gamesSellPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            sellerGames += playerGames;
            capacity -= playerGames;
            capacityText.setText(Integer.toString(capacity));
            sellerGamesText.setText(Integer.toString(sellerGames));
            playerGames = 0;
            playerGamesText.setText(Integer.toString(playerGames));
        }
    }

    public void firearmsAllOnClick(View v) {
        if (playerFirearms > 0) {
            creditsTotal += playerFirearms * firearmsSellPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            sellerFirearms += playerFirearms;
            capacity -= playerFirearms;
            capacityText.setText(Integer.toString(capacity));
            sellerFirearmsText.setText(Integer.toString(sellerFirearms));
            playerFirearms = 0;
            playerFirearmsText.setText(Integer.toString(playerFirearms));
        }
    }

    public void medicineAllOnClick(View v) {
        if (playerMedicine > 0) {
            creditsTotal += playerMedicine * medicineSellPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            sellerMedicine += playerMedicine;
            capacity -= playerMedicine;
            capacityText.setText(Integer.toString(capacity));
            sellerMedicineText.setText(Integer.toString(sellerMedicine));
            playerMedicine = 0;
            playerMedicineText.setText(Integer.toString(playerMedicine));
        }
    }

    public void machinesAllOnClick(View v) {
        if (playerMachines > 0) {
            creditsTotal += playerMachines * machinesSellPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            sellerMachines += playerMachines;
            capacity -= playerMachines;
            capacityText.setText(Integer.toString(capacity));
            sellerMachinesText.setText(Integer.toString(sellerMachines));
            playerMachines = 0;
            playerMachinesText.setText(Integer.toString(playerMachines));
        }
    }

    public void narcoticsAllOnClick(View v) {
        if (playerNarcotics > 0) {
            creditsTotal += playerNarcotics * narcoticsSellPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            sellerNarcotics += playerNarcotics;
            capacity -= playerNarcotics;
            capacityText.setText(Integer.toString(capacity));
            sellerNarcoticsText.setText(Integer.toString(sellerNarcotics));
            playerNarcotics = 0;
            playerNarcoticsText.setText(Integer.toString(playerNarcotics));
        }
    }

    public void robotsAllOnClick(View v) {
        if (playerRobots > 0) {
            creditsTotal += playerRobots * robotsSellPrice;
            creditsText.setText(Integer.toString(creditsTotal));
            sellerRobots += playerRobots;
            capacity -= playerRobots;
            capacityText.setText(Integer.toString(capacity));
            sellerRobotsText.setText(Integer.toString(sellerRobots));
            playerRobots = 0;
            playerRobotsText.setText(Integer.toString(playerRobots));
        }
    }

    public void waterMaxOnClick(View v) {
        if(sellerWater > 0) {
            while(creditsTotal >= waterBuyPrice && capacity < capacityLimit && sellerWater > 0) {
                sellerWater--;
                playerWater++;
                creditsTotal-= waterBuyPrice;
                capacity++;
            }
            playerWaterText.setText(Integer.toString(playerWater));
            sellerWaterText.setText(Integer.toString(sellerWater));
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(capacity));
        }
    }

    public void fursMaxOnClick(View v) {
        if(sellerFurs > 0) {
            while(creditsTotal >= waterBuyPrice && capacity < capacityLimit && sellerFurs > 0) {
                sellerFurs--;
                playerFurs++;
                creditsTotal-= fursBuyPrice;
                capacity++;
            }
            playerFursText.setText(Integer.toString(playerFurs));
            sellerFursText.setText(Integer.toString(sellerFurs));
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(capacity));
        }
    }

    public void foodMaxOnClick(View v) {
        if(sellerFood > 0) {
            while(creditsTotal >= waterBuyPrice && capacity < capacityLimit && sellerFood > 0) {
                sellerFood--;
                playerFood++;
                creditsTotal-= foodBuyPrice;
                capacity++;
            }
            playerFoodText.setText(Integer.toString(playerFood));
            sellerFoodText.setText(Integer.toString(sellerFood));
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(capacity));
        }
    }

    public void oreMaxOnClick(View v) {
        if(sellerOre > 0) {
            while(creditsTotal >= oreBuyPrice && capacity < capacityLimit && sellerOre > 0) {
                sellerOre--;
                playerOre++;
                creditsTotal-= oreBuyPrice;
                capacity++;
            }
            playerOreText.setText(Integer.toString(playerOre));
            sellerOreText.setText(Integer.toString(sellerOre));
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(capacity));
        }
    }

    public void gamesMaxOnClick(View v) {
        if(sellerGames > 0) {
            while(creditsTotal >= gamesBuyPrice && capacity < capacityLimit && sellerGames > 0) {
                sellerGames--;
                playerGames++;
                creditsTotal-= gamesBuyPrice;
                capacity++;
            }
            playerGamesText.setText(Integer.toString(playerGames));
            sellerGamesText.setText(Integer.toString(sellerGames));
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(capacity));
        }
    }

    public void firearmsMaxOnClick(View v) {
        if(sellerFirearms > 0) {
            while(creditsTotal >= firearmsBuyPrice && capacity < capacityLimit && sellerFirearms > 0) {
                sellerFirearms--;
                playerFirearms++;
                creditsTotal-= firearmsBuyPrice;
                capacity++;
            }
            playerFirearmsText.setText(Integer.toString(playerFirearms));
            sellerFirearmsText.setText(Integer.toString(sellerFirearms));
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(capacity));
        }
    }

    public void medicineMaxOnClick(View v) {
        if(sellerMedicine > 0) {
            while(creditsTotal >= medicineBuyPrice && capacity < capacityLimit && sellerMedicine > 0) {
                sellerMedicine--;
                playerMedicine++;
                creditsTotal-= medicineBuyPrice;
                capacity++;
            }
            playerMedicineText.setText(Integer.toString(playerMedicine));
            sellerMedicineText.setText(Integer.toString(sellerMedicine));
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(capacity));
        }
    }

    public void machinesMaxOnClick(View v) {
        if(sellerMachines > 0) {
            while(creditsTotal >= machinesBuyPrice && capacity < capacityLimit && sellerMachines > 0) {
                sellerMachines--;
                playerMachines++;
                creditsTotal-= machinesBuyPrice;
                capacity++;
            }
            playerMachinesText.setText(Integer.toString(playerMachines));
            sellerMachinesText.setText(Integer.toString(sellerMachines));
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(capacity));
        }
    }

    public void narcoticsMaxOnClick(View v) {
        if(sellerNarcotics > 0) {
            while(creditsTotal >= waterBuyPrice && capacity < capacityLimit && sellerNarcotics > 0) {
                sellerNarcotics--;
                playerNarcotics++;
                creditsTotal-= waterBuyPrice;
                capacity++;
            }
            playerNarcoticsText.setText(Integer.toString(playerNarcotics));
            sellerNarcoticsText.setText(Integer.toString(sellerNarcotics));
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(capacity));
        }
    }

    public void robotsMaxOnClick(View v) {
        if(sellerRobots > 0) {
            while(creditsTotal >= robotsBuyPrice && capacity < capacityLimit && sellerRobots > 0) {
                sellerRobots--;
                playerRobots++;
                creditsTotal-= waterBuyPrice;
                capacity++;
            }
            playerRobotsText.setText(Integer.toString(playerRobots));
            sellerRobotsText.setText(Integer.toString(sellerRobots));
            creditsText.setText(Integer.toString(creditsTotal));
            capacityText.setText(Integer.toString(capacity));
        }
    }
}
