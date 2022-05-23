package no.ntnu.iir.wargames;

import static org.junit.jupiter.api.Assertions.*;

import no.ntnu.iir.wargames.data.CavalryUnit;
import no.ntnu.iir.wargames.data.CommanderUnit;
import no.ntnu.iir.wargames.data.InfantryUnit;
import no.ntnu.iir.wargames.data.RangedUnit;
import no.ntnu.iir.wargames.data.Terrain;
import org.junit.jupiter.api.Test;

public class UnitTest {

  private Terrain terrain = Terrain.TEST;

  public UnitTest() {
  }

  @Test
  public void createInstanceOfInfantryUnit() {
    InfantryUnit u = new InfantryUnit("Footman", 100, terrain);
    assertEquals("Footman",u.getName());
    assertEquals(100,u.getHealth());
    assertEquals(15, u.getAttack());
    assertEquals(10, u.getArmor());
    assertEquals(2, u.getAttackBonus());
    assertEquals(1, u.getResistBonus());

  }

  @Test
  public void createInstanceOfCavalryUnit() {
    CavalryUnit u = new CavalryUnit("Knight", 100, terrain);
    assertEquals("Knight",u.getName());
    assertEquals(100,u.getHealth());
    assertEquals(20, u.getAttack());
    assertEquals(12, u.getArmor());
    assertEquals(6, u.getAttackBonus());
    assertEquals(2, u.getAttackBonus());
    assertEquals(1, u.getResistBonus());
  }

  @Test
  public void createInstanceOfRangedUnit() {
    RangedUnit u = new RangedUnit("Archer", 100, terrain);
    assertEquals("Archer",u.getName());
    assertEquals(100,u.getHealth());
    assertEquals(15, u.getAttack());
    assertEquals(8, u.getArmor());
    assertEquals(3, u.getAttackBonus());
    assertEquals(6,u.getResistBonus());
    assertEquals(4,u.getResistBonus());
    assertEquals(2,u.getResistBonus());
  }

  @Test
  public void createInstanceOfCommanderUnit() {
    CommanderUnit u = new CommanderUnit("Mountain King", 180, terrain);
    assertEquals("Mountain King",u.getName());
    assertEquals(180,u.getHealth());
    assertEquals(25, u.getAttack());
    assertEquals(15, u.getArmor());
    assertEquals(6, u.getAttackBonus());
    assertEquals(1, u.getResistBonus());
  }


}
