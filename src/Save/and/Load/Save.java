package Save.and.Load;

/**
 * Class represent template method.  will save the info of the player 
 * @author Saad
 *
 */

public abstract class Save  {
	
	
	/**
	 * Template method that will perform all methods of saveing data
	 */
	public void DoSave()
	{
		
		SavePlayerName();
		SavePlayerData();
		
	}
	
	
	
	
	public abstract void SavePlayerName();
	public abstract void SavePlayerData();

}
