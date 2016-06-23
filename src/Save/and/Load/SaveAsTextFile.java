package Save.and.Load;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.xml.transform.OutputKeys;

import lifeform.Player;


/**
 * Save as text File class which save the info of the player and save it as text 
 * @author Saad
 *
 */
public class SaveAsTextFile extends Save{

	
	
	/**
	 * Get the the name of the player and save it inside file 
	 */
	@Override
	public void SavePlayerName() {
		Player player = (Player)Player.getPlayerInstance();
		
		String file = "PlayerName.txt";
		String playerName = player.getName();
		try{
			PrintWriter print = new PrintWriter(file);
			print.println(playerName);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			
		}
		
		
		
	}
	
	/**
	 * Get info of  the player and save it inside file 
	 */

	@Override
	public void SavePlayerData() {

        Player player = (Player)Player.getPlayerInstance();
		
		String file = "PlayerInfo.txt";
		String playerlifepoint = ""+player.getLifePoints();
		String  playerArmore = player.getArmorDescription();
		try{
			PrintWriter print = new PrintWriter(file);
			print.println(playerlifepoint);
			print.println(playerArmore);
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
			
		}
		
		
	}
	
	
}
