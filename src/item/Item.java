package item;

/**
 * All item in the game such as weapon,Armor,keys, and potions will implement
 * @author Malak
 *
 */
public interface Item 
{
    /**
     * set the type for each item
     * @param name
     */
	public void setItem(String name);
	/**
	 * get type for each item
	 * @return
	 */
	public String getItem();
}
