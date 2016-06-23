package recovery;
/**
 * Class for linear recovery 
 * @author Prathyusha Akshintala
 *
 */
public class RecoveryLinear implements Recovery
{
	private int recoveryLinear;

	/**
	 * @author Prathyusha Akshintala
	 * @param step
	 */
	// To add step to lifePoints
	public RecoveryLinear(int step)
	{
		recoveryLinear = step;
	}

	/**
	 * @author Prathyusha Akshintala
	 */
	// Calculate recovery after calling recovery Linear
	@Override
	public int calculateRecovery(int lifePoints, int maxLife)
	{
		if (lifePoints == 0)
		{
			return 0;
		}
		else
		{
			lifePoints += recoveryLinear;
			lifePoints = (lifePoints <= maxLife) ? lifePoints : maxLife;
			return lifePoints;
		}
	}
}
