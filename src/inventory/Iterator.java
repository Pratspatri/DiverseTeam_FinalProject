package inventory;

import item.Item;

public interface Iterator
{
	public boolean hasNext();
	public Item next();
	public Item remove();
}
