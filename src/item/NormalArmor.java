package item;

/**
 * It is one of armor type which does not have any ability
 * @author Malak
 *
 */
public class NormalArmor extends Armor 
{
	/**
	 * Constructor
	 */
     public NormalArmor()
     {
    	 description="normalArmor";
    	 armorPoints=15;
     }
     /**
 	 * Use Armor to check if take hit is greater or less than armor points
 	 * Armor points absorb damage if take hit is less than armor points
 	 */
	@Override
	public int useArmor(int hit_damage) 
	{   int diff=0;
		if(armorPoints<hit_damage)
		{
		    diff=hit_damage-armorPoints;
		    if(diff>=0)
		    	  {
		    	    damage=diff;
		    	    setDamageArmor(damage);
		    	  }
		    else 
		    	{
		    	  damage=0;
		    	  setDamageArmor(damage);
		    	}     
		}
		return damage;
	}
}
