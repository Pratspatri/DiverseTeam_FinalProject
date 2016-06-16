package lifeform;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLifeForm 
{

	@Test
	public void testInitialize()
	{
		LifeForm entity = new MockLifeForm("Bob", 40, 5); 
	    assertEquals("Bob", entity.getName()); 
	    assertEquals(40, entity.getCurrentLifePoints()); 
	 
	    entity = new MockLifeForm("Bob", -40); 
	    assertEquals("Bob", entity.getName()); 
	    // LifeForm can not have negative life points so it should have 0. 
	    assertEquals(0, entity.getCurrentLifePoints()); 
	}
}
