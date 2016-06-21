package dungeon.cell.state;

import item.Item;
import lifeform.LifeForm;

/**
 * It represents the state of a Cell.
 * 
 * @author Jixiang Lu
 *
 */
public interface State 
{
	/**
	 * Adds the LifeForm into its location according to concrete state rule.
	 * @param life LifeForm will be hold by the Cell.
	 * @return If the LifeForm has been added into the location, return true.
	 * 			Otherwise, return false.
	 */
	public boolean addLifeForm(LifeForm life);
	
	/**
	 * Remove the LifeForm from its location.
	 * @return the LifeForm has been removed. Or null if the LifeForm was removed successfully
	 * 			or there is nothing in its location.
	 */
	public LifeForm removeLifeForm();
	
	/**
	 * Gets the LifeForm from its location.
	 * @return
	 */
	public LifeForm getLifeForm();
	
	/**
	 * Adds the items into its locations according to concrete state rule.
	 * 
	 * @param item the Item will be added.
	 * @param position the Position where Item will be placed into. There are two location 0 or 1.
	 * @return True, if the item has been added successfully. Otherwise, return false.
	 */
	public boolean addItem(Item item, int position);
	
	/**
	 * Removes the items from its location.
	 * @param index the position is consist of 0 or 1. 
	 * @return item has been removed successfully. or Null. 
	 */
	public Item removeItem(int index);
	
	/**
	 * Gets the item from specific position.
	 * @param index position is consist of 0 or 1.
	 * @return the item if there exist an item. Or null.
	 */
	public Item getItem(int index);
	
	/**
	 * Clear every exist in the cell.
	 */
	public void clearCell();
}
