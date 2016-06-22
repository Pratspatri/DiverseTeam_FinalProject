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

public class PlayerInventory implements Inventory
{
	private ArrayList<Item> items;
	private int maxSize;
	private int actualSize;
	
	public PlayerInventory()
	{
		this(10);
	}
	
	public PlayerInventory(int size)
	{
		items = new ArrayList<Item>();
		maxSize = size;
		actualSize = 0;
	}
	
	
	@Override
	public boolean addItem(Item item)
	{
		if(item == null)
			return false;
		else if(actualSize < maxSize)
		{
			items.add(item);
			actualSize += 1;
			return true;
		}
		else
		{
			return false;
		}
	}

	
	@Override
	public Item removeItem(int index)
	{
		try
		{
			Item it = items.remove(index);
			this.actualSize -= 1;
			return it;
		}
		catch(IndexOutOfBoundsException ex)
		{
			return null;
		}
		
	}

	@Override
	public boolean use(LifeForm life,int index)
	{
		if(index>=items.size())
			return false;
		else 
		{
			Item item = items.get(index);
			if(item instanceof Weapon)
			{
				Weapon temp = life.getWeapon();
				life.dropWeapon();
				life.pickUpWeapon((Weapon)item);
				items.remove(index(item));
				items.add(temp);
				return true;
			}
			else if(item instanceof Armor)
			{
				Player pl = (Player)life;
				Armor temp = pl.getArmor();
				pl.setArmor((Armor)item);
				items.remove(index(item));
				items.add(temp);
				return true;
			}
			else if(item instanceof Potions)
			{
				Potions ps = (Potions)item;
				Player pl = (Player)life;
				ps.taken(pl.getStrength());
				pl.setStrength(ps.getAmount());
				items.remove(index(item));
				return true;
				
			}
			else if(item instanceof Keys)
			{
				int x = life.getRow();
				int y = life.getCol();
				String direction = life.getDirection();
				Dungeon env = Dungeon.getDungeonInstance();
				StateFactory fa =new StateFactory();
				if(x>-1&&y>-1)
				{
					if(direction.compareToIgnoreCase("North") == 0)
					{
						if(env.getState(x-1, y) instanceof DoorState)
						{
							if(env.addItem(x-1, y, item, 0))
							{
								items.remove(index(item));
								env.setState(x-1, y, fa.getState(StateFactory.NO_WALL));
								return true;
							}
						}
						return false;
					}
					else if(direction.compareToIgnoreCase("South") == 0)
					{
						if(env.getState(x+1, y) instanceof DoorState)
						{
							if(env.addItem(x+1, y, item, 0))
							{
								items.remove(index(item));
								env.setState(x+1, y, fa.getState(StateFactory.NO_WALL));
								return true;
							}
						}
						return false;
					}
					else if(direction.compareToIgnoreCase("West") == 0)
					{
						if(env.getState(x, y-1) instanceof DoorState)
						{
							if(env.addItem(x, y-1, item, 0))
							{
								items.remove(index(item));
								env.setState(x, y-1, fa.getState(StateFactory.NO_WALL));
								return true;
							}
						}
						return false;
					}
					else if(direction.compareToIgnoreCase("East") == 0)
					{
						if(env.getState(x, y+1) instanceof DoorState)
						{
							if(env.addItem(x, y+1, item, 0))
							{
								items.remove(index(item));
								env.setState(x, y+1, fa.getState(StateFactory.NO_WALL));
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




	@Override
	public Iterator getIterator()
	{
		return new InventoryIterator(items);
	}

	@Override
	public int getMaxSize()
	{
		return this.maxSize;
	}

	@Override
	public int getActualSize()
	{
		return this.actualSize;
	}

	@Override
	public void setMaxSize(int size)
	{
		if(size<actualSize)
			this.maxSize = actualSize;
		else
			this.maxSize = size;
		
	}

	@Override
	public void setActualSize(int size)
	{
		if(size>maxSize)
			this.actualSize = maxSize;
		else
			this.actualSize = size;
		
	}

	@Override
	public int index(Item item) 
	{

		return items.indexOf(item);
	}

	@Override
	public Item getItem(int index) 
	{
		try
		{
			return items.get(index);
		}
		catch(IndexOutOfBoundsException ex)
		{
			return null;
		}
	}


}
