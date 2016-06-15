package item;

/**
 * Interface to define beahivor damage for weapon either really or little 
 * @author Malak
 *
 */
public abstract class DamageDecorator 
{
	  protected Weapon weapon;
	/**
	 * Calculate damage for each weapon 
	 */
public abstract int calculateDamage(int distance);

}
