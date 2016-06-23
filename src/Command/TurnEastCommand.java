package Command;

import lifeform.LifeForm;

/**
 * The class represents a Command .It used to allow the life forms to turn east 
 * @author Saad
 *
 */
public class TurnEastCommand implements Command{

	
	
	private LifeForm life;
	
	/**
	 * Construct an AttackCommand with a life that is used to turneast
	 * 
	 * @param life the LifeForm will be manipulated.
	 */
	public TurnEastCommand(LifeForm life)
	{
		this.life = life;
	}
	/**
	 * turn east 
	 */
	@Override
	public String execute() {
		life.SetDirection("East");  
		return "Turn East!";
	}

}
