package Command;

import lifeform.LifeForm;

/**
 * The class represents a Command .It used to allow the life forms to turn north 
 * @author Saad
 *
 */
public class TurnNorthCommand implements Command {

	
private LifeForm life;
	
/**
 * Construct an AttackCommand with a life that is used to turn north
 * 
 * @param life the LifeForm will be manipulated.
 */
	public TurnNorthCommand(LifeForm life)
	{
		this.life = life;
	}
	/**
	 * turn north execute method
	 */
	@Override
	public String execute() {
		life.SetDirection("North"); 
		return "Turn North!"; 
		
	}

}
