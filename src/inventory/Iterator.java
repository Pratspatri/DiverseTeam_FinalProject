package inventory;

import item.Item;

/**
 * It is Iterator interface. It is helpful to iterate over a set of Data.
 * 
 * @author Jixiang Lu
 *
 */
public interface Iterator
{
	/**
	 * Notices whether there are still other elements in the iterator.
	 *  
	 * @return true,If there are still other elements in the iterator. Otherwise return false
	 */
	public boolean hasNext();
	
	/**
	 * Return the next element in the iterator.
	 * @return the next element in the iterator, if the next element exist. Otherwise, return null.
	 */
	public Item next();
}
