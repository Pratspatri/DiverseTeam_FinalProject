package lifeform;
/**
 * Player class which extends LifeForm
 * @author - Prathyusha Akshintala
 */
import ability.Poison;
import inventory.Inventory;
import inventory.PlayerInventoryFactory;
import item.Armor;
import item.ImmunePoison;
import item.Item;

public class Player extends LifeForm 
{

	private int expPoints;												// How many points the player has
	
	private Armor armor;												// What type of armor
	
	private Item item;
	
	private Inventory bag;												// Inventory to hold everything
	
	private static LifeForm thePlayer;		
	
	private String health;

	// Singleton pattern - private constructor
	private Player(String name, int life, int strength) 				
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
	 * sets the health parameter
	 * @param myhealth
	 */
	public void setHealth(String myhealth)
	{
		this.health = myhealth;
	}
	/**
	 * get the health status
	 * @return
	 */
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
		if(exp >= 0)
		{
			expPoints = exp;
		}
		else
		{
			expPoints = 0;
		}
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
	public boolean addToInventory(Item item)
	{
		if(item!= null)
		{
			bag.addItem(item);
			return true;
		}
		else
		{
			return false;
		}
		
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
	
	public Item getItem()
	{
		return item; 
	}
	/**
	 * Use the item
	 * @param index
	 * @return
	 */
	public boolean useItem(int index)
	{
		return bag.use(this,index);
	}
	/**
	 * Take hit method to calculate how much damage it takes
	 */
	@Override
	public void takeHit(LifeForm lifeform, int damage) 
	{
		Creature creature = (Creature) lifeform;
		if(damage > 0)
		{
			if(getArmor() == null)
			{
				lifePoints -= damage;
				//System.out.println("This is some test life:inside null armour "+ lifePoints);
			}
			else 
			{
				if(getArmor() instanceof ImmunePoison && creature instanceof Poison)
				{
					lifePoints -= damage;
				}
				else 
				{
					damage = getArmor().useArmor(damage);
					//System.out.println("Before calculating the lifepoints in else:"+lifePoints);
					lifePoints -= damage;
					//System.out.println("After calculating the lifepoints in else:"+lifePoints);
				}				
			}
		}
	}
}