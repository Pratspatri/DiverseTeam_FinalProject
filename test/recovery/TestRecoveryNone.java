package recovery;
/**
 * Test for no recovery
 * @author - Prathyusha Akshintala
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class TestRecoveryNone
{

	@Test
	public void testRecovery() 
	{
		Recovery rec = new RecoveryNone();

		// Test for currentLP = maxLP
		assertEquals(15, rec.calculateRecovery(15, 15));

		// Test for currentLP < maxLP
		assertEquals(12, rec.calculateRecovery(12, 15));
	}

}
