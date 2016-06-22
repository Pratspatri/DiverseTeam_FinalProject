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
	 * @author - Prathyusha Akshintala
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
	 * @author - Prathyusha Akshintala
	 * Resets instance
	 */
	public static void resetInstance() 
	{
		thePlayer = null;
	}
	/**
	 * @author - Prathyusha Akshintala
	 * sets the health parameter
	 * @param myhealth
	 */
	public void setHealth(String myhealth)
	{
		this.health = myhealth;
	}
	/**
	 * @author - Prathyusha Akshintala
	 * get the health status
	 * @return
	 */
	public String getHealth()
	{
		return health;
	}
	/**
	 * @author - Prathyusha Akshintala
	 * Gets exp points
	 * @return
	 */
	public int getExpPoints()
	{
		return expPoints;
	}
	/**
	 * @author - Prathyusha Akshintala
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
	 * @author - Prathyusha Akshintala
	 * Gets the armor
	 * @return
	 */
	public Armor getArmor() 
	{
		return armor;
	}
	/**
	 * @author - Prathyusha Akshintala
	 * Sets the armor from different types
	 * @param armor
	 */
	public void setArmor(Armor armor) 
	{
		this.armor = armor;
	}
	/**
	 * @author - Prathyusha Akshintala
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
	 * @author - Prathyusha Akshintala
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
	 * @author - Prathyusha Akshintala
	 * Gets the item 
	 * @return item
	 */
	public Item getItem()
	{
		return item; 
	}
	/**
	 * @author - Prathyusha Akshintala
	 * Use the item
	 * @param index
	 * @return
	 */
	public boolean useItem(int index)
	{
		return bag.use(this,index);
	}
	
	/**
	 * Gets item from inventory. need to be test
	 */
	public Item getItemFromInventory(int index)
	{
		return bag.getItem(index);
	}
	
	public int getIndexOfItemFromInventory(Item item)
	{
		return bag.index(item);
	}
	/**
	 * @author - Prathyusha Akshintala
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
					return;
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
	
	/**
	 * Gets the description about the Weapon which player hold.
	 * @return the description of Weapon.
	 */
	public String getWeaponDescription()
	{
		return (getWeapon()==null)?"": this.getWeapon().getDescribtion();
	}
	
	/**
	 * Gets the description about the Armor which player hold.
	 * @return the description of the Armor.
	 */
	public String getArmorDescription()
	{
		return (armor==null)?"":this.armor.getDescription();
	}
}