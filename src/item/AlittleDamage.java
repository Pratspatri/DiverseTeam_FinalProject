package item;

/**
 * Describe the behavior for Sword and Spear weapon 
 * @author Malak
 *
 */
public class AlittleDamage extends DamageDecorator 
{
    /**
     * Constructor
     */
    public AlittleDamage(Weapon weapon)
    {
    	super.weapon=weapon;
    }
	/**
	 * calculate damage to make it double
	 */
	@Override
	public int calculateDamage(int distance)
	{   
		if(weapon.getDamage() == 0)
	   {
		 damage=weapon.calculateDamage(distance)+2;
		 weapon.setDamage( damage);
	   }
	  else 
	  {
		    damage=weapon.getDamage()+2;
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
		description="Alittle damage";
		return description;
	}
}
