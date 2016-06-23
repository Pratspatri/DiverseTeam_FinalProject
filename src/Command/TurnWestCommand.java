package Command;

import lifeform.LifeForm;

/**
 * The class represents a Command .It used to allow the life forms to turn west 
 * @author Saad
 *
 */
public class TurnWestCommand implements Command {

	
    private LifeForm life;
	
    /**
     * Construct an AttackCommand with a life that is used to turn west
     * 
     * @param life the LifeForm will be manipulated.
     */
	public TurnWestCommand(LifeForm life)
	{
		this.life = life;
	}
	
	/**
	 * Turn west execute method
	 */
	@Override
	public String execute() {
		life.SetDirection("West");
		return "Turn West!";
		
	}

}
