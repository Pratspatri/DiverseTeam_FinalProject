package item;

/**
 * It is one of potions type
 * @author Malak
 *
 */
public class AntiParalysis extends Potions 
{
	/**
     * This type of potions (AntiParalysis) has healing behavior 
     */
	public AntiParalysis() 
	{
		affect=new Healing();
	}

}
