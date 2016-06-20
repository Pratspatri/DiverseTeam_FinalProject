package Command;

import lifeform.LifeForm;

public class DropCommand implements Command  {
	
	private LifeForm life;
	
	/**
	 * Construct an AcquireCommand method with a LifeForm that will be manipulated.
	 * 
	 * @param life the LifeForm will be manipulated.
	 */
	public DropCommand(LifeForm life)
	{
		this.life = life;
	}

	@Override
	public String execute() {
		// TODO Auto-generated method stub
		return null;
	}

}
