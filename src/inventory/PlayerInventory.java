package inventory;

import item.Item;
import item.Weapon;

import java.util.ArrayList;

import lifeform.LifeForm;

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
				life.
			}
		}
	}

	@Override
	public boolean drop(int index)
	{
		// TODO Auto-generated method stub
		return false;
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


}
