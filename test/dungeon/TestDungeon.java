package dungeon;

import static org.junit.Assert.*;
import item.Armor;
import item.MockArmor;
import item.MockPotions;
import item.MockWeapon;
import item.Potions;
import item.Weapon;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

import org.junit.After;
import org.junit.Test;

public class TestDungeon 
{

	@After
	public void after() 
	{
		Dungeon.resetInstance();
	}
	
	public static void resetDungeon()
	{
		Dungeon.resetInstance();
	}
	
	@Test
	public void testInitialization() 
	{
		Dungeon dungeon1 = Dungeon.getDungeonInstance();

		// Life form will be null for a newly created Dungeon.
		assertNull(dungeon1.getLifeForm(0, 0));
		assertNull(dungeon1.getLifeForm(1, 1));

		Dungeon dungeon2 = Dungeon.getDungeonInstance();
		assertEquals(dungeon1, dungeon2);
	}
	
	@Test
	public void testAddLifeForm()
	{
		Dungeon dungeon = Dungeon.getDungeonInstance();
		LifeForm mon = new MockLifeForm("Mon", 40, 5);

		// The cell is empty so this should work.
		boolean success = dungeon.addLifeForm(1, 2, mon);
		assertTrue(success);
		assertEquals(mon, dungeon.getLifeForm(1, 2));

		// The cell is not empty so this should fail.
		success = dungeon.addLifeForm(1, 2, mon);
		assertFalse(success);

		// The cell in empty we should get null
		assertNull(dungeon.getLifeForm(0, 0));

		// The cell location is invalid we should get null
		assertNull(dungeon.getLifeForm(0, 9));
		
		// Another cell location which is invalid as given # of rows is more than range so this should fail
		success = dungeon.addLifeForm(9, 2, mon);
		assertFalse(success);
		
		// Another cell location which is invalid as given # of cols is more than range so this should fail
		success = dungeon.addLifeForm(2, 10, mon);
		assertFalse(success);
		
		//Another location which is invalid because of -ve number of rows
		success = dungeon.addLifeForm(-9, 2, mon);
		assertFalse(success);
		
		//Another location which is invalid because of -ve number of cols
		success = dungeon.addLifeForm(8, -2, mon);
		assertFalse(success);
	}
	
	@Test
	public void testRemovelifeForm()
	{
		Dungeon dungeon = Dungeon.getDungeonInstance();
		LifeForm mon = new MockLifeForm("Mon", 40, 5);
		
		// The cell is empty so this should work.
		boolean success = dungeon.addLifeForm(1, 2, mon);
		assertTrue(success);
		// Life form is not added at location 1,1 so it should fail.
		assertNull(dungeon.removeLifeForm(1, 1));

		// Location out of range so it should return null
		assertNull(dungeon.removeLifeForm(2, 9));

		// Location out of range so it should return null
		assertNull(dungeon.removeLifeForm(9, 3));

		// Location out of range so it should return null
		assertNull(dungeon.removeLifeForm(-2, -5));
		
		// Life form is added so it should work.
		assertEquals(mon, dungeon.removeLifeForm(1, 2));
		
		// LifeForm is not added to (0,0) so it should return null 
		assertNull(dungeon.removeLifeForm(0, 0));
		
	}
	
	@Test
	public void testGetRowAndColNumbers()
	{
		Dungeon dungeon = Dungeon.getDungeonInstance();
		assertEquals(8,dungeon.getNumberOfRow());
		assertEquals(8,dungeon.getNumberOfCol());
	}
	
	@Test
	public void testDistance() 
	{
		Dungeon dungeon = Dungeon.getDungeonInstance();
		LifeForm james = new MockLifeForm("James", 35, 5);
		LifeForm sirius = new MockLifeForm("Sirius", 38, 7);
		LifeForm remus = new MockLifeForm("Remus", 50, 10);
		dungeon.addLifeForm(2, 1, james);
		dungeon.addLifeForm(2, 3, sirius);
		dungeon.addLifeForm(6, 3, remus);
		
		// If the lifeforms are in the same row.
		assertEquals(10, dungeon.getDistance(james, sirius));
		// If the lifeforms are in the same column.
		assertEquals(20, dungeon.getDistance(sirius, remus));
		// If the lifeforms are in different row and different column.
		assertEquals(22, dungeon.getDistance(james, remus));

		dungeon.removeLifeForm(2, 1);
		dungeon.removeLifeForm(6, 3);
		assertEquals(-1, dungeon.getDistance(james, sirius));
		assertEquals(-1, dungeon.getDistance(sirius, remus));
	}
	
	@Test
	public void testGetItem() 
	{
		Dungeon dungeon = Dungeon.getDungeonInstance();
		Armor a1 = new MockArmor("SharpArmor");
		Potions p2 = new MockPotions(5);
		dungeon.addItem(1, 1, a1, 1);
		dungeon.addItem(2, 1, p2, 2);
		assertEquals(a1, dungeon.getItem(1, 1, 1));
		//TODO check with others for why this is failing
		assertEquals(p2, dungeon.getItem(1, 1, 2));
	}
	
	@Test
	public void testAddItem() 
	{
		Dungeon dungeon = Dungeon.getDungeonInstance();
		Weapon w1 = new MockWeapon("Spear");
		Armor a2 = new MockArmor("ImmunePoison");
		assertTrue(dungeon.addItem(1, 2, w1, 1));
		// TODO check here for the same above reason
		assertTrue(dungeon.addItem(1, 2, a2, 2));

		assertFalse(dungeon.addItem(9, 8, w1, 1));
		assertFalse(dungeon.addItem(8, 9, a2, 2));
		assertFalse(dungeon.addItem(9, 9, w1, 1));
	}

	@Test
	public void testRemoveItem() 
	{
		Dungeon dungeon = Dungeon.getDungeonInstance();
		Weapon w1 = new MockWeapon("Spear");
		Armor a2 = new MockArmor("ImmunePoison");
		dungeon.addItem(1, 2, w1, 1);
		dungeon.addItem(1, 2, a2, 2);
		assertEquals(w1, dungeon.removeItem(1, 2, 1));
		//TODO same as above - check for position
		assertEquals(a2, dungeon.removeItem(1, 2, 2));
		
		assertNull(dungeon.removeItem(9, 8, 1));
		assertNull(dungeon.removeItem(8, 9, 2));
		assertNull(dungeon.removeItem(9, 9, 1));
	}
	
	//TODO tests for set and get states - check with jixiang
}
