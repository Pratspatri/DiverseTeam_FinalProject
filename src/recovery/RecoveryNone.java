package recovery;

public class RecoveryNone implements Recovery
{

	@Override
	public int calculateRecovery(int lifePoints, int maxLife) 
	{
		return lifePoints;
	}
	
}
