package Command;

import lifeform.LifeForm;
import lifeform.Player;

public class AcquireCommand implements Command{

	
	private LifeForm life;
	
	/**
	 * Construct an AcquireCommand method with a LifeForm that will be manipulated.
	 * 
	 * @param life the LifeForm will be manipulated.
	 */
	public AcquireCommand(LifeForm life)
	{
		this.life = life;
	}
	@Override
	public String execute() {
		if(this.life instanceof Player)
		{
		   
		}
			
		return null;
	}

}
