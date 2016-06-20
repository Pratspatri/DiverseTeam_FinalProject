package Command;

import dungeon.Dungeon;
import lifeform.LifeForm;

public class AttackCommand implements Command  {

	
	
	
	private LifeForm life;
	
	public AttackCommand(LifeForm life)
	{
		this.life = life;
	}
	
	
	@Override
	public String execute() {
		Dungeon den = Dungeon.getDungeonInstance();
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
		else if(life.getDirection().compareToIgnoreCase("east")==0)
		{
			int attackCol = life.getCol()+1; 
			for(int i =0; i< life.getAttackDistance();i++)
			{
				if(attackCol>den.getNumberOfCol())
					break;
				if(den.getLifeForm(life.getCol(), attackCol) != null)
				{ 
					life.attack(den.getLifeForm(life.getCol(), attackCol));
					return "Attack target!";
				}
				attackCol += 1;
			}
			return "Can't attack!";
		}
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
