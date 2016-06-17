package lifeform;

import static org.junit.Assert.*;

import org.junit.Test;

import exception.RecoveryException;
import recovery.Recovery;
import recovery.RecoveryLinear;

public class TestCreature 
{

	@Test
	public void testInitialization() 
	{
		Player mario = (Player) Player.getPlayerInstance();
		Creature creature = new MockCreature("Jack", 30, 5);
		assertEquals("Jack", creature.getName());
		assertEquals(30, creature.getLifePoints());

		creature = new MockCreature("Jack", -30, 5);
		creature.recover();
		assertEquals(0, creature.getLifePoints());

		Recovery rec = new RecoveryLinear(5);
		creature = new MockCreature("Jack", 30, 5, rec);
		creature.setMaxLife(40);
		assertEquals(40,creature.getMaxLife());
		creature.takeHit(mario, 20);

		creature.recover();
		// Test with RecoveryLinear.
		assertEquals(15, creature.getLifePoints());
	}
	
	@Test
	public void testSetCurrentLifePoints()
	{
		Creature creature = new MockCreature("Jack", 0, 5);
		creature.setMaxLife(40);
		creature.setCurrentLife(30);
		assertEquals(30,creature.getLifePoints());
		
		creature.setCurrentLife(-30);
		assertEquals(0,creature.getLifePoints());
		
		creature.setCurrentLife(50);
		assertEquals(40,creature.getLifePoints());
	}
	
	@Test
	public void testSetRecoveryRate() throws RecoveryException
	{
		Recovery rec = new RecoveryLinear(3);
		Creature creature = new MockCreature("Dobby", 60, 5, rec, 1);
		// Recovery rate 1.
		assertEquals(1, creature.getRecoveryRate());
		creature.setRecoveryRate(2);
		assertEquals(2, creature.getRecoveryRate());
		creature.setRecoveryRate(0);
		assertEquals(0, creature.getRecoveryRate());
}
}
