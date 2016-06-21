package item;

/**
 * It is one of potions type
 * @author Malak
 *
 */
public class AntiPoison extends Potions 
{
    /**
     * This type of potions (AntiPoison) has healing behavior 
     */
	public AntiPoison() 
	{
		affect=new Healing();
	}

}
