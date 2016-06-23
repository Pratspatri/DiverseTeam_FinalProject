package Command;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ability.MockAbility;
import dungeon.Dungeon;
import item.Gun;
import item.MockWeapon;
import item.Spear;
import item.Sword;
import item.Weapon;
import lifeform.Creature;
import lifeform.Goblin;
import lifeform.LifeForm;
import lifeform.MockCreature;
import lifeform.MockLifeForm;
import lifeform.Player;
/**
 * Attack command test class
 * @author Saad
 *
 */

public class TestAttackCommand {

	
	
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
	 * Test attack with gun and calculate the damage 
	 */
	 
	@Test
	public void testExecuteAttackwithGun() {
				
		
		Dungeon den = Dungeon.getDungeonInstance();
		LifeForm attacker = new MockLifeForm("Bob",50 , 10);
	    LifeForm target = new MockCreature("creature",60 , 5);
	    
		den.addLifeForm(3,3, attacker);
		den.addLifeForm(2, 3, target); 
		
		
		Weapon wp = new Gun();
		attacker.pickUpWeapon(wp);
		
		assertEquals(60, target.getLifePoints());  
		attacker.SetDirection("north"); 
		Command attack = new  AttackCommand(attacker); 
		assertTrue(attack instanceof AttackCommand);
		
		String s = attack.execute();
		assertEquals(s , "Attack target!");
		// the expected result  
		assertEquals(45, target.getLifePoints()); 
		den.removeLifeForm(2, 3);
		
		
		//Test when the Target out of max range
		
		 LifeForm target2 = new MockCreature("creature",60 , 5);
		 den.addLifeForm(33, 33, target2);
		 assertEquals(60, target2.getLifePoints()); 
		   s = attack.execute();
		   assertEquals(s , "Can't attack!");
		   assertEquals(60, target2.getLifePoints()); 
		
		
	} 
	/**
	 * Test attack with Spare and calculate the damage 
	 */
	
	@Test
	public void testExecuteAttackwithSpaer() {
				
		
		Dungeon den = Dungeon.getDungeonInstance();
		LifeForm attacker = new MockLifeForm("Bob",50 , 10);
	   LifeForm target = new MockCreature("creature",60 , 5);
	    
		den.addLifeForm(3,3, attacker);
		den.addLifeForm(2, 3, target);
		
		
		Weapon spaer = new Spear();
		attacker.pickUpWeapon(spaer);
		
		assertEquals(60, target.getLifePoints());  
		attacker.SetDirection("north"); 
		Command attack = new  AttackCommand(attacker); 
		assertTrue(attack instanceof AttackCommand);
		
		String s = attack.execute();
		assertEquals(s , "Attack target!");
		// the expected result  
		assertEquals(37, target.getLifePoints());  
        den.removeLifeForm(2, 3);
		
		
		//Test when the Target out of max range
		
		 LifeForm target2 = new MockCreature("creature",60 , 5);
		 den.addLifeForm(33, 33, target2);
		 assertEquals(60, target2.getLifePoints()); 
		   s = attack.execute();
		   assertEquals(s , "Can't attack!");
		   assertEquals(60, target2.getLifePoints()); 
			
		
		
	}
	
	/**
	 * Test attack with Sword and calculate the damage 
	 */
	
	@Test
	public void testExecuteAttackwithSword() {
				
		
		Dungeon den = Dungeon.getDungeonInstance();
		LifeForm attacker = new MockLifeForm("Bob",50 , 10);
	   LifeForm target = new MockCreature("creature",60 , 5);
	   
		den.addLifeForm(3,3, attacker);
		den.addLifeForm(2, 3, target);
		
		
		Sword sowrd = new Sword();
		attacker.pickUpWeapon(sowrd);
		
		assertEquals(60, target.getLifePoints());  
		attacker.SetDirection("north"); 
		Command attack = new  AttackCommand(attacker); 
		assertTrue(attack instanceof AttackCommand);
		
		String s = attack.execute();
		assertEquals(s , "Attack target!");
		// the expected result  
		assertEquals(39, target.getLifePoints());  
        den.removeLifeForm(2, 3);
		
		
		//Test when the Target out of max range
		
		 LifeForm target2 = new MockCreature("creature",60 , 5);
		 den.addLifeForm(33, 33, target2);
		 assertEquals(60, target2.getLifePoints()); 
		   s = attack.execute();
		   assertEquals(s , "Can't attack!");
		   assertEquals(60, target2.getLifePoints()); 
			
		
		
	}
	
	
	@Test
	public void testExecuteAttackSouth() {
				
		
		Dungeon den = Dungeon.getDungeonInstance();
		LifeForm attacker = new MockLifeForm("Bob",50 , 10);
	    LifeForm target = new MockCreature("creature",50 , 10);
		den.addLifeForm(3,3, attacker);
		den.addLifeForm(4, 3, target);
		
		
		Weapon wp = new Gun();
		attacker.pickUpWeapon(wp);
		
		assertEquals(50, target.getLifePoints());  
		attacker.SetDirection("south"); 
		Command attack = new  AttackCommand(attacker); 
		assertTrue(attack instanceof AttackCommand);
		
		String s = attack.execute();
		assertEquals(s , "Attack target!");
		// the expected result  
		assertEquals(35, target.getLifePoints());  
			
		
		
	}
	
	@Test
	public void testExecuteAttackWest() {
				
		
		Dungeon den = Dungeon.getDungeonInstance();
		LifeForm attacker = new MockLifeForm("Bob",50 , 10);
	    LifeForm target = new MockCreature("creature",50 , 10);
		den.addLifeForm(3,3, attacker);
		den.addLifeForm(3, 2, target);
		
		
		Weapon wp = new Gun();
		attacker.pickUpWeapon(wp);
		
		assertEquals(50, target.getLifePoints());  
		attacker.SetDirection("west"); 
		Command attack = new  AttackCommand(attacker); 
		assertTrue(attack instanceof AttackCommand);
		
		String s = attack.execute();
		assertEquals(s , "Attack target!");
		// the expected result  
		assertEquals(35, target.getLifePoints());  
			
		
		
	}
	
	@Test
	public void testExecuteAttackEast() {
				
		
		Dungeon den = Dungeon.getDungeonInstance();
		LifeForm attacker = new MockLifeForm("Bob",50 , 10);
	    LifeForm target = new MockCreature("creature",50 , 10);
		den.addLifeForm(3,3, attacker);
		den.addLifeForm(3, 4, target);
		
		
		Weapon wp = new Gun();
		attacker.pickUpWeapon(wp);
		
		assertEquals(50, target.getLifePoints());  
		attacker.SetDirection("east"); 
		Command attack = new  AttackCommand(attacker); 
		assertTrue(attack instanceof AttackCommand);
		
		String s = attack.execute();
		assertEquals(s , "Attack target!");
		// the expected result  
		assertEquals(35, target.getLifePoints()); 
			
		
		
	}
	
	
	

}
