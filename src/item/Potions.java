package item;

/**
 * it is one of item that could increase or decrease the player's ability
 * @author Malak
 *
 */
public abstract class Potions extends GenericItem 
{
    /**
     * define amount of potions which how much the player takes
     */
	 public int amount;
	 
	 /**
	  * Define an object using AffectBehavior
	  */
	  protected AffectBehavior affect;
	
	/**
	 * set the amount of potions
	 * @param amount
	 */
	public void setAmount(int amount)
	{
	    this.amount=amount;	
	}
	
	/**
	 * get amount of potions
	 * @return
	 */
	public int getAmount()
	{
		return amount;
	}
	
	/**
	 * Taken potions will be based on the behavior either healing or not healing 
	 * @param amounts
	 */
	public void taken(int amounts) 
	{   
		amount=affect.taken(amounts);
		setAmount(amount);
	}
}
