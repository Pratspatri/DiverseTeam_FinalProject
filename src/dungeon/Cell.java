package dungeon;

import item.Item;
import lifeform.LifeForm;

public class Cell
{
	//TODO please add lifeForm items to the cell. Each cell can only have at most 5 items.
	// For that reason only, am passing position in get and set methods.
	
//TODO
	public boolean addItem(Item item, int position) 
	{
		return false;
	}
//TODO
	public Item removeItem(int position) 
	{
		return null;
	}
//TODO
	public Item getItem(int position) 
	{
		return null;
	}
//TODO
	public void setState(State state)
	{
		
	}
//TODO
	public State getState()
	{
		return null;
		
	}
//TODO
	public LifeForm getLifeForm() 
	{
		return null;
	}
//TODO
	public boolean addLifeForm(LifeForm entity) 
	{
		return false;
	}
//TODO
	public LifeForm removeLifeForm() 
	{
		return null;
	}
}