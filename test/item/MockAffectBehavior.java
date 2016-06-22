package item;

public class MockAffectBehavior implements AffectBehavior 
{
    /**
     * Set Amount
     */
	public int amount;
	/**
	 * Constructor
	 */
	public MockAffectBehavior() 
	{
		// TODO Auto-generated constructor stub
	}
    /**
     *  Implement Calculate the amount
     */
	@Override
	public int taken(int amounts) 
	{
		amount=amounts +3;
		return amount ;
	}
    
	/**
	 * Implement the set amount
	 */
	@Override
	public void setAmount(int amounts) 
	{
		amount=amounts;
	}
    
	/**
	 * Implement the get amount
	 */
	@Override
	public int getAmount() 
	{
		return amount;
	}

	/**
	 * Implement display state 
	 */
	@Override
	public String display() 
	{
		return "It is healling";
	}

}
