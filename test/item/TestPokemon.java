package item;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test the Pokemon methods 
 * @author Malak
 *
 */
public class TestPokemon 
{
    /**
     * Test Initialize
     */
	@Test
	public void TestInitialization()  
	{
		Pokemon pokemon=new Pokemon();
		equals(pokemon.affect instanceof Healing );
	}
	
	 /**
     * Test taken method
     */
	@Test
	public void TestTakenMethod()  
	{
		Pokemon pokemon=new Pokemon();
		pokemon.taken(10);
		assertEquals(13,pokemon.getAmount());
	}

}
