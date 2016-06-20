package lifeform;

public class MockLifeForm extends LifeForm
{
	// MockLifeForm extends lifeForm, therefore the same constructor
	public MockLifeForm(String name, int life, int strength) 
	{
		super(name, life, strength);
	}

	/**
	 * Take Hit method
	 */
	@Override
	public void takeHit(LifeForm lifeform, int damage) 
	{

	}

}
