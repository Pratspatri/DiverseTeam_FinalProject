package item;

/**
 * It is one of potions type
 * @author Malak
 *
 */
public class Mega extends Potions 
{
	/**
     * This type of potions (Mega) has healing behavior 
     */
	public Mega() 
	{
		affect=new Healing();
	}

}
