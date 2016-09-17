
public class tile {
	String name;
	String description;
	item[] items; //check these notation
	enemy[] enemies;
	public tile(String name, String description, item[] items, enemy[] enemies, int item, int enemy){
		this.name = name;
		this.description = description;
		this.items = new items[item]; //check this and below as well
		this.enemies = new enemies[enemy];
	}
	public class adj extends tile{
		String[] direction;
		public adj(String name, String description, item[] items, enemy[] enemies, int item, int enemy, String direction, int directionNum)
			super(name, description, items, enemies, item, enemy)
			this.direction = new String[locationNum] //check this 
	}
	
}
