package lifeform;
/**
 * Player class which extends LifeForm
 * @author - Prathyusha Akshintala
 */
import ability.Poison;
import ability.Poke;
import inventory.Inventory;
import inventory.PlayerInventoryFactory;
import item.Armor;
import item.ImmunePoison;
import item.Item;
import item.NormalArmor;
import item.PowerArmor;
import item.SharpArmor;

public class Player extends LifeForm 
{

	private int expPoints;												// How many points the player has
	
	private Armor armor;												// What type of armor
	
	private Inventory bag;												// Inventory to hold everything
	
	private static LifeForm thePlayer;		
	
	private String health;

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
	
	public void setHealth(String myhealth)
	{
		this.health = myhealth;
	}
	
	public String getHealth()
	{
		return health;
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
	public Armor getArmor() 
	{
		return armor;
	}
	/**
	 * Sets the armor from different types
	 * @param armor
	 */
	public void setArmor(Armor armor) 
	{
		this.armor = armor;
	}
	/**
	 * Add to the inventory whatever item the player comes across
	 * @param item
	 */
	public void addToInventory(Item item)
	{
		bag.addItem(item);
	}
	/**
	 * Remove the item from inventory
	 * @param item
	 * @return
	 */
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
	
	@Override
	public void takeHit(LifeForm lifeform, int damage) 
	{
		Creature creature = (Creature) lifeform;
		if(damage > 0)
		{
			if(getArmor() == null)
			{
				lifePoints -= damage;
			}
			else 
			{
				if(getArmor() instanceof ImmunePoison && creature instanceof Poison)
				{
					return;
				}
				else 
				{
					damage = getArmor().useArmor(damage);
					lifePoints -= damage;
				}				
			}
		}
	}
}