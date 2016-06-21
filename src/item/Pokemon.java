package item;

/**
 * It is one of potions type
 * @author Malak
 *
 */
public class Pokemon extends Potions 
{
    /**
     * This type of potions (Pokemon) has healing behavior 
     */
	public Pokemon() 
	{
		affect=new Healing();
	}

}
