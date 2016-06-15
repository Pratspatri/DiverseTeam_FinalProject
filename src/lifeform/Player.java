package lifeform;

import inventory.Inventory;
import inventory.PlayerInventoryFactory;
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
		PlayerInventoryFactory factory = new PlayerInventoryFactory();
		bag = factory.getPlayerInventory();
	}
	
	public static LifeForm getPlayerInstance() 
	{
		if (thePlayer == null) 
		{
			thePlayer = new Player("Mario", 100, 10);
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
		bag.addItem(item);
	}
	// TODO do we need to send a position? and position is needed here? because there are 2 remove items
	public Item removeFromInventory(Item item)
	{
		Item temp = bag.removeItem(item);
		return temp;
	}
	
	public boolean useItem(int index)
	{
		return bag.use(index);
	}
}
