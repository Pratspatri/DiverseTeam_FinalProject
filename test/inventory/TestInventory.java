package inventory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import item.Armor;
import item.Item;
import item.Keys;
import item.MockArmor;
import item.MockItem;
import item.MockPotions;
import item.MockWeapon;
import item.Potions;
import item.Weapon;
import lifeform.Player;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dungeon.Dungeon;
import dungeon.cell.state.CanWalkThroughState;
import dungeon.cell.state.DoorState;

/**
 * Test Inventory Class.
 * @author Jixiang Lu
 *
 */
public class TestInventory
{

	/**
	 * Resets Dungeon and Player before each test.
	 */
	@Before
	public void resetDungeonAndPlayerBefore()
	{
		Dungeon.resetInstance();
		Player.resetInstance();
	}
	
	/**
	 * Resets Dungeon and Player after each test.
	 */
	@After
	public void resetDungeonAndPlayerAfter()
	{
		Dungeon.resetInstance();
		Player.resetInstance();
	}
	/**
	 * Tests the initialization.
	 */
	@Test
	public void testInitialization()
	{
		Inventory inv = new PlayerInventory();
		assertEquals(10,inv.getMaxSize());
		assertEquals(0,inv.getActualSize());
		
		inv = new PlayerInventory(5);
		assertEquals(5,inv.getMaxSize());
		assertEquals(0,inv.getActualSize());
	}

	/**
	 * Tests the operations to manipulate the item.
	 * AddItem, RemoveItem, getItem.
	 */
	@Test
	public void testAddAndRemoveAndGetItem()
	{
		Inventory inv = new PlayerInventory();
		//add null will return false.
		assertFalse(inv.addItem(null));
		
		Item item = new MockItem("Mock1");
		assertTrue(inv.addItem(item));
		assertEquals(item,inv.getItem(inv.index(item)));
		assertEquals(1,inv.getActualSize());
		
		inv.setMaxSize(2);
		Item item2 = new MockItem("Mock2");
		Item item3 = new MockItem("Mock3");
		assertTrue(inv.addItem(item2));
		assertEquals(2,inv.getActualSize());
		//the inventory is full.
		assertFalse(inv.addItem(item3));
		assertEquals(2,inv.getActualSize());
		
		//remove method
		assertEquals(item,inv.removeItem(0));
		assertEquals(1,inv.getActualSize());
		assertEquals(item2,inv.removeItem(0));
		assertEquals(0,inv.getActualSize());
		
		//remove with invalid parameter
		assertNull(inv.removeItem(10));	
		
		//getItem with invalid parameter.
		assertNull(inv.getItem(5));
	}
	
	/**
	 * Tests setSize methods which consist of SetActualSize and SetMaxSize.
	 */
	@Test
	public void testSetSize()
	{
		Inventory inv = new PlayerInventory();
		//MaxSize can't be less than ActualSize.
		inv.setActualSize(5);
		inv.setMaxSize(3);
		assertEquals(5,inv.getMaxSize());
		//ActualSize can't be large than MaxSize
		inv.setActualSize(10);
		assertEquals(5,inv.getActualSize());
	}
	
	/**
	 * Tests iterator to iterate over the inventory.
	 */
	@Test
	public void testIterator()
	{
		Inventory inv = new PlayerInventory();
		Item item1 = new MockItem("W1");
		Item item2 = new MockItem("W2");
		Item item3 = new MockItem("W3");
		inv.addItem(item1);
		inv.addItem(item2);
		inv.addItem(item3);
		
		Iterator it = inv.getIterator();
		assertTrue(it.hasNext());
		assertEquals(item1,it.next());
		assertTrue(it.hasNext());
		assertEquals(item2,it.next());
		assertTrue(it.hasNext());
		assertEquals(item3,it.next());
		assertFalse(it.hasNext());
		assertNull(it.next());
	}
	
	/**
	 * Tests Use Method except Key part.
	 */
	@Test
	public void testUse()
	{
		Player pl = (Player)Player.getPlayerInstance();
		Inventory inv = new PlayerInventory();
		Item item1 = new MockItem("W1");
		Weapon wp = new MockWeapon("Weapon1");
		Armor am = new MockArmor("Armor");
		Potions pt = new MockPotions(10);
		inv.addItem(item1);
		inv.addItem(wp);
		inv.addItem(am);
		inv.addItem(pt);
		//use invalid index
		assertFalse(inv.use(pl, 10));
		//use unknow item.
		assertFalse(inv.use(pl, 0));
		//use Weapon
		assertTrue(inv.use(pl, 1));
		assertEquals(wp,pl.getWeapon());
		//use Armor		
		assertTrue(inv.use(pl, 1));
		assertEquals(am,pl.getArmor());
		//use potion
		pl.setStrength(10);
		assertTrue(inv.use(pl, 1));
		assertEquals(13,pl.getStrength());
		
	}
	
	/**
	 * Test the key part of use method.
	 */
	@Test
	public void testUseKey()
	{
		Dungeon dg = Dungeon.getDungeonInstance();
		Player pl = (Player)Player.getPlayerInstance();
		Inventory inv = new PlayerInventory();
		Item key1 = new Keys(1);
		inv.addItem(key1);
		pl.SetDirection("north");
		
		//if the player isn't in the Dungeon, use method will do nothing.
		assertFalse(inv.use(pl, 0));
		//add the player in the Dungeon.
		dg.addLifeForm(2, 2, pl);
		
		//use key for the Cell without DoorState, key will not be disappear.
		//The Cell which player faces will not be changed.
		assertFalse(inv.use(pl, 0));
		assertEquals(key1,inv.getItem(0));
		
		//If the key is invalid. key will not be disappear.
		//The Cell which player faces will not be changed.
		dg.setState(1, 2, new DoorState(new Keys(2)));
		assertFalse(inv.use(pl, 0));
		assertEquals(key1,inv.getItem(0));
		assertTrue(dg.getState(1, 2) instanceof DoorState);
		
		//if the key is valid and the Cell which player faces is DoorState
		//The State of the Cell will be change to CanWalkThroughState, and key will be disappear.
		dg.setState(1, 2, new DoorState(key1));
		assertTrue(inv.use(pl, 0));
		assertNull(inv.getItem(0));
		assertTrue(dg.getState(1, 2) instanceof CanWalkThroughState);
		
		//Test Same thing but the player faces different direction.
		//faces Not DoorState.
		inv.addItem(key1);
		pl.SetDirection("south");
		assertFalse(inv.use(pl, 0));
		assertEquals(key1,inv.getItem(0));
		//face DoorState but wrong key.
		dg.setState(3, 2,new DoorState(new Keys(2)));
		assertFalse(inv.use(pl, 0));
		assertEquals(key1,inv.getItem(0));
		assertTrue(dg.getState(3, 2) instanceof DoorState);
		//Right key.
		dg.setState(3, 2, new DoorState(key1));
		assertTrue(inv.use(pl, 0));
		assertNull(inv.getItem(0));
		assertTrue(dg.getState(3, 2) instanceof CanWalkThroughState);
		
		//West
		//faces Not DoorState.
		inv.addItem(key1);
		pl.SetDirection("west");
		assertFalse(inv.use(pl, 0));
		assertEquals(key1,inv.getItem(0));
		//face DoorState but wrong key.
		dg.setState(2, 1,new DoorState(new Keys(2)));
		assertFalse(inv.use(pl, 0));
		assertEquals(key1,inv.getItem(0));
		assertTrue(dg.getState(2, 1) instanceof DoorState);
		//Right key.
		dg.setState(2, 1, new DoorState(key1));
		assertTrue(inv.use(pl, 0));
		assertNull(inv.getItem(0));
		assertTrue(dg.getState(2, 1) instanceof CanWalkThroughState);
		
		//East
		//faces Not DoorState.
		inv.addItem(key1);
		pl.SetDirection("east");
		assertFalse(inv.use(pl, 0));
		assertEquals(key1,inv.getItem(0));
		//face DoorState but wrong key.
		dg.setState(2, 3,new DoorState(new Keys(2)));
		assertFalse(inv.use(pl, 0));
		assertEquals(key1,inv.getItem(0));
		assertTrue(dg.getState(2, 3) instanceof DoorState);
		//Right key.
		dg.setState(2, 3, new DoorState(key1));
		assertTrue(inv.use(pl, 0));
		assertNull(inv.getItem(0));
		assertTrue(dg.getState(2, 3) instanceof CanWalkThroughState);
		
		//Wrong Direction
		pl.SetDirection("XXXX");
		inv.addItem(key1);
		assertFalse(inv.use(pl, 0));
		assertEquals(key1,inv.getItem(0));
	}
}