package edu.gatech.cs2340.spacetraders.views;

import android.arch.lifecycle.ViewModelProvider;
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
    private Player myPlayer;
    private Market myMarket;
    private TextView capacityLimitText, capacityText;

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
        myPlayer = ModelFacade.getInstance().getGame().getPlayer();
        myMarket = ModelFacade.getInstance().getGame().getMyUniverse().getCurrentPlanet().getMarket();

        setNames();
        updatePlayerValues();
        updateSellerValues();
        updatePricesValue();

    }
    public void setNames() {
        capacityText = findViewById(R.id.capacityText);
        capacityLimitText = findViewById(R.id.capacityLimitText);
        creditsText = findViewById(R.id.creditsText);
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
    }

    public void generalBuy(String goodName) {
        myMarket.buyInPlanet(myPlayer, goodName);
        updatePlayerValues();
        updateSellerValues();
    }
    public void generalSell(String goodName) {
        myMarket.sellInPlanet(myPlayer, goodName);
        updatePlayerValues();
        updateSellerValues();
    }

    public void waterBuyOnClick(View v) {
        generalBuy("Water");
    }

    public void waterSellOnClick(View v) {
        generalSell("Water");
    }

    public void updatePlayerValues() {

        creditsTotal = myPlayer.getCredit();
        creditsText.setText(Integer.toString(creditsTotal));
        capacity = myPlayer.getMyShip().getCapacity();
        capacityLimit = myPlayer.getMyShip().getMaxCapacity();
        capacityText.setText(Integer.toString(capacity));
        capacityLimitText.setText(Integer.toString(capacityLimit));
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

    }

    public void updateSellerValues() {
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
    }

    public void updatePricesValue() {
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
    }

    public void fursBuyOnClick(View v) {
        generalBuy("Furs");
    }

    public void fursSellOnClick(View v) {
        generalSell("Furs");
    }

    public void foodBuyOnClick(View v) {
        generalBuy("Food");
    }

    public void foodSellOnClick(View v) {
        generalSell("Food");
    }

    public void oreBuyOnClick(View v) {
        generalBuy("Ore");
    }

    public void oreSellOnClick(View v) {
        generalSell("Ore");
    }

    public void gamesBuyOnClick(View v) {
        generalBuy("Games");
    }

    public void gamesSellOnClick(View v) {
        generalSell("Games");
    }

    public void firearmsBuyOnClick(View v) {
        generalBuy("Firearms");
    }

    public void firearmsSellOnClick(View v) {
        generalSell("Firearms");
    }

    public void medicineBuyOnClick(View v) {
        generalBuy("Medicine");
    }

    public void medicineSellOnClick(View v) {
        generalSell("Medicine");
    }

    public void machinesBuyOnClick(View v) {
        generalBuy("Machines");
    }

    public void machinesSellOnClick(View v) {
        generalSell("Machines");
    }

    public void narcoticsBuyOnClick(View v) {
        generalBuy("Narcotics");
    }

    public void narcoticsSellOnClick(View v) {
        generalSell("Narcotics");
    }

    public void robotsBuyOnClick(View v) {
        generalBuy("Robots");
    }

    public void robotsSellOnClick(View v) {
        generalSell("Robots");
    }

    public void waterAllOnClick(View v) {
        while (playerWater > 0) {
            generalSell("Water");
        }
    }

    public void fursAllOnClick(View v) {
        while (playerFurs > 0) {
            generalSell("Furs");
        }
    }

    public void foodAllOnClick(View v) {
        while (playerFood > 0) {
            generalSell("Food");
        }
    }

    public void oreAllOnClick(View v) {
        while (playerOre > 0) {
            generalSell("Ore");
        }
    }

    public void gamesAllOnClick(View v) {
        while (playerGames > 0) {
            generalSell("Games");
        }
    }

    public void firearmsAllOnClick(View v) {
        while (playerFirearms > 0) {
            generalSell("Firearms");
        }
    }

    public void medicineAllOnClick(View v) {
        while (playerMedicine > 0) {
            generalSell("Medicine");
        }
    }

    public void machinesAllOnClick(View v) {
        while (playerMachines > 0) {
            generalSell("Machines");
        }
    }

    public void narcoticsAllOnClick(View v) {
        while (playerNarcotics > 0) {
            generalSell("Narcotics");
        }
    }

    public void robotsAllOnClick(View v) {
        while (playerRobots > 0) {
            generalSell("Robots");
        }
    }

    public void waterMaxOnClick(View v) {
        while (sellerWater > 0 && myPlayer.getCredit() >= myMarket.getPriceOf("Water") && myPlayer.haveSpace()) {
            generalBuy("Water");
        }
    }

    public void fursMaxOnClick(View v) {
        while (sellerFurs > 0 && myPlayer.getCredit() >= myMarket.getPriceOf("Furs") && myPlayer.haveSpace()) {
            generalBuy("Furs");
        }
    }

    public void foodMaxOnClick(View v) {
        while (sellerFood > 0 && myPlayer.getCredit() >= myMarket.getPriceOf("Food") && myPlayer.haveSpace()) {
            generalBuy("Food");
        }
    }

    public void oreMaxOnClick(View v) {
        while (sellerOre > 0 && myPlayer.getCredit() >= myMarket.getPriceOf("Ore") && myPlayer.haveSpace()) {
            generalBuy("Ore");
        }
    }

    public void gamesMaxOnClick(View v) {
        while (sellerGames > 0 && myPlayer.getCredit() >= myMarket.getPriceOf("Games") && myPlayer.haveSpace()) {
            generalBuy("Games");
        }
    }

    public void firearmsMaxOnClick(View v) {
        while (sellerFirearms > 0 && myPlayer.getCredit() >= myMarket.getPriceOf("Firearms") && myPlayer.haveSpace()) {
            generalBuy("Firearms");
        }
    }

    public void medicineMaxOnClick(View v) {
        while (sellerMedicine > 0 && myPlayer.getCredit() >= myMarket.getPriceOf("Medicine") && myPlayer.haveSpace()) {
            generalBuy("Medicine");
        }
    }

    public void machinesMaxOnClick(View v) {
        while (sellerMachines > 0 && myPlayer.getCredit() >= myMarket.getPriceOf("Machines") && myPlayer.haveSpace()) {
            generalBuy("Machines");
        }
    }

    public void narcoticsMaxOnClick(View v) {
        while (sellerNarcotics > 0 && myPlayer.getCredit() >= myMarket.getPriceOf("Narcotics") && myPlayer.haveSpace()) {
            generalBuy("Narcotics");
        }
    }

    public void robotsMaxOnClick(View v) {
        while (sellerRobots > 0 && myPlayer.getCredit() >= myMarket.getPriceOf("Robots") && myPlayer.haveSpace()) {
            generalBuy("Robots");
        }
    }
}
