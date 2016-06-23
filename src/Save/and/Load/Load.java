package Save.and.Load;

import java.io.File;
import java.util.Scanner;

import item.Armor;
import item.Item;
import item.MockArmor;
import lifeform.Player;
/**
 * Load class . will load the info about the player and create new player using this
 * information 
 * @author Saad
 *
 */

public class Load {
	
	private Scanner x ; 
	/**
	 * Data Load method 
	 */
	 public void loadData()
	 {
		 String name ;
		 String lifePoint = null ;
		 String armor = null;
		 
		 Player player = (Player) Player.getPlayerInstance();
		 try
		 {
			 x = new Scanner(new File ("PlayerInfo.txt"));
			 
		 }
		 catch(Exception e)
		 {
			 System.out.println("Can not read the file");
		 }
		 
		
		 while(x.hasNext())
		 {
			 name = x.next();
			  lifePoint = x.next();
			  armor = x.next();
		 }
		 
		 Armor s = new MockArmor(armor);
		 s.setDescription(armor);
		 int life = Integer.parseInt(lifePoint);
		 player.setExpPoints(life);
		 
	 }

}
