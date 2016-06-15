package dungeon;

import item.Item;
import lifeform.LifeForm;

public class DoorState extends GenericState
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
		// TODO Auto-generated method stub
		/*
		 * if item == key
		 * return true;
		 * else return false;
		 * 
		 */
		return false;
	}

	
}
