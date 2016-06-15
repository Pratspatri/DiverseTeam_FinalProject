package gameplay;

public interface Timer
{
	public boolean addTimeObserver(TimerObserver ob);
	public TimerObserver removeTimerObserver(TimerObserver observer);
	public void notice();
}
