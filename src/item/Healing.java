package item;

/**
 * This class is for taken a good potions
 * @author Malak
 *
 */
public class Healing extends Potions 
{
	/**
	 * Constructor
	 * @param quantity
	 */
	public Healing(int quantity) 
	{ 
		amount=quantity;
	}

	/**
	 * override the taken to increase the ability of player
	 */
	@Override
	public void taken() 
	{
		// TODO Auto-generated method stub

	}

}
