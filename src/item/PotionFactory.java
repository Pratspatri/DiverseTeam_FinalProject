package item;

public class PotionFactory { 
	
	public Potions PotionFactory(String type)
	{
		if (type == null)
		{
			return null ; 
		}
		
		if(type=="Pokimon")
		{
			return new Pokemon();
		}
		else if (type=="Mega")
		{
			return new Mega();
		}
		
		else if (type=="Ultra")
		{
			return new Ultra();
		}
		
		return null ; 
	}

}
