package gameplay;

import java.util.ArrayList;
import java.util.Iterator;

public class SimpleTimer extends Thread implements Timer
{

	private ArrayList<TimerObserver> list;
	private int time;
	
	public SimpleTimer()
	{
		list = new ArrayList<TimerObserver>();
		time = 0;
	}
	
	@Override
	public boolean addTimeObserver(TimerObserver ob)
	{
		return list.add(ob);
	}

	@Override
	public TimerObserver removeTimerObserver(TimerObserver observer)
	{
		TimerObserver ob = observer;
		boolean signal = list.remove(observer);
		return signal?ob:null ;
	}

	@Override
	public void notice()
	{
		Iterator<TimerObserver> it = list.iterator();
		while(it.hasNext())
		{
			it.next().updateTime(time);
		}
		
	}

	@Override
	public void run()
	{
		while(true)
		{
			try
			{
				Thread.sleep(1000);
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
