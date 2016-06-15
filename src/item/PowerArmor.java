package item;

/**
 * It is one of special armor type 
 * @author Malak 
 *
 */
public class PowerArmor extends SpecialArmor 
{   
	/**
	 * Constructor
	 */
	public PowerArmor()
	{
		description="powerArmor";
		armorPoints=40;
	}

	@Override
	public int useArmor(int hit_damage) 
	{
		 int diff=0;
			if(armorPoints<hit_damage)
			{
			    diff=hit_damage-armorPoints;
			    if(diff>=0)
			    	  damage=diff;
			    else damage=0;
			      
			}
			return damage;
		}

  }

