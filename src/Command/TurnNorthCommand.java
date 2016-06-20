package Command;

import lifeform.LifeForm;

public class TurnNorthCommand implements Command {

	
private LifeForm life;
	
	public TurnNorthCommand(LifeForm life)
	{
		this.life = life;
	}
	@Override
	public String execute() {
		life.SetDirection("North");
		return "Turn North!";
		
	}

}
