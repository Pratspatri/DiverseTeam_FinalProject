package lifeform;
/**
 * LifeForm class which implements TimerObserver
 * @author - Prathyusha Akshintala
 */
import dungeon.Dungeon;
import gameplay.TimerObserver;
import item.Gun;
import item.Weapon;

public abstract class LifeForm implements TimerObserver
{
	private String name;								// Name of the Player or Creature
	
	protected int lifePoints;							// current life points for both player and creature
	
	protected int strength;								// strength indicates how much damage can it do
	
	protected int hitPoints;							// hitPoints indicates how much damage it can take
	
	private int trackRow;								// tracks row coordinate
	
	private int trackCol;								// tracks col coordinate
	
	private Weapon weapon;								// weapon for the lifeform
	
	private String Direction;                             //To set and get dierction of life form
		
	public LifeForm(String name, int life, int strength)  // constructor
	{
		this.name = name;
		lifePoints = (life >= 0) ? life : 0;
		this.strength = (strength >= 0) ? strength : 0;
		hitPoints = 0;
		trackRow = -1;
		trackCol = -1;
	}
	/**
	 * @author - Prathyusha Akshintala
	 * Gets the name 
	 * @return name
	 */
	public String getName()							
	{
		return name;
	}
	/**
	 * @author - Prathyusha Akshintala
	 * Gets the life points
	 * @return LifePoints
	 */
	public int getLifePoints()
	{
		return lifePoints;
	}
	/**
	 * @author - Prathyusha Akshintala
	 * Sets LifePoints
	 * @param life
	 */
	public void setLifePoints(int life)
	{
		if(life > 0)
		{
			this.lifePoints = life;
		}
	}
	/**
	 * @author - Prathyusha Akshintala
	 * How much damage can a lifeform take
	 * @param damage
	 */
	public abstract void takeHit(LifeForm lifeform, int damage);
	/**
	 * @author - Prathyusha Akshintala
	 * Gets the hit points
	 * @return
	 */
	public int getHitPoints()
	{
		return hitPoints;
	}
	/**
	 * @author - Prathyusha Akshintala
	 * Set the hit points
	 * @param hit
	 */
	public void setHitPoints(int hit)
	{
		if(hit > 0)
		{
			this.hitPoints = hit;
		}
	}
	/**
	 * Get the strength
	 * @author - Prathyusha Akshintala
	 * @return
	 */
	public int getStrength()
	{
		return strength;
	}
	/**
	 * Sets the strength
	 * @author - Prathyusha Akshintala
	 * @param strength
	 */
	public void setStrength(int strength)
	{
		this.strength = (strength >= 0) ? strength : 0;
	}
	/**
	 * When one LifeForm attacks another
	 * @author - Prathyusha Akshintala
	 * @param lifeForm2
	 */
 	public void attack(LifeForm lifeForm2)
	{
		Dungeon dun = Dungeon.getDungeonInstance();
		int distance = dun.getDistance(this, lifeForm2);
		
		if (getLifePoints() > 0)
		{
			if (weapon != null)
			{
				int damage = weapon.calculateDamage(distance);
				lifeForm2.takeHit(this,damage);
			}
			else
			{
				lifeForm2.takeHit(this,getStrength());
			}
		}
	}

	/**
	 * When the time is changed the timer notifies this method of the Observer.
	 * It performs nothing in here.
	 * @author - Prathyusha Akshintala
	 * @param time : updated time
	 */
	@Override
	public void updateTime(int time)
	{
	}

	/**
	 * Pickup the Weapon.
	 * @author - Prathyusha Akshintala
	 * @param weapon : The weapon to be picked up.
	 */
	public void pickUpWeapon(Weapon weapon)
	{
		if (this.weapon == null)
		{
			this.weapon = weapon;
		}
	}
		
	/**
	 * @return the weapon the LifeForm has.
	 * @author - Prathyusha Akshintala
	 */
	public Weapon getWeapon()
	{
		return weapon;
	}

	/**
	 * Drops the weapon the LifeForm has.
	 * @author - Prathyusha Akshintala
	 */
	public void dropWeapon()
	{
		weapon = null;
	}
	//
	public void Reload()
	{
		
		((Gun) weapon).reload();
		
	}
	/**
	 * Sets the locale with respect to coordinates
	 * @author - Prathyusha Akshintala
	 * @param row
	 * @param col
	 */
	public void setLocation(int row, int col)  
	{
		this.trackRow = row;
		this.trackCol = col;
	}
	/**
	 * Removes and resets the location given with respect to coordinates
	 * @author - Prathyusha Akshintala
	 */
	public void removeLocation() 
	{
		this.trackRow = -1;
		this.trackCol = -1;
	}
	/**
	 * @return - the row coordinate
	 * @author - Prathyusha Akshintala
	 */
	public int getRow() 
	{
		return this.trackRow;
	}
	/**
	 * @author - Prathyusha Akshintala
	 * @return - the col coordinate
	 */
	public int getCol() 
	{
		return this.trackCol;
	}
	/**
	 * Gets the number of Cell that the LifeForm can attach other LifeForm through.
	 * @author - Prathyusha Akshintala
	 * @return
	 */
	public int getAttackDistance()
	{
		return (int) ((weapon==null)?0:weapon.getMaxrRange());
	}	
	//
	public void SetDirection (String newDirection)
	{
		this.Direction = newDirection ; 
	}
	//
	public String getDirection ()
	{
		return Direction ; 
	}
}
