package dungeon.cell;

import dungeon.cell.state.CanWalkThroughState;
import dungeon.cell.state.State;
import item.Item;
import lifeform.LifeForm;

/**
 *  A Cell can hold a LifeForm and Items according to State's rule.
 *  
 * @author Jixiang Lu
 *
 */
public class Cell
{
	
	private State state;
	
	/**
	 * Create a Cell with CanWalkThroughState
	 */
	public Cell()
	{
		this(new CanWalkThroughState());
	}
	
	/**
	 * Create a Cell with specific State.
	 * 
	 * @param state the specific State.
	 */
	public Cell(State state)
	{
		this.state = state;
	}

	/**
	 * Added item into Cell according to its State's rule.
	 * 
	 * @param item the item will be added into Cell.
	 * @param position the position 
	 * @return true if the item has been added into Cell successfully. Otherwise return false.
	 */
	public boolean addItem(Item item, int position) 
	{
		return state.addItem(item, position);
	}

	/**
	 * Removed item from the Cell according to its State's rule.
	 * @param position the position where the item will be removed is place in.
	 * @return the removed item if the item has been removed successfully. Otherwise return null.
	 */
	public Item removeItem(int position) 
	{
		return state.removeItem(position);
	}

	/**
	 * Gets item from the Cell according to its State's rule.
	 * @param position the position
	 * @return Item in the position. or Null.
	 */
	public Item getItem(int position) 
	{
		return state.getItem(position);
	}

	/**
	 * Sets the Cell's state.
	 * @param state the state will be set.
	 */
	public void setState(State state)
	{
		this.state = state;
	}

	/**
	 * Gets the Cell's state.
	 * @return the Cell's state.
	 */
	public State getState()
	{
		return state;
		
	}

	/**
	 * Gets the LifeForm according to its State's rule. 
	 * @return LifeFrom if the Cell contains a LifeForm. or Null.
	 */
	public LifeForm getLifeForm() 
	{
		return state.getLifeForm();
	}

	/**
	 * Adds the LifeForm according to its State's rule.
	 * @param entity the LifeForm will be added.
	 * @return true if the LifeForm has been added.Otherwise, return false.
	 */
	public boolean addLifeForm(LifeForm entity) 
	{
		return state.addLifeForm(entity);
	}

	/**
	 * Removes the LifeForm from the Cell according to its State's rule.
	 * 
	 * @return LifeForm if LifeForm has been removed successfully. Otherwise return null.
	 */
	public LifeForm removeLifeForm() 
	{
		return state.removeLifeForm();
	}
	
	/**
	 * Clears all the staffs that are stored in the Cell.
	 */
	public void clearCell()
	{
		state.clearCell();
	}
}