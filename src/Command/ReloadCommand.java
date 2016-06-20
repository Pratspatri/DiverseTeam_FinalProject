package Command;

import lifeform.LifeForm;

public class ReloadCommand implements Command  {

	
    private LifeForm life;
	
	
	public ReloadCommand(LifeForm life)
	{
		this.life = life;
	}
	@Override
	public String execute() {
		 
		return "The Weapon has been reloaded!";
		
	}
	
	

}
