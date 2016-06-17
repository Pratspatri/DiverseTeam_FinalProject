package recovery;
/**
 * Test for Linear Recovery
 * @author - Prathyusha Akshintala
 */
import static org.junit.Assert.*;

import org.junit.Test;

public class TestRecoveryLinear 
{

	@Test
	public void test() 
	{
		Recovery rec = new RecoveryLinear(3);

		// Test for currentLP = maxLP
		assertEquals(15, rec.calculateRecovery(15, 15));

		// Test for w 0 < maxLP- currentLP < step
		assertEquals(15, rec.calculateRecovery(14, 15));

		// foe step < maxLP – currentLP
		assertEquals(13, rec.calculateRecovery(10, 15));

		// Test for currentLP = 0
		assertEquals(0, rec.calculateRecovery(0, 15));
	}

}
