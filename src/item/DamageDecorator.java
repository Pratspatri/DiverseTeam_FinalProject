package item;

/**
 * Abstract to decorate all weapon types
 * 
 * @author Malak
 *
 */
public abstract class DamageDecorator extends Weapon 
{
	/**
	 * Define which will be decorated
	 */
	protected Weapon weapon;
	
	/**
	 * Describe the type of decorator
	 */
	String description;

	/**
	 * Calculate damage for each weapon
	 */
	public abstract int calculateDamage(int distance);

	public abstract String getDescription();

}
