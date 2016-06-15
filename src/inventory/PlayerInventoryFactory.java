package inventory;

public class PlayerInventoryFactory
{
	public Inventory getPlayerInventory(int size)
	{
		return new PlayerInventory(size);
	}
	public Inventory getPlayerInventory()
	{
		return new PlayerInventory();
	}
}
