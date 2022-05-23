package no.ntnu.iir.wargames.data;

/**
 * Enums representing terrain types. Different type gives different attack/resistance bonuses.
 */
public enum Terrain {
    HILL, PLAIN, FOREST, TEST, NOTERRAIN
  }
//
//  private Terrains currentTerrain;
//
//  public Terrain() {
//    Random rand = new Random();
//    int randomInt = rand.nextInt(2);
//    switch (randomInt) {
//      case 0:
//        currentTerrain = HILL;
//        break;
//      case 1:
//        currentTerrain = PLAIN;
//        break;
//      case 2:
//        currentTerrain = FOREST;
//        break;
//      default:
//        throw new IllegalArgumentException();
//    }
//  }
//
//  public Terrains getTerrains() {
//    return this.currentTerrain;
//  }
//}
