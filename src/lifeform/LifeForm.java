package lifeform;

import gameplay.TimerObserver;
import inventory.Inventory;
import item.Item;
import item.Weapon;
import dungeon.Dungeon;

public class LifeForm implements TimerObserver
{
	private String name;
	
	protected int lifePoints;
	
	protected int strength;
	
	protected int hitPoints;
	
	private int trackRow;
	
	private int trackCol;
	
	private Weapon weapon;

	private Item item;
	
	private Inventory bag;
	
	public LifeForm(String name, int life)
	{
		this.name = name;
		lifePoints = (life >= 0) ? life : 0;
		strength = 0;
		hitPoints = 0;
		trackRow = -1;
		trackCol = -1;
	}
	public LifeForm(String name, int life, int strength)
	{
		this(name, life);
		this.strength = (strength >= 0) ? strength : 0;
	}

	public String getName()
	{
		return name;
	}
	
	public int getLifePoints()
	{
		return lifePoints;
	}

	public void takeHit(int damage)
	{
		if (damage > 0)
		{
			lifePoints -= damage;
			lifePoints = (lifePoints >= 0) ? lifePoints : 0;
		}
	}

	public int getStrength()
	{
		return strength;
	}
	//TODO  check why it is distance < 10
 	public void attack(LifeForm lifeForm2)
	{
		Dungeon dun = Dungeon.getDungeonInstance();
		int distance = dun.getDistance(this, lifeForm2);
		if (getLifePoints() > 0)
		{
			if (weapon == null || Weapon.getActualAmmo() == 0)
			{
				if (distance <= 10)
				{
					lifeForm2.takeHit(getStrength());
				}
			}
			else
			{
				lifeForm2.takeHit(Weapon.fire(distance));
			}
		}
	}

	/**
	 * When the time is changed the timer notifies this method of the Observer.
	 * It performs nothing in here.
	 * @param time : updated time
	 */
	@Override
	public void updateTime(int time)
	{
	}

	/**
	 * Pickup the Weapon.
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
	 */
	public Weapon getWeapon()
	{
		return weapon;
	}

	/**
	 * Drops the weapon the LifeForm has.
	 */
	public void dropWeapon()
	{
		weapon = null;
	}
	//TODO for the gun weapon. it needs reload and max ammo etc.
	/**
	 *
	 * Reloads the weapon the lifeForm has.
	 */
	public void weaponReloaded()
	{
		weapon.reload();
	}
	/**
	 * Sets the locale with respect to coordinates
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
	 */
	public void removeLocation() 
	{
		this.trackRow = -1;
		this.trackCol = -1;
	}
	/**
	 * @return - the row coordinate
	 */
	public int getRow() 
	{
		return this.trackRow;
	}
	/**
	 * @return - the col coordinate
	 */
	public int getCol() 
	{
		return this.trackCol;
	}
	//TODO check why 5
	/**
	 * Gets the number of Cell that the LifeForm can attach other LifeForm through.
	 * @return
	 */
	public int getAttackDistance()
	{
		return (int) ((weapon==null)?0:weapon.getMaxrRange()/5);
	}
	
}
