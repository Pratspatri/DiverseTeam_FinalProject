package Command;

import dungeon.Dungeon;
import item.Item;
import lifeform.LifeForm;
import lifeform.Player;

public class DropCommand implements Command  {
	
	private LifeForm life;
	
	/**
	 * Construct an AcquireCommand method with a LifeForm that will be manipulated.
	 * 
	 * @param life the LifeForm will be manipulated.
	 */
	public DropCommand(LifeForm life)
	{
		this.life = life ; 
	}

	@Override
	public String execute() {
		
		Dungeon den = Dungeon.getDungeonInstance();
		Item itm = den.getItem(life.getRow(), life.getCol(),0 );
		Item itm2 = den.getItem(life.getRow(), life.getCol(),1 );
		if(life instanceof Player)
		{
			if(itm != null&& itm2 !=null)
			{
				return "You can not Drop here";
			}else 
			{
				int position = (itm == null)?0:1;
				((Player) life).removeFromInventory(itm);
				den.addItem(life.getRow(), life.getRow(), itm, position);
				return "the item has been droped";
				
			}
		}
		else
		{
			return "you can not Drop items";
		}
	}

}
