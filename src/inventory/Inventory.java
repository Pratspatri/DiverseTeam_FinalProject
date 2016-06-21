package inventory;

import item.Item;
import lifeform.LifeForm;

public interface Inventory 
{

	public boolean addItem(Item item);
	public Item removeItem(int index);
	public Item getItem(int index);
	public boolean use(LifeForm life,int index);
	public Iterator getIterator();
	public int getMaxSize();
	public int getActualSize();
	public void setMaxSize(int size);
	public void setActualSize(int size);
	public int index(Item item);
}
