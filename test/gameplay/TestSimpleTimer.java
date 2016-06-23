package gameplay;

import static org.junit.Assert.*;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import lifeform.Player;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dungeon.Dungeon;

/**
 * Test SimpleTimer Class and the classes implement TimerObserver interface.
 * @author Jixiang Lu
 *
 */
public class TestSimpleTimer
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
	 * Test Dungeon's update method.
	 */
	@Test
	public void testDungeon()
	{
		Timer timer = new SimpleTimer();
		Dungeon dug =Dungeon.getDungeonInstance();
		assertTrue(dug instanceof TimerObserver);
		
		timer.addTimeObserver(dug);
		LifeForm life = new MockLifeForm("Bob",0,0);
		LifeForm life2 = new MockLifeForm("Bob",10,10);
		dug.addLifeForm(0, 0, life);
		dug.addLifeForm(0, 1, life2);
		timer.notice();
		
		assertNull(dug.getLifeForm(0, 0));
		assertEquals(life2,dug.getLifeForm(0, 1));
		
		timer.removeTimerObserver(dug);
		life2.setLifePoints(0);
		timer.notice();
		assertEquals(life2,dug.getLifeForm(0, 1));
		
	}

}
