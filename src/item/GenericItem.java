package item;

/**
 * It is between Item interface and all item classes, 
 * so we can push all duplicated code
 * @author Malak
 *
 */
public abstract class GenericItem implements Item
{
	String name;
	/**
	 * Set what is the name for item
	 */
	@Override
	public void setItem(String name)
	{
		this.name=name;
		
	}
	/**
	 * Get name for item
	 */
	@Override
	public String getItem() 
	{
		
		return name;
	}

}
