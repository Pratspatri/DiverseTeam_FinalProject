package dungeon.cell;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import item.Item;
import item.MockItem;
import lifeform.LifeForm;
import lifeform.MockLifeForm;

import org.junit.Test;

import dungeon.cell.state.CanWalkThroughState;
import dungeon.cell.state.MockState;

/**
 * Tests Cell Class.
 * @author Jixiang Lu
 *
 */
public class TestCell
{

	/**
	 * Tests Initialization.
	 */
	@Test
	public void testInitialization()
	{
		Cell cell = new Cell();
		assertTrue(cell.getState() instanceof CanWalkThroughState);
		cell = new Cell(new MockState());
		assertTrue(cell.getState() instanceof MockState);
	}
	
	/**
	 * Tests some methods about LifeForm.
	 * The methods contains addLifeForm, removeLifeForm, getLifeForm.
	 */
	@Test
	public void testLifeForm()
	{
		Cell cell = new Cell(new MockState());
		LifeForm life = new MockLifeForm("Bob",50,50);
		assertNull(cell.getLifeForm());
		
		assertTrue(cell.addLifeForm(life));
		assertEquals(life,cell.getLifeForm());
		
		assertEquals(life, cell.removeLifeForm());
		assertNull(cell.getLifeForm());
		
	}
	
	/**
	 * Tests some methods about Item.
	 * The methods contains addItem, removeItem and getItem.
	 */
	@Test
	public void testItem()
	{
		Cell cell = new Cell(new MockState());
		Item item = new MockItem("Weapon1");
		Item item2 = new MockItem("Weapon2");
		assertNull(cell.getItem(0));
		assertNull(cell.getItem(1));
		
		assertTrue(cell.addItem(item, 0));
		assertEquals(item,cell.getItem(0));
		assertEquals(item,cell.removeItem(0));
		assertNull(cell.getItem(0));
		
		assertTrue(cell.addItem(item2, 1));
		assertEquals(item2,cell.getItem(1));
		assertEquals(item2,cell.removeItem(1));
		assertNull(cell.getItem(1));
	}
	
	/**
	 * Tests setState method and clearCell method.
	 */
	@Test
	public void testSetSateNClearCell()
	{
		Cell cell = new Cell(new MockState());
		LifeForm life = new MockLifeForm("Bob",50,50);
		Item item = new MockItem("Weapon1");
		Item item2 = new MockItem("Weapon2");
		cell.addLifeForm(life);
		cell.addItem(item, 0);
		cell.addItem(item2, 1);
		cell.clearCell();
		assertNull(cell.getLifeForm());
		assertNull(cell.getItem(0));
		assertNull(cell.getItem(1));
		
		cell.setState(new CanWalkThroughState());
		assertTrue(cell.getState() instanceof CanWalkThroughState);
		
	}

}
