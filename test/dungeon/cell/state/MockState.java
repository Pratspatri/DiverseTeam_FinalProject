package dungeon.cell.state;

import item.Item;
import lifeform.LifeForm;

/**
 * A MockState is used to do some test.
 * 
 * @author Jixiang Lu
 *
 */
public class MockState extends GenericState
{

	/**
	 * Adds the LifeForm into its location
	 */
	@Override
	public boolean addLifeForm(LifeForm life)
	{
		this.life = life;
		return true;
	}

	/**
	 * Adds the Item into specific position.
	 */
	@Override
	public boolean addItem(Item item, int position)
	{
		try
		{
			this.item[position] = item;
			return true;
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			return false;
		}
	}

}
