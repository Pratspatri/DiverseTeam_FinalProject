package gameplay;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class consists members and functions related to SimpleTimer. SimpleTimer
 * is a Timer
 * @author Jixiang Lu
 *
 */
public class SimpleTimer extends Thread implements Timer
{

	private ArrayList<TimerObserver> list;
	private int time;
	
	/**
	 * Create an instance of SimpleTimer.
	 */
	public SimpleTimer()
	{
		list = new ArrayList<TimerObserver>();
		time = 0;
	}
	
	/**
	 * Adds the observer to the list ,to which it notifies when time changed.
	 * @param observer : The observer to be added.
	 */
	@Override
	public boolean addTimeObserver(TimerObserver ob)
	{
		return list.add(ob);
	}

	/**
	 * Removes the observer from the observer list.
	 * @param observer : The observer which is to be removed.
	 */
	@Override
	public TimerObserver removeTimerObserver(TimerObserver observer)
	{
		TimerObserver ob = observer;
		boolean signal = list.remove(observer);
		return signal?ob:null ;
	}

	/**
	 * The method updates all the observers about the change in time.
	 */
	@Override
	public void notice()
	{
		Iterator<TimerObserver> it = list.iterator();
		
		while(it.hasNext())
		{
			
			TimerObserver to= it.next();
					to.updateTime(time);
		}
		
	}

	/**
	 * Updates time for 50 ms and calls  notice method.
	 */
	@Override
	public void run()
	{
		while(true)
		{
			try
			{
				Thread.sleep(50);
				time++;
				notice();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
