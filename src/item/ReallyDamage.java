package item;

/**
 * This class to decorate the weapon to do mor damage 
 * @author Malak
 *
 */
public class ReallyDamage extends DamageDecorator
{
    /**
     * Constructor
     */
    public ReallyDamage(Weapon weapon)
    {
    	super.weapon=weapon;
    }
    
	/**
	 * Make the damage four time
	 */
	@Override
	public int calculateDamage(int distance)
	{   
		if(weapon.getDamage() == 0)
	   {
		 damage=weapon.calculateDamage(distance)+4;
		 weapon.setDamage( damage);
	   }
	  else 
	  {
		    damage=weapon.getDamage()+4;
		    weapon.setDamage(damage);
	  }
		
		return (int) damage;
	}
	/**
     * get description 
     */
	@Override
	public String getDescription()
	{
		description="really damage";
		return description;
	}

}
