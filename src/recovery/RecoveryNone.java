package recovery;
/**
 * Class for no recovery for creatures
 * @author Prathyusha Akshintala
 *
 */
public class RecoveryNone implements Recovery
{
	/**
	 * @author Prathyusha Akshintala
	 * Calculates recovery and returns the lifePoints
	 */
	@Override
	public int calculateRecovery(int lifePoints, int maxLife) 
	{
		return lifePoints;
	}
	
}
