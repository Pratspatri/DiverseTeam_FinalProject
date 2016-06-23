package inventory;

import item.Armor;
import item.Item;
import item.Keys;
import item.Potions;
import item.Weapon;

import java.util.ArrayList;

import lifeform.LifeForm;
import lifeform.Player;
import dungeon.Dungeon;
import dungeon.cell.state.DoorState;
import dungeon.cell.state.StateFactory;

/**
 * It represent a Player's Inventory which has a fixed size.
 * 
 * @author Jixiang Lu
 *
 */
public class PlayerInventory implements Inventory
{
	private ArrayList<Item> items;
	private int maxSize;
	private int actualSize;

	/**
	 * Create a PlayInventory with 10 locations.
	 */
	public PlayerInventory()
	{
		this(10);
	}

	/**
	 * Create PlayInventory with a specific size.
	 * 
	 * @param size
	 *            specific size
	 */
	public PlayerInventory(int size)
	{
		items = new ArrayList<Item>();
		maxSize = size;
		actualSize = 0;
	}

	/**
	 * Adds Item into inventory.
	 * 
	 * @param item
	 *            the Item will be added.
	 * @return true if the item has been added successfully. Otherwise, return
	 *         false.
	 */
	@Override
	public boolean addItem(Item item)
	{
		if (item == null)
			return false;
		else if (actualSize < maxSize)
		{
			items.add(item);
			actualSize += 1;
			return true;
		} else
		{
			return false;
		}
	}

	/**
	 * Removes Item from the inventory.
	 * 
	 * @param index
	 *            the Item will be removed.
	 * @return the removed item if removing operation has been done
	 *         successfully.Otherwise Return null.
	 */
	@Override
	public Item removeItem(int index)
	{
		try
		{
			Item it = items.remove(index);
			this.actualSize -= 1;
			return it;
		} catch (IndexOutOfBoundsException ex)
		{
			return null;
		}

	}

	/**
	 * Use the item which is stored in the Inventory for specific LifeForm.
	 * To use Weapon will to exchange selected weapon with weapon player hold.
	 * To use Armor will to exchange selected armor with armor player hold.
	 * To use Potions will to change the player's strength.
	 * To use Key will to attempt to the Cell player face. If the Cell is DoorState
	 * and key is correct, the key will disappear.Otherwise,  the key will do nothing.
	 * 
	 * @param life
	 *            the LifeForm who own the Inventory.
	 * @param index
	 *            the specific index of the inventory.
	 * @return True if the item has been used successfully. Otherwise, return
	 *         false.
	 */
	@Override
	public boolean use(LifeForm life, int index)
	{
		if (index >= items.size())
			return false;
		else
		{
			Item item = items.get(index);
			if (item instanceof Weapon)
			{
				Weapon temp = life.getWeapon();
				life.dropWeapon();
				life.pickUpWeapon((Weapon) item);
				items.remove(index(item));
				items.add(temp);
				return true;
			} else if (item instanceof Armor)
			{
				Player pl = (Player) life;
				Armor temp = pl.getArmor();
				pl.setArmor((Armor) item);
				items.remove(index(item));
				items.add(temp);
				return true;
			} else if (item instanceof Potions)
			{
				Potions ps = (Potions) item;
				Player pl = (Player) life;
				ps.taken(pl.getStrength());
				pl.setStrength(ps.getAmount());
				items.remove(index(item));
				return true;

			} else if (item instanceof Keys)
			{
				int x = life.getRow();
				int y = life.getCol();
				String direction = life.getDirection();
				Dungeon env = Dungeon.getDungeonInstance();
				StateFactory fa = new StateFactory();
				if (x > -1 && y > -1)
				{
					if (direction.compareToIgnoreCase("North") == 0)
					{
						if (env.getState(x - 1, y) instanceof DoorState)
						{
							if (env.addItem(x - 1, y, item, 0))
							{
								items.remove(index(item));
								env.setState(x - 1, y,
										fa.getState(StateFactory.NO_WALL));
								return true;
							}
						}
						return false;
					} 
					else if (direction.compareToIgnoreCase("South") == 0)
					{
						if (env.getState(x + 1, y) instanceof DoorState)
						{
							if (env.addItem(x + 1, y, item, 0))
							{
								items.remove(index(item));
								env.setState(x + 1, y,
										fa.getState(StateFactory.NO_WALL));
								return true;
							}
						}
						return false;
					} 
					else if (direction.compareToIgnoreCase("West") == 0)
					{
						if (env.getState(x, y - 1) instanceof DoorState)
						{
							if (env.addItem(x, y - 1, item, 0))
							{
								items.remove(index(item));
								env.setState(x, y - 1,
										fa.getState(StateFactory.NO_WALL));
								return true;
							}
						}
						return false;
					} 
					else if (direction.compareToIgnoreCase("East") == 0)
					{
						if (env.getState(x, y + 1) instanceof DoorState)
						{
							if (env.addItem(x, y + 1, item, 0))
							{
								items.remove(index(item));
								env.setState(x, y + 1,
										fa.getState(StateFactory.NO_WALL));
								return true;
							}
						}
						return false;
					} 
					else
					{
						return false;
					}
				} 
				else
				{
					return false;
				}
			} 
			else
			{
				return false;
			}
		}
	}

	/**
	 * Gets the items' iterator.
	 * 
	 * @return the items' iterator.
	 */
	@Override
	public Iterator getIterator()
	{
		return new InventoryIterator(items);
	}

	/**
	 * Gets the Max Size of the Inventory.
	 * 
	 * @return
	 */
	@Override
	public int getMaxSize()
	{
		return this.maxSize;
	}

	/**
	 * Gets how many items have been stored in the Inventory.
	 * 
	 * @return how many items have been stored in the Inventory
	 */
	@Override
	public int getActualSize()
	{
		return this.actualSize;
	}

	/**
	 * Sets the Max size of the Inventory.
	 * 
	 * @param size
	 *            the max size of the Inventory.
	 */
	@Override
	public void setMaxSize(int size)
	{
		if (size < actualSize)
			this.maxSize = actualSize;
		else
			this.maxSize = size;

	}

	/**
	 * Sets how many locations have been used.
	 * 
	 * @param size
	 *            how many locations have been used.
	 */
	@Override
	public void setActualSize(int size)
	{
		if (size > maxSize)
			this.actualSize = maxSize;
		else
			this.actualSize = size;

	}

	/**
	 * Gets the index of the items, if the item exist in the inventory.
	 * 
	 * @param item
	 *            the items
	 * @return the index of the items
	 */
	@Override
	public int index(Item item)
	{

		return items.indexOf(item);
	}

	/**
	 * Gets the item at the specific index of Inventory.
	 * 
	 * @param index
	 *            the specific index
	 * @return the item at the specific index. Otherwise, return null.
	 */
	@Override
	public Item getItem(int index)
	{
		try
		{
			return items.get(index);
		} catch (IndexOutOfBoundsException ex)
		{
			return null;
		}
	}

}
