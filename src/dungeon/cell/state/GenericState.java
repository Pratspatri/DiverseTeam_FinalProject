package dungeon.cell.state;

import item.Item;
import lifeform.LifeForm;

/**
 * It defines some generic operations of State.
 * 
 * @author Jixiang Lu
 *
 */
public abstract class GenericState implements State
{

	protected LifeForm life;
	protected Item item[];
	
	/**
	 * Construct a GenericaState Class with 2 locations will be used to store items and one location 
	 * will be used to stored LifeForm.
	 */
	public GenericState()
	{
		life = null;
		item = new Item[2];
		item[0] = null;
		item[1] = null;
	}
	
	/**
	 * Remove the LifeForm from its location.
	 * @return the LifeForm has been removed. Or null if there is nothing in its location.
	 */
	@Override
	public LifeForm removeLifeForm()
	{
		LifeForm temp = this.life;
		this.life = null;
		return temp;
	}

	/**
	 * Gets the LifeForm from its location.
	 * @return
	 */
	@Override
	public LifeForm getLifeForm()
	{
		return life;
	}


	/**
	 * Removes the items from its location.
	 * @param index the position is consist of 0 or 1. 
	 * @return item has been removed successfully. or Null. 
	 */
	@Override
	public Item removeItem(int index)
	{

		try
		{
			Item im = this.item[index];
			item[index] = null;
			return im;
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			return null;
		}
	}
	

	/**
	 * Gets the item from specific position.
	 * @param index position is consist of 0 or 1.
	 * @return the item if there exist an item. Or null.
	 */
	@Override
	public Item getItem(int index)
	{
		try
		{
			Item result = item[index];
			return result;
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			return null;
		}
	}

	/**
	 * Clear every exist in the cell.
	 */
	@Override
	public void clearCell()
	{
		life = null;
		item[0] = null;
		item[1] = null;
	}

}
