package Command;

import dungeon.Dungeon;
import item.Item;
import lifeform.LifeForm;
import lifeform.Player;

public class AcquireCommand implements Command{

	
	
	
	/**
	 * Construct an AcquireCommand method with a LifeForm that will be manipulated.
	 * 
	 * @param life the LifeForm will be manipulated.
	 */
	
	@Override
	public String execute() {

		Player life =(Player) Player.getPlayerInstance();
		Dungeon den = Dungeon.getDungeonInstance();
		Item itm = den.getItem(life.getRow(), life.getCol(),0 );
		Item itm2 = den.getItem(life.getRow(), life.getCol(),1 );
		
		   if(itm != null)
		   {
			   life.addToInventory(itm2);
			    den.removeItem(life.getRow(), life.getCol(), 0);
			     return "Item has been picked up.";
		    }
		   else if (itm2!=null)
		   {
			
			   life.addToInventory(itm);
			    den.removeItem(life.getRow(), life.getCol(), 1);
			     return "Item has been picked up.";
		    }
		
		    else
		    {
			    return "No item can be picked up.";
		    }
		


		
	}
	

}
