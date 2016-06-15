package inventory;

import item.Item;

import java.util.ArrayList;

public class InventoryIterator implements Iterator
{
	private ArrayList<Item> items;
	private int position;
	
	public InventoryIterator(ArrayList<Item> items)
	{
		this.items = items;
		position =0;
	}
	
	@Override
	public boolean hasNext()
	{
		return position<items.size();	
	}

	@Override
	public Item next()
	{
		Item item = items.get(position);
		position += 1;
		return item;
	}

	@Override
	public Item remove()
	{
		return items.remove(position);
	}

}
