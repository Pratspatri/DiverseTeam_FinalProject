package inventory;

import item.Item;

public interface Inventory 
{

	public boolean addItem(Item item);
	public Item removeItem(Item item);
	public Item removeItem(int index);
	public boolean use(int index);
	public boolean drop(int index);
	public boolean sell(int index);
	public boolean equip(int index);
	public Iterator getIterator();
	public int getMaxSize();
	public int getActualSize();
	public void setMaxSize(int size);
	public void setActualSize(int size);
}
