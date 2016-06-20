package Command;

import lifeform.LifeForm;

public class TurnSouthCommand implements Command {

	
private LifeForm life;
	
	public TurnSouthCommand(LifeForm life)
	{
		this.life = life;
	}
	@Override
	public String execute() {
		life.SetDirection("South");
		return "Turn South!";
		
	}

}
