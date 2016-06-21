package item;

/**
 * It is one of potions type
 * @author Malak
 *
 */
public class Ultra extends Potions 
{
    /**
     * This type of potions (Ultra) has healing behavior 
     */
	public Ultra() 
	{
		affect=new NoHealing();
	}

}
