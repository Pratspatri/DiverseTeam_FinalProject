package dungeon.cell.state;

import item.Item;
import lifeform.LifeForm;


/**
 * It represents a Cell where can walk in and also can stored two Items.
 * 
 * @author Jixiang Lu
 *
 */
public class CanWalkThroughState extends GenericState
{
	/**
	 * Adds LifeForm into this Cell if there doesn't exist any LifeForm.
	 * If there is one LifeForm in this Cell, another Lifeform can not be 
	 * added into this Cell. 
	 */
	@Override
	public boolean addLifeForm(LifeForm life)
	{
		if(this.life != null)
		{
			return false;
		}
		else
		{
			this.life = life;
			return true;
		}
	}

	/**
	 * Adds item in specific position. If there is one Item at this position or the position is
	 * invalid, do nothing and return false.
	 */
	@Override
	public boolean addItem(Item item, int position)
	{
		try
		{
			if(this.item[position] != null)
			{
				return false;
			}
			else
			{
				
				this.item[position] = item;
				return true;
			}
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			return false;
		}
	}
}
