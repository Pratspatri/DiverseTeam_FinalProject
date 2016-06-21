package item;

/**
 * It is one of potions type
 * @author Malak
 *
 */
public class AlihotsyDraught extends Potions 
{
    /**
     * This type of potions (AlihotsyDraught) has healing behavior 
     */
	public AlihotsyDraught() 
	{
		super.affect=new NoHealing();
	}

}
