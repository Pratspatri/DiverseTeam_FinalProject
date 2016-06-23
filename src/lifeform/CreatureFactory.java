package lifeform;
/**
 * The class represent the factory pattern . in this class the potions will be created  
 * @author Saad
 *
 */
public class CreatureFactory {
	/**
	 * create an object of creatures based on the parameter type  (Goblin , Mummy)
	 * @param type
	 * @param name of the creature
	 * @param point the life points of the creature
	 * @param power the strength of the creature
	 * @return
	 */
	
	public static Creature CreaturesFactory(String type , String name , int point ,int power )
	{
		if (type.compareToIgnoreCase("Goblin") == 0)
		{
			return new Goblin(name, point, power);
		}
		else  if (type.compareToIgnoreCase("Mummy") == 0)
		{
			return new Mummy(name, point, power); 
		}
		
		return null ;
	}

}
