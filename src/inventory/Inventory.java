package inventory;

import item.Item;
import lifeform.LifeForm;

/**
 * It represent an Inventory which has a fixed size.
 * 
 * @author Jixiang Lu
 *
 */
public interface Inventory 
{

	/**
	 * Adds Item into inventory.
	 * @param item the Item will be added.
	 * @return true if the item has been added successfully. Otherwise, return false.
	 */
	public boolean addItem(Item item);
	
	/**
	 * Removes Item from the inventory.
	 * @param index the Item will be removed.
	 * @return the removed item if removing operation has been done successfully.Otherwise
	 * 			Return null.
	 */
	public Item removeItem(int index);
	
	/**
	 * Gets the item at the specific index of Inventory.
	 * @param index the specific index
	 * @return the item at the specific index. Otherwise, return null.
	 */
	public Item getItem(int index);
	
	/**
	 * Use the item which is stored in the Inventory for specific LifeForm.
	 * @param life the LifeForm who own the Inventory.
	 * @param index the specific index of the inventory.
	 * @return True if the item has been used successfully. Otherwise, return false.
	 */
	public boolean use(LifeForm life,int index);
	
	/**
	 * Gets the items' iterator.
	 * @return the items' iterator.
	 */
	public Iterator getIterator();
	
	/**
	 * Gets the Max Size of the Inventory.
	 * @return
	 */
	public int getMaxSize();
	
	/**
	 * Gets how many items have been stored in the Inventory.
	 * @return how many items have been stored in the Inventory
	 */
	public int getActualSize();
	
	/**
	 * Sets the Max size of the Inventory.
	 * @param size the max size of the Inventory.
	 */
	public void setMaxSize(int size);
	
	/**
	 * Sets how many locations have been used.
	 * @param size how many locations have been used.
	 */
	public void setActualSize(int size);
	
	/**
	 * Gets the index of the items, if the item exist in the inventory.
	 * @param item the items
	 * @return the index of the items
	 */
	public int index(Item item);
}
