package recovery;

public class RecoveryLinear implements Recovery
{
	
	private int recoveryLinear;

	
	public RecoveryLinear(int step)
	{
		recoveryLinear = step;
	}

	
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
