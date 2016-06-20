package Command;

import lifeform.LifeForm;

public class TurnEastCommand implements Command{

	
	
	private LifeForm life;
	
	public TurnEastCommand(LifeForm life)
	{
		this.life = life;
	}
	@Override
	public String execute() {
		life.SetDirection("East"); 
		return "Turn East!";
	}

}
