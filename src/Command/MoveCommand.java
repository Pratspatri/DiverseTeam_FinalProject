package Command;

/**
 * Move Command Class this execute Method Will call the move method 
 */
import dungeon.Dungeon;
import lifeform.LifeForm;


public class MoveCommand implements Command{

	
	private LifeForm life;
	
	
	public MoveCommand(LifeForm life)
	{
		this.life = life;
	}
	@Override
	public String execute() {
		Dungeon env = Dungeon.getDungeonInstance();
		return (env.move(life.getRow(), life.getCol()))?"Move!":"Can't move!";
		
	}

}
