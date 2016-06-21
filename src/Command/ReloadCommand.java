package Command;

import lifeform.LifeForm;
/**
 * Reload Command call  reload Method in Life form when the player needs to reload 
 * the actual ammo 
 * 
 * @author Saad
 *
 */

public class ReloadCommand implements Command  {

	
    private LifeForm life;
	
	
	public ReloadCommand(LifeForm life)
	{
		this.life = life;
	}
	@Override
	public String execute() {
		
		// Call the method 
		life.Reload();
		 
		return "The Weapon has been reloaded!";
		
	}
	
	

}
