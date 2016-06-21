package item;
/**
 * Factory pattern to build an object from armor type class
 * @author Malak
 *
 */
public class FactoryArmor 
{
	/**
	 * create an object from armor based on the parameter which send it 
	 * default is Normal armor when the type which send is invalid
	 * @return
	 */
	public static Armor buildArmor(String type)
	{   
		if(type.compareToIgnoreCase("normalarmor") == 0)
		{
			return new NormalArmor();
		}
		else if(type.compareToIgnoreCase("powerarmor") == 0)
		{
			return new PowerArmor();
		}
		else if(type.compareToIgnoreCase("sharparmor") == 0)
		{
			return new SharpArmor();
		}
		else return new NormalArmor();	
	}
		
}

