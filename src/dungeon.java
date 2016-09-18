
public class dungeon {
	String name;
	String location;
	int numLvl;
	int numMonsters;
	public dungeon(String name, String location, int numLvl, int numMonsters){
		this.name=name;
		this.location=location;
		this.numLvl=numLvl;
		this.numMonsters=numMonsters;
	}
	
	
	
	public String getName() {
        return this.name;
    }
}
