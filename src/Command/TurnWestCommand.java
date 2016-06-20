package Command;

import lifeform.LifeForm;

public class TurnWestCommand implements Command {

	
    private LifeForm life;
	
	public TurnWestCommand(LifeForm life)
	{
		this.life = life;
	}
	@Override
	public String execute() {
		life.SetDirection("West");
		return "Turn West!";
		
	}

}
