package gameplay;

/**
 * This Interface contains the methods declarations related to Timer.
 * @author Jixiang Lu
 *
 */
public interface Timer
{
	/**
	 * Adds the observer to the list ,to which it notifies when time changed.
	 * @param observer : The observer to be added.
	 */
	public boolean addTimeObserver(TimerObserver ob);
	/**
	 * Removes the observer from the observer list.
	 * @param observer : The observer which is to be removed.
	 */
	public TimerObserver removeTimerObserver(TimerObserver observer);
	
	/**
	 * The method updates all the observers about the change in time.
	 */
	public void notice();
}
