package exception;
/**
 * Exception class for recovery
 * @author Prathyusha Akshintala
 *
 */
public class RecoveryException extends Exception
{
	private static final long serialVersionUID = 1L;

	/**
	 * Exception message 
	 */
	public RecoveryException(String message)
	{
		super(message);
	}
}
