package dungeon;

import item.Item;
import lifeform.LifeForm;

public class CanWalkThroughState extends GenericState
{
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
