package lifeform;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLifeForm 
{

	@Test
	public void testInitialize()
	{
		LifeForm sansa = new MockLifeForm("Sansa", 15, 5); 
	    assertEquals("Sansa", sansa.getName()); 
	    assertEquals(15, sansa.getLifePoints()); 
	 
	    LifeForm robb = new MockLifeForm("Robb", -40, 0); 
	    assertEquals("Robb", robb.getName()); 
	    // LifeForm can not have negative life points so it should have 0. 
	    assertEquals(0, robb.getLifePoints()); 
	}
}
