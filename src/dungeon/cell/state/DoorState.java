package dungeon.cell.state;

import item.Item;
import item.Keys;
import lifeform.LifeForm;


/**
 * It represents there is a Door in this location.
 * 
 * @author Jixiang Lu
 *
 */
public class DoorState extends GenericState
{
	private Item key;
	
	/**
	 * Construct a Door can be opened by any key. 
	 */
	public DoorState()
	{
		this(null);
	}
	
	/**
	 * Construct a Door can be opened with specific key.
	 * @param key the specific key.
	 */		
	public DoorState(Item key)
	{
		super();
		if(key==null)
			this.key = key;
		else if(key instanceof Keys)
			this.key = key;
		else
			this.key = null;
	}

	/**
	 * The Door state cannot be added LifeForm into its location.
	 */
	@Override
	public boolean addLifeForm(LifeForm life)
	{
		return false;
	}

	/**
	 * The Door state cannot be added any kinds of item into its location except Key Item.
	 * If the key can open the door, it will return true. Otherwise return false.
	 */
	@Override
	public boolean addItem(Item item, int position)
	{

		if(item instanceof Keys)
		{
			if(key == null)
			{
				return true;
			}
			else if(((Keys)this.key).getKey()== ((Keys)item).getKey())
			{
				return true;
				
			}
			else
				return false;
		}
		return false;
	}

	
}
