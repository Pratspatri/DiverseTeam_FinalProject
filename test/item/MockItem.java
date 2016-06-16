package item;

/**
 *  Purpose from this class to test all concert methods in Item class
 * @author Malak
 *
 */
public class MockItem implements Item 
{    
	/**
	 * Define description to the item
	 */
	String description ;
    /**
     * Constructor
     */
	public MockItem(String name) 
	{
		description = name;
	}
     
	/**
	 * Implements the set name to item
	 */
	@Override
	public void setItem(String name)
	{
		 description = name;
		
	}

	/**
	 * Implements the get name to item
	 */
	@Override
	public String getItem() 
	{
		return description ;
	}

}
