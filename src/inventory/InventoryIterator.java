package inventory;

import item.Item;

import java.util.ArrayList;

/**
 * It is used to iterate over the list of items which are stored at the Inventory.
 * 
 * @author Jixiang Lu
 *
 */
public class InventoryIterator implements Iterator
{
	private ArrayList<Item> items;
	private int position;
	
	/**
	 * Construct an Iterator with the list of Items.
	 * @param items the list of Items.
	 */
	public InventoryIterator(ArrayList<Item> items)
	{
		this.items = items;
		position =0;
	}
	
	/**
	 * Notices whether there are still other items in the iterator.
	 *  
	 * @return true,If there are still other items in the iterator. Otherwise return false
	 */
	@Override
	public boolean hasNext()
	{
		return position<items.size();	
	}

	/**
	 * Return the next items in the iterator.
	 * @return the next items in the iterator, if the next element exist. Otherwise, return null.
	 */
	@Override
	public Item next()
	{
		try
		{
			Item item = items.get(position);
			position += 1;
			return item;
		}
		catch(IndexOutOfBoundsException ex)
		{
			return null;
		}
	}



}
