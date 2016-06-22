import inventory.TestInventory;
import inventory.TestIterator;
import item.TestAffectBehavior;
import item.TestAlihotsyDraught;
import item.TestAlittleDamage;
import item.TestAntiParalysis;
import item.TestAntiPoison;
import item.TestArmor;
import item.TestGenericItem;
import item.TestGun;
import item.TestIgnoreDamage;
import item.TestImmunePoison;
import item.TestNormalArmor;
import item.TestPotions;
import item.TestPowerArmor;
import item.TestReallyDamage;
import item.TestSharpArmor;
import item.TestSpear;
import item.TestSpecialArmor;
import item.TestSword;
import item.TestWeapon;
import lifeform.TestCreature;
import lifeform.TestGoblin;
import lifeform.TestLifeForm;
import lifeform.TestMummy;
import lifeform.TestPlayer;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import recovery.TestRecoveryLinear;
import recovery.TestRecoveryNone;
import ability.TestPoison;
import ability.TestPoke;
import dungeon.TestDungeon;
import dungeon.cell.TestCell;
import dungeon.cell.TestCellFactory;
import dungeon.cell.state.TestCanWalkThroughState;
/**
 * Test Suite for all tests
 * @author Prathyusha Akshintala
 *
 */
import dungeon.cell.state.TestDoorState;
import dungeon.cell.state.TestGenericState;
import dungeon.cell.state.TestNoWalkThroughState;

@RunWith(Suite.class)
@SuiteClasses({TestRecoveryNone.class, TestRecoveryLinear.class, TestDungeon.class, TestCreature.class, TestLifeForm.class,
	TestPlayer.class, TestMummy.class, TestGoblin.class, TestPoison.class, TestPoke.class,
	TestAlittleDamage.class, TestArmor.class, TestGenericItem.class,
    TestGun.class, TestIgnoreDamage.class, TestAntiParalysis.class, 
    TestNormalArmor.class, TestAntiPoison.class, TestPotions.class, 
    TestPowerArmor.class,TestReallyDamage.class, TestSharpArmor.class,
    TestSpear.class, TestSpecialArmor.class, TestSword.class,TestAffectBehavior.class,
    TestAlihotsyDraught.class, TestWeapon.class,TestImmunePoison.class, TestInventory.class,
    TestIterator.class,TestCanWalkThroughState.class, TestDoorState.class,
    TestGenericState.class,TestNoWalkThroughState.class,TestCell.class,TestCellFactory.class
})
public class AllGameTests 
{
	
}
