package no.ntnu.iir.wargames;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UnitTest {

  public UnitTest() {
  }

  @Test
  public void createInstanceOfInfantryUnit() {
    InfantryUnit u = new InfantryUnit("Footman", 100);
    assertEquals("Footman",u.getName());
    assertEquals(100,u.getHealth());
    assertEquals(15, u.getAttack());
    assertEquals(10, u.getArmor());
  }

  @Test
  public void createInstanceOfCavalryUnit() {
    CavalryUnit u = new CavalryUnit("Knight", 100);
    assertEquals("Knight",u.getName());
    assertEquals(100,u.getHealth());
    assertEquals(20, u.getAttack());
    assertEquals(12, u.getArmor());
  }

  @Test
  public void createInstanceOfRangedUnit() {
    RangedUnit u = new RangedUnit("Archer", 100);
    assertEquals("Archer",u.getName());
    assertEquals(100,u.getHealth());
    assertEquals(15, u.getAttack());
    assertEquals(8, u.getArmor());
  }

  @Test
  public void createInstanceOfCommanderUnit() {
    CommanderUnit u = new CommanderUnit("Mountain King", 180);
    assertEquals("Mountain King",u.getName());
    assertEquals(180,u.getHealth());
    assertEquals(25, u.getAttack());
    assertEquals(15, u.getArmor());
  }


}
