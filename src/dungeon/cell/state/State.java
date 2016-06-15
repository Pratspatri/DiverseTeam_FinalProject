package dungeon.cell.state;

import item.Item;
import lifeform.LifeForm;

/**
 * 
 * @author Jixiang Lu
 *
 */
public interface State 
{
	public boolean addLifeForm(LifeForm life);
	public LifeForm removeLifeForm();
	public LifeForm getLifeForm();
	public boolean addItem(Item item, int position);
	public Item removeItem(int index);
	public Item getItem(int index);
	public void clearCell();
}
