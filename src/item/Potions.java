package item;

/**
 * it is one of item that could increase or decrease the player's ability
 * @author Malak
 *
 */
public abstract class Potions extends GenericItem 
{
    /**
     * define amount of potions
     */
	public int amount;
	
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
	public abstract void taken();
}
