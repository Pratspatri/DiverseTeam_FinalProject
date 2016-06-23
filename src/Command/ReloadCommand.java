package Command;

import lifeform.LifeForm;

/**
 * The class represents a Command .It used to let the life forms to reload after 
 * Firing 
 * @author Saad
 *
 */

public class ReloadCommand implements Command  {

	
    private LifeForm life;
	
    /**
	 * Construct an AttackCommand with a life that is used to reload its weapon
	 * 
	 * @param life the LifeForm will be manipulated.
	 */
	public ReloadCommand(LifeForm life)
	{
		this.life = life;
	}
	
	/**
	 * call the Reload the weapon after firing 
	 */
	@Override
	public String execute() {
		
		// Call the method 
		life.Reload();
		 
		return "The Weapon has been reloaded!";
		
	}
	
	

}
