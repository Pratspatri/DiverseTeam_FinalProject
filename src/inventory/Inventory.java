package inventory;

import item.Item;

public interface Inventory 
{

	Inventory addItem(Item item);

	Inventory removeItem(Item item);

	void use(Item item);

}
