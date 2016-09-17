
public class tile {
	String name;
	String description;
	item[] items; //check these notation
	npc.enemy[] enemies;

	public tile(String name, String description, item[] items, npc.enemy[] enemies, int itemNum, int enemyNum) {
		this.name = name;
		this.description = description;
		this.items = new item[itemNum]; //check this and below as well
		this.enemies = new npc.enemy[enemyNum];
	}

	public class adj extends tile {
		String[] direction;

		public adj(String name, String description, item[] items, npc.enemy[] enemies, int item, int enemy, String direction) {
			super(name, description, items, enemies, item, enemy);
			this.direction = new String[4]; //check this
		}

	}
}
