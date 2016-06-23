package Save.and.Load;
import javax.swing.text.Document;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import com.sun.org.apache.xml.internal.serialize.*;

import junit.framework.Test;
import lifeform.Player;

import org.w3c.dom.Element;
import org.w3c.dom.Text;
/**
 * save as xml class which extends from save abstract class . will save the information 
 * of the palayer as a xml file 
 * @author Saad
 *
 */



public class SaveAsXMLFile extends Save {

	@Override
	public void SavePlayerName() {

		
		 Player player = (Player) Player.getPlayerInstance();
		 String namePlayer = player.getName();
		DocumentBuilderFactory factroy = DocumentBuilderFactory.newInstance();
		try{
		DocumentBuilder builder = factroy.newDocumentBuilder();
		Document doc = (Document) builder.newDocument();
		Element root = ((org.w3c.dom.Document) doc).createElement("name");
		Test name = (Test) ((org.w3c.dom.Document) doc).createTextNode(namePlayer);
		
		
	    }
		catch(ParserConfigurationException e)
		{
			System.out.println("Can not read");
		}
	}

	@Override
	public void SavePlayerData() {
		
		Player player = (Player) Player.getPlayerInstance();
		 String armor = player.getArmorDescription()
		DocumentBuilderFactory factroy = DocumentBuilderFactory.newInstance();
		try{
		DocumentBuilder builder = factroy.newDocumentBuilder();
		Document doc = (Document) builder.newDocument();
		Element root = ((org.w3c.dom.Document) doc).createElement("name");
		Test name = (Test) ((org.w3c.dom.Document) doc).createTextNode(armor);
		
		
	}
		catch(ParserConfigurationException e)
		{
			
		}
	
	
	}
}
