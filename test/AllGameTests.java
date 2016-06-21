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
import item.TestAlittleDamage;
import item.TestArmor;
import item.TestGenericItem;
import item.TestGun;
import item.TestIgnoreDamage;
import item.TestMega;
import item.TestNormalArmor;
import item.TestPokemon;
import item.TestPotions;
import item.TestPowerArmor;
import item.TestReallyDamage;
import item.TestSharpArmor;
import item.TestSpear;
import item.TestSpecialArmor;
import item.TestSword;
import item.TestUltra;
import item.TestWeapon;
import recovery.TestRecoveryLinear;
import recovery.TestRecoveryNone;
/**
 * Test Suite for all tests
 * @author Prathyusha Akshintala
 *
 */

@RunWith(Suite.class)
@SuiteClasses({TestRecoveryNone.class, TestRecoveryLinear.class, TestDungeon.class, TestCreature.class, TestLifeForm.class,
	TestPlayer.class, TestMummy.class, TestGoblin.class, TestPoison.class, TestPoke.class,
	TestAlittleDamage.class, TestArmor.class, TestGenericItem.class,
    TestGun.class, TestIgnoreDamage.class, TestMega.class, 
    TestNormalArmor.class, TestPokemon.class, TestPotions.class, 
    TestPowerArmor.class,TestReallyDamage.class, TestSharpArmor.class,
    TestSpear.class, TestSpecialArmor.class, TestSword.class,
    TestUltra.class, TestWeapon.class	
})
public class AllGameTests 
{
	
}
