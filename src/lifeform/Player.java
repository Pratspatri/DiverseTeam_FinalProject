package lifeform;

import inventory.Inventory;
import item.Item;

public class Player extends LifeForm 
{

	private int expPoints;
	private String armor;
	private Inventory bag;
	
	private static LifeForm thePlayer;

	private Player(String name, int life, int strength) 
	{
		super(name, life, strength);
	}
	
	public static LifeForm getPlayerInstance() 
	{
		if (thePlayer == null) 
		{
			thePlayer = new LifeForm("Mario", 100, 10);
		}
		return thePlayer;
	}

	public static void resetInstance() 
	{
		thePlayer = null;
	}

	public int getExpPoints()
	{
		return expPoints;
	}

	public void setExpPoints(int exp) 
	{
		expPoints = exp;
	}

	public String getArmor() 
	{
		return armor;
	}

	//TODO check how to set armor according to the type
	public void setArmor(String armor) 
	{
		this.armor = armor;
	}
	// TODO Do we need to send it as an array list or just item
	public void addToInventory(Item item)
	{
		this.bag = bag.addItem(item);
	}
	// TODO do we need to send a position?
	public Item removeFromInventory(Item item)
	{
		Item temp;
		temp = item;
		this.bag = bag.removeItem(item);
		return temp;
	}
	
	public boolean useItem(Item item)
	{
		if(item != null)
		{
			bag.use(item);
			return true;
		}
		return false;
	}
}
