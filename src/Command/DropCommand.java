package Command;

import dungeon.Dungeon;
import item.Item;
import lifeform.LifeForm;
import lifeform.Player;
/**
 * The class represents a Command. It is used to drop the item the player is holding.
 * If there is no space for item in the Cell, the player can't drop the item.
 * 
 * @author Saad
 *
 */
public class DropCommand implements Command  {
	
	
	
	/**
	 * Drops the item which the player is holding. If there is no space for item in the 
	 * Cell, the player can't drop the item. and the items are weapon or armor
	 */
	@Override
	public String execute() {
		
		Dungeon den = Dungeon.getDungeonInstance();
		Player player =(Player) Player.getPlayerInstance(); 
		Item itm = den.getItem(player.getRow(), player.getCol(),0 );
		Item itm2 = den.getItem(player.getRow(), player.getCol(),1 ); 
		
			if(itm != null&& itm2 !=null)
			{
				return "You can not Drop here";
			}else 
			{
				int position = (itm == null)?0:1;
				Item drop;
				if(player.getWeapon()!=null)
				{
					drop = player.getWeapon();
					player.dropWeapon();
				}
				else if(player.getArmor()!=null)
				{
					drop = player.getArmor();
					player.setArmor(null);
				}
				
				else
					return "You can not Drop here";
				den.addItem(player.getRow(), player.getCol(), drop, position);
				return "the item has been droped";
				
			}
		
		
	}

}
