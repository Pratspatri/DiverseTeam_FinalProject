package Command;


import dungeon.Dungeon;
import lifeform.LifeForm;

/**
 * The class represents a Command .It used to allow the life forms to move around the 
 * Dungeon 
 * 
 * @author Saad
 *
 */
public class MoveCommand implements Command{

	
	private LifeForm life;
	
	/**
	 * Construct an AttackCommand with a life that is used to move
	 * 
	 * @param life the LifeForm will be manipulated.
	 */
	public MoveCommand(LifeForm life)
	{
		this.life = life;
	}
	/**
	 * allow the life forms to move around the dungeon
	 */
	@Override
	public String execute() {
		Dungeon env = Dungeon.getDungeonInstance();
		return (env.move(life.getRow(), life.getCol()))?"Move!":"Can't move!"; 
		
	}

}
