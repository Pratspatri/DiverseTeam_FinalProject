import lifeform.TestCreature;
import lifeform.TestGoblin;
import lifeform.TestLifeForm;
import lifeform.TestMummy;
import lifeform.TestPlayer;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ability.TestPoison;
import ability.TestPoke;
import dungeon.TestDungeon;
import recovery.TestRecoveryLinear;
import recovery.TestRecoveryNone;
/**
 * Test Suite for all tests
 * @author Prathyusha Akshintala
 *
 */

@RunWith(Suite.class)
@SuiteClasses({TestRecoveryNone.class, TestRecoveryLinear.class, TestDungeon.class, TestCreature.class, TestLifeForm.class,
	TestPlayer.class, TestMummy.class, TestGoblin.class, TestPoison.class, TestPoke.class})
public class AllGameTests 
{
	
}
