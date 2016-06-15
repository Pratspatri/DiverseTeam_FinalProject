package dungeon;

import item.Item;
import lifeform.LifeForm;

/**
 * 
 * @author Jixiang Lu
 *
 */
public class Cell
{
	private State state;
	
	public Cell()
	{
		this(new CanWalkThroughState());
	}
	
	public Cell(State state)
	{
		this.state = state;
	}

	public boolean addItem(Item item, int position) 
	{
		return state.addItem(item, position);
	}

	public Item removeItem(int position) 
	{
		return state.removeItem(position);
	}

	public Item getItem(int position) 
	{
		return state.getItem(position);
	}

	public void setState(State state)
	{
		this.state = state;
	}

	public State getState()
	{
		return state;
		
	}

	public LifeForm getLifeForm() 
	{
		return state.getLifeForm();
	}

	public boolean addLifeForm(LifeForm entity) 
	{
		return state.addLifeForm(entity);
	}

	public LifeForm removeLifeForm() 
	{
		return state.removeLifeForm();
	}
}