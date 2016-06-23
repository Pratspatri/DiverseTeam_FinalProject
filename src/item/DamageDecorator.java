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
     * Get describe type for decorator a lot or little damage for the weapon
     * @return
     */
	public abstract String getDescription();

}
