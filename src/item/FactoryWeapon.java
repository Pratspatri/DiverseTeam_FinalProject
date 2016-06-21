package item;

/**
 * Factory pattern to build an object from weapon type class
 * @author Malak
 *
 */
public class FactoryWeapon 
{   
	/**
	 * create an object from weapon based on the parameter which send it 
	 * default is Gun weapon when the type which send is invalid
	 * @return
	 */
	public static Weapon buildWeapon(String type)
	{   
		if(type.compareToIgnoreCase("gun") == 0)
		{
			return new Gun();
		}
		else if(type.compareToIgnoreCase("spear") == 0)
		{
			return new Spear();
		}
		else if(type.compareToIgnoreCase("sword") == 0)
		{
			return new Sword();
		}
		else return new Gun();	
	}
}
