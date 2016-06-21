package item;
/**
 * Each type of potions has different behavior Healing or NoHealing
 * @author Malak
 *
 */
public interface AffectBehavior 
{
    /**
     * Take an amount of potions and do some calculate and return a new amount
     * @param amounts
     * @return
     */
	public int taken(int amounts);
	
	/**
	 * Set the amount 
	 */
	public void setAmount(int amounts);
	
	/**
	 * getAmount
	 */
	public int getAmount();
	/**
	 * display the affect behavior
	 */
	public abstract String display();

}
