package item;

/**
 * it is one of item that could help the player t open doors or chests
 * @author Malak
 *
 */
public class Keys extends GenericItem 
{   /**
     * Each key has id
     */
    public int idKey;
    
    /**
     * Constructor 
     * @param noKey
     */
	public Keys(int noKey) 
	{
		idKey=noKey;
	}
     /**
      * set the id to key
      * @param noKey
      */
	public void setKey(int noKey)
	{
		idKey=noKey;
	}
	/**
	 * get id key
	 * @return
	 */
	public int getKey()
	{
		return idKey;
	}
}
