import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashSet;

import edu.gatech.cs2340.spacetraders.model.Condition;
import edu.gatech.cs2340.spacetraders.model.Coordinate;
import edu.gatech.cs2340.spacetraders.model.DifficultyStanding;
import edu.gatech.cs2340.spacetraders.model.GovType;
import edu.gatech.cs2340.spacetraders.model.Market;
import edu.gatech.cs2340.spacetraders.model.PirateLevel;
import edu.gatech.cs2340.spacetraders.model.Planet;
import edu.gatech.cs2340.spacetraders.model.Player;
import edu.gatech.cs2340.spacetraders.model.PoliceLevel;
import edu.gatech.cs2340.spacetraders.model.Resources;
import edu.gatech.cs2340.spacetraders.model.SolarSystem;
import edu.gatech.cs2340.spacetraders.model.TechLevel;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

public class Jtests extends junit.framework.TestCase {





	static final int TIMEOUT = 10000000;
	private SolarSystem ss;
	private Coordinate coor;
	private String nam;
	private TechLevel tec;
	private Resources recourc;
	private GovType g;
	private PirateLevel pi;
	private PoliceLevel po;
	private Condition cond;
	private Planet planet;
	private Market market;
	private Player player;
	private DifficultyStanding ds;

	@Before
	public void setUp() {
		coor = new Coordinate(100, 200);
		nam = "Vy's World";
		tec = tec.INDUSTRIAL;
		recourc = recourc.MINERALRICH;
		g = g.SOCIALIST;
		pi = pi.FEW;
		po = po.FEW;
		cond = cond.NORMAL;
		market = new Market(cond, recourc, tec);
		planet = new Planet(nam, market);
		HashSet<Planet> planets = new HashSet<>();
		planets.add(planet);
		ss = new SolarSystem(coor, nam, tec, recourc, g, pi, po, cond, planets);
		ds = ds.EASY;
		player = new Player("Vy", ds, 4, 4, 4, 4);

	}

	@Test
	public void testNull() {
		try {
			market.buyInPlanet(player, null);
		} catch (IllegalArgumentException e) {

		}
	}

	@Test(timeout = TIMEOUT)
	public void testInvalid() {
		market.buyInPlanet(player, "hello");
		assertEquals("Player's credits should not changed", 1000, player.getCredit());
	}

	@Test(timeout = TIMEOUT)
	public void testNotEnoughMoney() {
		player.setCredit(0);
		market.buyInPlanet(player, "Water");
		assertEquals("Player's credits should not changed", 0, player.getCredit());
	}

	@Test(timeout = TIMEOUT)
	public void testSoldOut() {
		player.setCredit(1000000);
		while(market.getMarketGoodCounts()[8] != 0) {
			market.buyInPlanet(player, "Narcotics");
		}
		assertEquals("Item sold out", market.getMarketGoodCounts()[8], 0);
	}

	@Test(timeout = TIMEOUT)
	public void testBought() {
		market.buyInPlanet(player, "Food");
		int credits = player.getCredit();
		assertEquals("Player's credits changed", credits,  player.getCredit());
	}
}