package dungeon;
/**
 * Test for dungeon class
 * @author - Prathyusha Akshintala
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import item.Armor;
import item.Item;
import item.Keys;
import item.MockArmor;
import item.MockPotions;
import item.MockWeapon;
import item.Potions;
import item.Weapon;
import lifeform.LifeForm;
import lifeform.MockLifeForm;
import lifeform.Player;

import org.junit.After;
import org.junit.Test;

import dungeon.cell.state.DoorState;
import dungeon.cell.state.MockState;
import dungeon.cell.state.NoWalkThroughState;
import dungeon.cell.state.State;

public class TestDungeon 
{
	@After
	public void after() 
	{
		Dungeon.resetInstance();
		Player.resetInstance();
	}
	/**
	 * @author Prathyusha Akshintala
	 * Resets the dungeon
	 */
	public static void resetDungeon()
	{
		Dungeon.resetInstance();
	}
	/**
	 * @author Prathyusha Akshintala
	 * Initialization tests
	 */
	@Test
	public void testInitialization() 
	{
		Dungeon dungeon1 = Dungeon.getDungeonInstance();

		// Life form will be null for a newly created Dungeon.
		assertNull(dungeon1.getLifeForm(0, 0));
		assertNull(dungeon1.getLifeForm(1, 1));

		Dungeon dungeon2 = Dungeon.getDungeonInstance();
		assertEquals(dungeon1, dungeon2);
		Dungeon.resetInstance();
	}
	/**
	 * @author Prathyusha Akshintala
	 * Test for adding a life form
	 */
	@Test
	public void testAddLifeForm()
	{
		Dungeon dungeon = Dungeon.getDungeonInstance();
		LifeForm mon = new MockLifeForm("Mon", 40, 5);

		// The cell is empty so this should work.
		boolean success = dungeon.addLifeForm(1, 2, mon);
		assertTrue(success);
		assertEquals(mon, dungeon.getLifeForm(1, 2));
		Dungeon.resetInstance();
		// If row and column is -ve
		success = dungeon.addLifeForm(-1, -2, mon);
		assertFalse(success);
		assertNull(dungeon.getLifeForm(-1, -2));
		Dungeon.resetInstance();
		// If row is -ve 
		assertNull(dungeon.getLifeForm(-1, 2));
		Dungeon.resetInstance();
		// If col is -ve 
		assertNull(dungeon.getLifeForm(1, -2));
		Dungeon.resetInstance();
		// If row is and column out of range
		assertNull(dungeon.getLifeForm(10, 10));
		Dungeon.resetInstance();
		// If row is out of range
		assertNull(dungeon.getLifeForm(10, 0));
		Dungeon.resetInstance();
		// If col is out of range
		assertNull(dungeon.getLifeForm(1, 10));
		Dungeon.resetInstance();
		// The cell is not empty so this should fail.
		success = dungeon.addLifeForm(1, 2, mon);
		assertFalse(success);
		Dungeon.resetInstance();

		// The cell in empty we should get null
		assertNull(dungeon.getLifeForm(0, 0));
		Dungeon.resetInstance();
		// The cell location is invalid we should get null
		assertNull(dungeon.getLifeForm(0, 9));
		Dungeon.resetInstance();
		// Another cell location which is invalid as given # of rows is more than range so this should fail
		success = dungeon.addLifeForm(9, 2, mon);
		assertFalse(success);
		Dungeon.resetInstance();
		// Another cell location which is invalid as given # of cols is more than range so this should fail
		success = dungeon.addLifeForm(2, 10, mon);
		assertFalse(success);
		Dungeon.resetInstance();
		
		//Another location which is invalid because of -ve number of rows
		success = dungeon.addLifeForm(-9, 2, mon);
		assertFalse(success);
		Dungeon.resetInstance();
		//Another location which is invalid because of -ve number of cols
		success = dungeon.addLifeForm(8, -2, mon);
		assertFalse(success);
		Dungeon.resetInstance();
	}
	/**
	 * @author Prathyusha Akshintala
	 * tests to remove lifeform
	 */
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
		
		// Negative rows and columns
		assertNull(dungeon.removeLifeForm(-5, -4));
		
		// Negative row 
		assertNull(dungeon.removeLifeForm(-5, 4));
		
		// Negative col
		assertNull(dungeon.removeLifeForm(5, -4));
		Dungeon.resetInstance();
	}
	/**
	 * @author Prathyusha Akshintala
	 * Test to get row and column numbers
	 */
	@Test
	public void testGetRowAndColNumbers()
	{
		Dungeon dungeon = Dungeon.getDungeonInstance();
		assertEquals(8,dungeon.getNumberOfRow());
		assertEquals(8,dungeon.getNumberOfCol());
		Dungeon.resetInstance();
	}
	/**
	 * @author Prathyusha Akshintala
	 * Test for getting distance between two lifeforms.
	 */
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
		assertEquals(2, dungeon.getDistance(james, sirius));
		// If the lifeforms are in the same column.
		assertEquals(4, dungeon.getDistance(sirius, remus));
		// If the lifeforms are in different row and different column.
		assertEquals(4, dungeon.getDistance(james, remus));
		// Boundary conditions
		dungeon.removeLifeForm(2, 1);
		dungeon.removeLifeForm(6, 3);
		assertEquals(-1, dungeon.getDistance(james, sirius));
		assertEquals(-1, dungeon.getDistance(sirius, remus));
		
		dungeon.addLifeForm(9, 3, james);
		dungeon.addLifeForm(6, 9, sirius);
		assertEquals(-1, dungeon.getDistance(james, sirius));
		
		dungeon.addLifeForm(3, 9, james);
		dungeon.addLifeForm(9, 6, sirius);
		assertEquals(-1, dungeon.getDistance(james, sirius));
		
		dungeon.addLifeForm(9, 4, james);
		dungeon.addLifeForm(9, 5, sirius);
		assertEquals(-1, dungeon.getDistance(james, sirius));
		
		dungeon.addLifeForm(8, 9, james);
		dungeon.addLifeForm(7, 9, sirius);
		assertEquals(-1, dungeon.getDistance(james, sirius));
		
		dungeon.addLifeForm(9, 9, james);
		dungeon.addLifeForm(10, 9, sirius);
		assertEquals(-1, dungeon.getDistance(james, sirius));
		Dungeon.resetInstance();
	}
	/**
	 * @author Prathyusha Akshintala
	 * Test for get item from the dungeon from a particular cell and position
	 */
	@Test
	public void testGetItem() 
	{
		Dungeon dungeon = Dungeon.getDungeonInstance();
		Armor a1 = new MockArmor("SharpArmor");
		Potions p2 = new MockPotions(5);
		dungeon.addItem(1, 1, a1, 0);
		dungeon.addItem(1, 1, p2, 1);
		assertEquals(a1, dungeon.getItem(1, 1, 0));
		assertEquals(p2, dungeon.getItem(1, 1, 1));
		Dungeon.resetInstance();
	}
	/**
	 * @author Prathyusha Akshintala
	 * Test to add item to dungeon to a particular cell and position
	 */
	@Test
	public void testAddItem() 
	{
		Dungeon dungeon = Dungeon.getDungeonInstance();
		Weapon w1 = new MockWeapon("Spear");
		Armor a2 = new MockArmor("ImmunePoison");
		assertTrue(dungeon.addItem(1, 2, w1, 0));
		assertTrue(dungeon.addItem(1, 2, a2, 1));
		// Boundary conditions
		assertFalse(dungeon.addItem(9, 8, w1, 1));
		assertFalse(dungeon.addItem(8, 9, a2, 0));
		assertFalse(dungeon.addItem(9, 9, w1, 1));
		Dungeon.resetInstance();
	}

	/**
	 * @author Prathyusha Akshintala
	 * Test to remove item from dungeon from a particular cell and position
	 */
	@Test
	public void testRemoveItem() 
	{
		Dungeon dungeon = Dungeon.getDungeonInstance();
		Weapon w1 = new MockWeapon("Spear");
		Armor a2 = new MockArmor("ImmunePoison");
		dungeon.addItem(1, 2, w1, 0);
		dungeon.addItem(1, 2, a2, 1);
		assertEquals(w1, dungeon.removeItem(1, 2, 0));
		assertEquals(a2, dungeon.removeItem(1, 2, 1));
		// Boundary conditions
		assertNull(dungeon.removeItem(9, 8, 1));
		assertNull(dungeon.removeItem(8, 9, 0));
		assertNull(dungeon.removeItem(9, 9, 1));
		Dungeon.resetInstance();
	} 
	/**
	 * @author Prathyusha Akshintala
	 * Test to set and get state of the dungeon
	 */
	@Test
	public void testSetAndGetState()
	{
		Dungeon dungeon = Dungeon.getDungeonInstance();
		State state = new MockState();
		dungeon.setState(1, 2, state);
		assertEquals(state,dungeon.getState(1, 2));
		Dungeon.resetInstance();
	}
	
	@Test
	public void testMoveMethod()
	{
		Dungeon dungeon = Dungeon.getDungeonInstance();
		Player player =(Player) Player.getPlayerInstance();
		player.SetDirection("north");
		dungeon.addLifeForm(2, 2, player);
		//wall state can't be move
		dungeon.setState(1, 2, new NoWalkThroughState());
		assertFalse(dungeon.move(2, 2));
		assertEquals(player,dungeon.getLifeForm(2, 2));
		assertNull(dungeon.getLifeForm(1, 2));
		
		//Door state can't be move.
		player.SetDirection("south");
		Item key = new Keys(1);
		dungeon.setState(3, 2, new DoorState(key));
		assertFalse(dungeon.move(2, 2));
		assertEquals(player,dungeon.getLifeForm(2, 2));
		assertNull(dungeon.getLifeForm(3, 2));
		//use key, can move
		player.addToInventory(key);
		assertTrue(player.useItem(0));
		assertTrue(dungeon.move(2, 2));
		assertEquals(player,dungeon.getLifeForm(3, 2)); 
		assertNull(dungeon.getItem(2, 2, 0));
		Dungeon.resetInstance();
		Player.resetInstance();
	}
}
