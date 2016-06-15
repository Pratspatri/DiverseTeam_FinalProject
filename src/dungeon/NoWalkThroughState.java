package dungeon;

import item.Item;
import lifeform.LifeForm;

public class NoWalkThroughState extends GenericState
{

	@Override
	public boolean addLifeForm(LifeForm life)
	{
		return false;
	}

	@Override
	public boolean addItem(Item item, int position)
	{
		return false;
	}

}
