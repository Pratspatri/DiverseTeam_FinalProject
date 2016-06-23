import gameplay.TestSimpleTimer;
import inventory.TestInventory;
import inventory.TestInventoryFactory;
import inventory.TestIterator;
import item.TestAbilityArmor;
import item.TestAffectBehavior;
import item.TestAlihotsyDraught;
import item.TestAlittleDamage;
import item.TestAntiParalysis;
import item.TestAntiPoison;
import item.TestArmor;
import item.TestDamageDecorator;
import item.TestFactoryArmor;
import item.TestFactoryWeapon;
import item.TestGenericItem;
import item.TestGun;
import item.TestHealing;
import item.TestIgnoreDamage;
import item.TestImmunePoison;
import item.TestKeys;
import item.TestKeysFactory;
import item.TestNoHealing;
import item.TestNormalArmor;
import item.TestPotionFactory;
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

import Command.TestAcquireCommand;
import Command.TestAttackCommand;
import Command.TestDropCommand;
import Command.TestInvoker;
import Command.TestInvokerBuilder;
import Command.TestMoveCommand;
import Command.TestReloadCommand;
import Command.TestSouthCommand;
import Command.TestTurnEastComand;
import Command.TestTurnNorthCommand;
import Command.TestTurnWest;
import Command.TurnSouthCommand;
import recovery.TestRecoveryLinear;
import recovery.TestRecoveryNone;
import ui.TestGameDisplay;
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
import dungeon.cell.state.TestStateFactory;

@RunWith(Suite.class)
@SuiteClasses({TestRecoveryNone.class, TestRecoveryLinear.class, TestDungeon.class, TestCreature.class, TestLifeForm.class,
	TestPlayer.class, TestMummy.class, TestGoblin.class, TestPoison.class, TestPoke.class,
	TestAbilityArmor.class, TestAffectBehavior.class, TestAlihotsyDraught.class, TestAlittleDamage.class,
	TestAntiParalysis.class, TestAntiPoison.class, TestArmor.class, TestDamageDecorator.class,
	TestFactoryArmor.class, TestFactoryWeapon.class, TestGenericItem.class, TestGun.class, TestHealing.class,
	TestIgnoreDamage.class, TestImmunePoison.class, TestKeys.class, TestKeysFactory.class, TestNoHealing.class,
	TestNormalArmor.class, TestPotionFactory.class, TestPotions.class, TestPowerArmor.class, TestReallyDamage.class,
	TestSharpArmor.class, TestSpear.class, TestSpecialArmor.class, TestSword.class, TestWeapon.class,
    TestInventory.class,TestIterator.class,TestCanWalkThroughState.class, TestDoorState.class,
    TestGenericState.class,TestNoWalkThroughState.class,TestCell.class,TestCellFactory.class,TestStateFactory.class,TestInventoryFactory.class , 
    TestGenericState.class,TestNoWalkThroughState.class,TestCell.class,TestCellFactory.class , TestAcquireCommand.class,
    TestAttackCommand.class , TestDropCommand.class , TestInvoker.class , TestInvokerBuilder.class , TestMoveCommand.class , 
    TestReloadCommand.class , TestSouthCommand.class , TestTurnNorthCommand.class , TestTurnEastComand.class , TestTurnWest.class , 

    
})
public class AllGameTests 
{
	
}
