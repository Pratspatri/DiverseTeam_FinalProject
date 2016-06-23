package item;

/**
 * The class represent the factory pattern . in this class the potions will be created  
 * @author Saad
 *
 */
public class PotionFactory { 
	
	
	/**
	 * create  objects based on the parameter type 
	 * @param type type of the potions object 
	 * @return
	 */
	public static Potions PotionsFactory(String type)
	{
		//for AntiParalysis class 
		if(type.compareToIgnoreCase("AntiParalysis") == 0)
		{
			return new AntiParalysis(); 
		}
		
		//for AntiPoison class 
		else if (type.compareToIgnoreCase("AntiPoison") == 0)
		{
			return new AntiPoison();
		}
		//for AlihotsyDraught class
		else if (type.compareToIgnoreCase("AlihotsyDraught") == 0) 
		{
			return new AlihotsyDraught();
		}
		
		return null ; 
	}

}
