package ui;

import static org.junit.Assert.assertEquals;
import item.Armor;
import item.FactoryArmor;
import item.FactoryWeapon;
import item.Item;
import item.KeyFactory;
import item.PotionFactory;
import item.Weapon;

import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import lifeform.Goblin;
import lifeform.LifeForm;
import lifeform.Mummy;
import lifeform.Player;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dungeon.Dungeon;
import dungeon.cell.state.StateFactory;

/**
 * Tests GameDisplay method.
 * 
 * @author Jixiang Lu
 *
 */
public class TestGameDisplay
{

	/**
	 * Reset the global variable before or after the test.
	 */
	@Before
	public void resetBefore()
	{
		Dungeon.resetInstance();
		Player.resetInstance();
	}
	@After 
	public void resetAfter()
	{
		Dungeon.resetInstance();
		Player.resetInstance();
	}
	/**
	 * Test Map parts of the interface.
	 */
	@Test
	public void testMap()
	{
		//Create display
		Dungeon dun = Dungeon.getDungeonInstance();
		Player player = (Player) Player.getPlayerInstance();
		StateFactory factory = new StateFactory();
		dun.setState(0, 0, factory.getState(StateFactory.WALL));
		dun.setState(0, 1, factory.getState(StateFactory.WALL));
		dun.setState(0, 2, factory.getState(StateFactory.WALL));
		dun.setState(0, 3, factory.getState(StateFactory.WALL));
		dun.setState(0, 4, factory.getState(StateFactory.WALL));
		dun.setState(0, 5, factory.getState(StateFactory.WALL));
		dun.setState(0, 6, factory.getState(StateFactory.WALL));
		dun.setState(0, 7, factory.getState(StateFactory.WALL));
		dun.setState(1, 7, factory.getState(StateFactory.WALL));
		dun.setState(2, 7, factory.getState(StateFactory.WALL));
		dun.setState(3, 7, factory.getState(StateFactory.WALL));
		dun.setState(4, 7, factory.getState(StateFactory.WALL));
		dun.setState(5, 7, factory.getState(StateFactory.WALL));
		dun.setState(6, 7, factory.getState(StateFactory.WALL));
		dun.setState(1, 0, factory.getState(StateFactory.WALL));
		dun.setState(2, 0, factory.getState(StateFactory.WALL));
		dun.setState(3, 0, factory.getState(StateFactory.WALL));
		dun.setState(4, 0, factory.getState(StateFactory.WALL));
		dun.setState(5, 0, factory.getState(StateFactory.WALL));
		dun.setState(6, 0, factory.getState(StateFactory.WALL));
		dun.setState(7, 0, factory.getState(StateFactory.WALL));
		dun.setState(7, 1, factory.getState(StateFactory.WALL));
		dun.setState(7, 2, factory.getState(StateFactory.WALL));
		dun.setState(7, 3, factory.getState(StateFactory.WALL));
		dun.setState(7, 4, factory.getState(StateFactory.WALL));
		dun.setState(7, 6, factory.getState(StateFactory.WALL));
		dun.setState(7, 7, factory.getState(StateFactory.WALL));
		dun.setState(7, 5, factory.getState(StateFactory.KEY));
		FactoryWeapon wf = new FactoryWeapon();
		FactoryArmor af = new FactoryArmor();
		PotionFactory pf = new PotionFactory();
		KeyFactory kf = new KeyFactory();
		Weapon holdwp = wf.buildWeapon("gun");
		Armor holdam = af.buildArmor("normalarmor");
		Item potion = pf.PotionFactory("AntiPoison");
		Item key = kf.KeysFactory(1);
		LifeForm gublin = new Goblin("Goblin", 30, 10);
		LifeForm mummy = new Mummy("Mummy", 50, 40);
		player.pickUpWeapon(holdwp);
		player.setArmor(holdam);
		player.SetDirection("North");
		dun.addLifeForm(4, 4, player);
		dun.addItem(4, 5, potion, 0);
		dun.addLifeForm(3, 6, gublin);
		dun.addLifeForm(6, 6, mummy);
		dun.addItem(6, 6, key, 0);
		dun.addItem(4, 4, wf.buildWeapon("gun"), 0);
		dun.addItem(4, 4, af.buildArmor("normalarmor"), 1);

		// add something to inventory.
		Weapon inwp = wf.buildWeapon("sword");
		Armor inam = af.buildArmor("sharparmor");
		Item inpotion = pf.PotionFactory("AlihotsyDraught");
		Item inkey = kf.KeysFactory(2);
		player.addToInventory(inwp);
		player.addToInventory(inam);
		player.addToInventory(inpotion);
		player.addToInventory(inkey);
		
		GameDisplay gm = new GameDisplay();
		gm.CreateBaseDisplayer();
		gm.updateTime(0);
		
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Created Player(4,4) and "
				+ "Goblin(3,6) and Mummy(6,6)\nDoes it look right?"));
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Created Weapon and "
				+ "Armor at (4,4)\nDoes it look right?"));
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Created Key"
				+ "at (6,6)\nDoes it look right?"));
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Created Player hold gun with normalArmor"
				+ "facing north and LifePoint is 100 and Strength is 10 and hit point is 0 and experience 0\nDoes it look right?"));
		
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Created Cell(7,5) with "
				+ "Door state \nDoes it look right?"));
		
		assertEquals(JOptionPane.YES_OPTION,JOptionPane.showConfirmDialog(null, "Enclosed with Walls except Cell(7,5) with "
				+ "Door state \nDoes it look right?"));
		
	
	}


}
