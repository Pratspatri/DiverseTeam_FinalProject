package inventory;

/**
 * It is used to create a PlayerInventory with fix size.
 * 
 * @author Jixiang Lu
 *
 */
public class InventoryFactory
{
	/**
	 * Create a Inventory with specific size
	 * @param size the specific size
	 * @return the Inventory Created.
	 */
	public Inventory getPlayerInventory(int size)
	{
		return new PlayerInventory(size);
	}
	
	/**
	 * Create a Inventory with 10 locations.
	 * @return The Inventory Created.
	 */
	public Inventory getPlayerInventory()
	{
		return new PlayerInventory();
	}
}
