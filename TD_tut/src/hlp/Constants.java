package hlp;

public class Constants {

	public static class Tower
	{
		public static final int TOWER1=0;
		public static final int TOWER2=1;
		public static final int TOWER3=2;
		public static String GetName(int towerType) {
			switch (towerType) {
			case TOWER1:
				return "Cannon";
			case TOWER2:
				return "Archer";
			case TOWER3:
				return "Wizard";
			}
			return "";
		}

		public static float GetStartDmg(int towerType) {
			switch (towerType) {
			case TOWER1:
				return 25;
			case TOWER2:
				return 15;
			case TOWER3:
				return 5;
			}

			return 0;
		}

		public static float GetDefaultRange(int towerType) {
			switch (towerType) {
			case TOWER1:
				return 100;
			case TOWER2:
				return 100;
			case TOWER3:
				return 100;
			}

			return 0;
		}

		public static float GetDefaultCooldown(int towerType) {
			switch (towerType) {
			case TOWER1:
				return 10;
			case TOWER2:
				return 10;
			case TOWER3:
				return 10;
			}

			return 0;
		
		
	       }
	}
	public static class Direction {
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int RIGHT = 2;
		public static final int DOWN = 3;
	}
	
	public static class Tiles{
		public static final int GRASS_TILE = 0;
		public static final int ROAD_TILE = 1;
		public static final int SAND_TILE = 2;
	}

	public static class Enemies {

		public static final int SOLDIER = 0;
		public static final int  TANK= 1;
		public static final int PLANE = 2;
		

		public static float GetSpeed(int enemyType) {
			switch (enemyType) {
			
			case SOLDIER:
				return 0.65f;
			case TANK:
				return 0.3f;
			case PLANE:
				return 0.75f;
			}
			return 0;
		}

		public static int GetStartHealth(int enemyType) {
			switch (enemyType) {
			case SOLDIER:
				return 100;
			case TANK:
				return 60;
			case PLANE:
				return 250;
			
			}
			return 0;
		}
	}

}


