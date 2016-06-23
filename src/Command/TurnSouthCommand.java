package Command;

import lifeform.LifeForm;

/**
 * The class represents a Command .It used to allow the life forms to turn south 
 * @author Saad
 *
 */
public class TurnSouthCommand implements Command {

	
private LifeForm life;
	

/**
 * Construct an AttackCommand with a life that is used to turn south
 * 
 * @param life the LifeForm will be manipulated.
 */
	public TurnSouthCommand(LifeForm life)
	{
		this.life = life;
	}

	/**
	 * Turn south execute method
	 */
	@Override
	public String execute() {
		life.SetDirection("South");
		return "Turn South!";
		
	}

}
