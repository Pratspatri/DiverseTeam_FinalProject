package Command;

import Command.Invoker;
import Command.ReloadCommand;
import lifeform.LifeForm;
import Command.AttackCommand;
import Command.MoveCommand;
import Command.TurnSouthCommand;
import Command.TurnWestCommand;
import Command.TurnEastCommand;
import Command.TurnNorthCommand;
import Command.AcquireCommand ; 
import Command.DropCommand;


/**
 * get Invoker method 
 * @param life
 * @return invoker 
 * @author Saad
 */

public class InvokerBuilder {
	/**
	 * get invoker method to set each command to the correct reciver 
	 * @param life
	 * @return
	 */
	
	public Invoker getInvoker(LifeForm life)
	{
	//create invoker object 
	Invoker invoker = new Invoker();
	//Set invoker commands 
	invoker.setRelaod(new ReloadCommand(life));
	invoker.setAcquire(new AcquireCommand());
	invoker.setDrop(new DropCommand());
	invoker.setTurnEast(new TurnEastCommand(life));
	invoker.setTurnNorth(new TurnNorthCommand(life));
	invoker.setTurnSouth(new TurnSouthCommand(life));
	invoker.setTurnWest(new TurnWestCommand(life)); 
	invoker.setMove(new MoveCommand(life));
	invoker.setAttack(new AttackCommand(life)); 
	
	return invoker ; 
	
	}


}
