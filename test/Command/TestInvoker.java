package Command;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dungeon.Dungeon;
import item.Gun;
import item.MockWeapon;
import item.Weapon;
import lifeform.Goblin;
import lifeform.LifeForm;
import lifeform.MockCreature;
import lifeform.MockLifeForm;
import lifeform.Player;

public class TestInvoker {

	
	/**
	 * Clear all the LifeForms and Items  in the Dungeon before each test. 
	 */
	@Before
	public void resetDungonBefore() {
		Dungeon.resetInstance();
	} 
	
	/**
	 * Clear all the LifeForms and Items  in the Dungeon after all tests. 
	 */
	@After
	public void resetDungonBeAfter() {
		Dungeon.resetInstance();
	} 
	
	
	/**
	 * Test move button and to ensure that will get the event and call the move command 
	 * 
	 */
	@Test
	public void testMoveCommand() {
		
		Dungeon den = Dungeon.getDungeonInstance();
		LifeForm life = new MockLifeForm("Bob", 50, 10);
		InvokerBuilder build = new InvokerBuilder();
		Invoker in = build.getInvoker(life);
		//add life form 
		den.addLifeForm(1, 1, life); 
		//Set the life form to the west 
		life.SetDirection("west");
	    in.move.doClick();
		
		// check when the life form moved 
		assertEquals(life , den.getLifeForm(1, 0));  
		
		
	}
	
	/**
	 * Test move button and to ensure that will get the event and call the move command 
	 * 
	 */
	@Test
	public void testturnWestCommand() {
		
		Dungeon den = Dungeon.getDungeonInstance();
		LifeForm life = new MockLifeForm("Bob", 50, 10);
		InvokerBuilder build = new InvokerBuilder();
		Invoker in = build.getInvoker(life);
		//add life form 
		den.addLifeForm(1, 1, life); 
		//Set the life form to the west 
		in.west.doClick();
	    in.move.doClick();
		
		// check when the life form moved 
		assertEquals(life , den.getLifeForm(1, 0));  
		
		
	}
	
	@Test
	public void testturnSouthCommand() {
		
		Dungeon den = Dungeon.getDungeonInstance();
		LifeForm life = new MockLifeForm("Bob", 50, 10);
		InvokerBuilder build = new InvokerBuilder();
		Invoker in = build.getInvoker(life);
		//add life form 
		den.addLifeForm(1, 1, life); 
		//Set the life form to the west 
		in.south.doClick();
	    in.move.doClick();
		
		// check when the life form moved 
		assertEquals(life , den.getLifeForm(2, 1));  
		
		
	}
	
	@Test
	public void testturnNorthCommand() {
		
		Dungeon den = Dungeon.getDungeonInstance();
		LifeForm life = new MockLifeForm("Bob", 50, 10);
		InvokerBuilder build = new InvokerBuilder();
		Invoker in = build.getInvoker(life);
		//add life form 
		den.addLifeForm(1, 1, life); 
		//Set the life form to the west 
		in.north.doClick();
	    in.move.doClick();
		
		// check when the life form moved 
		assertEquals(life , den.getLifeForm(0, 1));  
		
		
	}
	
	@Test
	public void testturnEastCommand() {
		
		Dungeon den = Dungeon.getDungeonInstance();
		LifeForm life = new MockLifeForm("Bob", 50, 10);
		InvokerBuilder build = new InvokerBuilder();
		Invoker in = build.getInvoker(life);
		//add life form 
		den.addLifeForm(1, 1, life); 
		//Set the life form to the west 
		in.east.doClick();
	    in.move.doClick();
		
		// check when the life form moved 
		assertEquals(life , den.getLifeForm(1, 2));  
		
		
	}
	
	@Test
	public void testRelaodCommand() {
		
		Dungeon den = Dungeon.getDungeonInstance();
		LifeForm life = new MockLifeForm("Bob", 50, 10);
		InvokerBuilder build = new InvokerBuilder();
		Invoker in = build.getInvoker(life);
		//add life form 
		den.addLifeForm(1, 1, life); 
		Weapon wp = new Gun();
		life.pickUpWeapon(wp);
		assertEquals(40,((Gun) wp).getActualAmmo(),.1);
		wp.calculateDamage(10);
		assertEquals(39 , ((Gun) wp).getActualAmmo(),.1);
		((Gun) wp).setActualAmmo(0);
		in.reload.doClick();
		assertEquals(40, ((Gun) wp).getActualAmmo(),.1); 
	} 
	
	@Test
	public void testDropCommand() {
		
		Dungeon den = Dungeon.getDungeonInstance(); 
		Player player =(Player) Player.getPlayerInstance(); 
		equals(player instanceof LifeForm);
		InvokerBuilder build = new InvokerBuilder();
		Invoker in = build.getInvoker(player);
		//add life form 
		den.addLifeForm(1, 1, player); 
		Weapon wp = new MockWeapon("sharp"); 
		Weapon wp2 = new MockWeapon("sharp2");
		den.addItem(1, 1, wp2, 0);
		player.pickUpWeapon(wp);
		//Check first there is no weapon in the cell 
		assertNull(den.getItem(1, 1, 1));
		in.drop.doClick();
		assertEquals(wp , den.getItem(1, 1, 1)); 
		
	}  
	
	@Test
	public void testAquireCommand() {
		
		Dungeon den = Dungeon.getDungeonInstance(); 
		Player player =(Player) Player.getPlayerInstance(); 
		equals(player instanceof LifeForm);
		InvokerBuilder build = new InvokerBuilder();
		Invoker in = build.getInvoker(player);
		//add life form 
		den.addLifeForm(1, 1, player); 
		Weapon wp = new MockWeapon("sharp"); 
		den.addItem(1, 1, wp, 0);
		assertEquals(wp , den.getItem(1, 1, 0));
		in.acquire.doClick();
		assertNull(den.getItem(1,1, 0));
		
	} 
	
	
	@Test
	public void testAttackCommand() {
		
		Dungeon den = Dungeon.getDungeonInstance();
		LifeForm life = new MockLifeForm("Bob",50 , 10);
	    LifeForm target = new MockCreature("creature",60 , 5);
	    InvokerBuilder build = new InvokerBuilder();
		Invoker in = build.getInvoker(life);
		den.addLifeForm(3,3, life);
		den.addLifeForm(2, 3, target);
		
		
		Weapon wp = new Gun();
		life.pickUpWeapon(wp);
		
		assertEquals(60, target.getLifePoints());  
		life.SetDirection("north"); 
		in.attack.doClick();
		
		assertEquals(45 , target.getLifePoints());
		
	} 

}
