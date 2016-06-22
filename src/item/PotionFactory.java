package item;

public class PotionFactory { 
	
	public Potions PotionFactory(String type)
	{
		if (type == null)
		{
			return null ; 
		}
		
		if(type=="AntiParalysis")
		{
			return new AntiParalysis();
		}
		else if (type=="AntiPoison")
		{
			return new AntiPoison();
		}
		
		else if (type=="AlihotsyDraught")
		{
			return new AlihotsyDraught();
		}
		
		return null ; 
	}

}
