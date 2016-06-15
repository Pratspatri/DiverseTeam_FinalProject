package dungeon.cell.state;

import item.Item;
import lifeform.LifeForm;

public abstract class GenericState implements State
{

	protected LifeForm life;
	protected Item item[];
	
	public GenericState()
	{
		life = null;
		item = new Item[2];
		item[0] = null;
		item[1] = null;
	}

	@Override
	public LifeForm removeLifeForm()
	{
		return life;
	}

	@Override
	public LifeForm getLifeForm()
	{
		return life;
	}


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

	@Override
	public void clearCell()
	{
		life = null;
		item[0] = null;
		item[1] = null;
	}

}
