package inventory;

import item.Armor;
import item.Item;
import item.Keys;
import item.Potions;
import item.Weapon;

import java.util.ArrayList;

import lifeform.LifeForm;
import lifeform.Player;

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
				return false;
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
