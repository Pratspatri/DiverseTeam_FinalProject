package item;

/**
 * It is one of special armor type 
 * @author Malak
 *
 */
public class SharpArmor extends SpecialArmor 
{
	/**
	 * Constructor
	 */
	
	public SharpArmor()
	{
		description="sharpArmor";
		 armorPoints=20;
	}
	  /**
	 	 * Use Armor to check if take hit is greater or less than armor points
	 	 * Armor points absorb damage if take hit is less than armor points
	 	 * decrease hit point by 3;
	 	 */
	@Override
	public int useArmor(int hit_damage) 
	{   
		int diff=0;
	    hit_damage-=3;
		if(armorPoints<hit_damage)
		{
		    diff=hit_damage-armorPoints;
		    if(diff>=0)
		    	  {
		    	    damage=diff;
		    	    setDamageArmor( damage);
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
