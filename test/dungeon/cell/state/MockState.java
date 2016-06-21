package dungeon.cell.state;

import item.Item;
import lifeform.LifeForm;

/**
 * 
 * @author Jixiang
 *
 */
public class MockState extends GenericState
{

	@Override
	public boolean addLifeForm(LifeForm life)
	{
		this.life = life;
		return true;
	}

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
