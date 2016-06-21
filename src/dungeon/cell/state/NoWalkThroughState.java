package dungeon.cell.state;

import item.Item;
import lifeform.LifeForm;

/**
 * This class represents a state of the Cell. The Cell with this state can't be added anything
 * into its locations. 
 * 
 * @author Jixiang Lu
 *
 */
public class NoWalkThroughState extends GenericState
{

	/**
	 * Can't add any LifeForm into its locations.
	 */
	@Override
	public boolean addLifeForm(LifeForm life)
	{
		return false;
	}

	/** 
	 * Can't add any items into its locations.
	 */
	@Override
	public boolean addItem(Item item, int position)
	{
		return false;
	}

}
