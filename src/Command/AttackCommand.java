package Command;

import dungeon.Dungeon;

import lifeform.LifeForm;
/**
 * The class represents a Command. It is used to select LifeForm to attack in the
 * direction it is facing. The LifeForm should only fire its weapon if there is a
 * target and will always attack the closest target.
 * 
 * @author Saad
 *
 */

public class AttackCommand implements Command  {

	
	
	
	private LifeForm life;
	
	/**
	 * Construct an AttackCommand with a life that is used to attack another LifeForm.
	 * 
	 * @param life the LifeForm will be manipulated.
	 */
	
	public AttackCommand(LifeForm life)
	{
		this.life = life;
	}
	
	
	/**
	 * Construct an attack method .the life forms will attack each other. the player wil
	 * attack the creature and the creature will attack each other  
	 */
	@Override
	public String execute() {
		Dungeon den = Dungeon.getDungeonInstance();
		// if the target in the north 
		if(life.getDirection().compareToIgnoreCase("north")==0) 
		{
			int attackRow = life.getRow()-1;   
			
			for(int i =0; i< life.getAttackDistance();i++) 
			{
				if(attackRow<0)
				{
					break;
				}
				else if( den.getLifeForm(attackRow, life.getCol()) != null)
				{ 
					life.attack(den.getLifeForm(attackRow, life.getCol()));     
					return "Attack target!";   
				}
				attackRow -= 1;
			}
			return "Can't attack!";
		}
		
		// if the target in the south 
		else if(life.getDirection().compareToIgnoreCase("South")==0)
		{
			int attackRow = life.getRow()+1; 
			for(int i =0; i< life.getAttackDistance();i++)
			{
				if(attackRow>den.getNumberOfRow())
					break;
				else if(den.getLifeForm(attackRow, life.getCol()) != null)
				{ 
					life.attack(den.getLifeForm(attackRow, life.getCol())); 
					return "Attack target!"; 
				}
				attackRow += 1;
			}
			return "Can't attack!";
		}
		// if the target in the east 
		else if(life.getDirection().compareToIgnoreCase("east")==0)
		{
			int attackCol = life.getCol()+1; 
			for(int i =0; i< life.getAttackDistance();i++)
			{
				if(attackCol>den.getNumberOfCol())
					break;
				if(den.getLifeForm(life.getRow(), attackCol) != null)
				{ 
					life.attack(den.getLifeForm(life.getRow(), attackCol));
					return "Attack target!";
				}
				attackCol += 1;
			}
			return "Can't attack!";
		}
		
		// if the target in the west 
		else if(life.getDirection().compareToIgnoreCase("west")==0)
		{
			int attackCol = life.getCol()-1; 
			for(int i =0; i< life.getAttackDistance();i++)
			{
				if(attackCol<0)
					break;
				if(den.getLifeForm(life.getCol(), attackCol) != null)
				{ 
					life.attack(den.getLifeForm(life.getCol(), attackCol));
					return "Attack target!";
				}
				attackCol -= 1;
			}
			return "Can't attack!";
		}
		else
		{
			return "Can't attack!"; 
		}
		
	}

}
