package lifeform;
/**
 * Player class which extends LifeForm
 * @author - Prathyusha Akshintala
 */
import inventory.Inventory;
import inventory.PlayerInventoryFactory;
import item.Item;

public class Player extends LifeForm 
{

	private int expPoints;												// How many points the player has
	
	private String armor;												// What type of armor
	
	private Inventory bag;												// Inventory to hold everything
	
	private static LifeForm thePlayer;									

	private Player(String name, int life, int strength) 				// Singleton pattern - private constructor
	{
		super(name, life, strength);
		PlayerInventoryFactory factory = new PlayerInventoryFactory();
		bag = factory.getPlayerInventory();
	}
	/**
	 * Gets the instance of the player
	 * @return thePlayer
	 */
	public static LifeForm getPlayerInstance() 							
	{
		if (thePlayer == null) 
		{
			thePlayer = new Player("Mario", 100, 10);
		}
		return thePlayer;
	}
	/**
	 * Resets instance
	 */
	public static void resetInstance() 
	{
		thePlayer = null;
	}
	/**
	 * Gets exp points
	 * @return
	 */
	public int getExpPoints()
	{
		return expPoints;
	}
	/**
	 * Sets exp points
	 * @param exp
	 */
	public void setExpPoints(int exp) 
	{
		expPoints = exp;
	}
	/**
	 * Gets the armor
	 * @return
	 */
	public String getArmor() 
	{
		return armor;
	}
	/**
	 * Sets the armor from different types
	 * @param armor
	 */
	//TODO check how to set armor according to the type
	public void setArmor(String armor) 
	{
		this.armor = armor;
	}
	/**
	 * Add to the inventory whatever item the player comes across
	 * @param item
	 */
	// TODO Do we need to send it as an array list or just item
	public void addToInventory(Item item)
	{
		bag.addItem(item);
	}
	/**
	 * Remove the item from inventory
	 * @param item
	 * @return
	 */
	// TODO do we need to send a position? and position is needed here? because there are 2 remove items
	public Item removeFromInventory(Item item)
	{
		Item temp = bag.removeItem(bag.index(item));
		return temp;
	}
	/**
	 * Use the item
	 * @param index
	 * @return
	 */
	public boolean useItem(int index)
	{
		return bag.use(index);
	}
}
