
public class dungeon {
	String name;
	String location;
	int size;
	int numMonsters;
	int currentLevel;
    int loot;
	public dungeon(String name, String location, int size, int numMonsters, int currentLevel, int loot){
		this.name=name;
		this.location=location;
		this.size=size;
		this.numMonsters=numMonsters;
		this.currentLevel=currentLevel;
		this.loot = loot;
	}
	
	public void killedMonster(){

	}
		
	public void increaseLevel(){
		if (numMonsters==0 && currentLevel!=size){
			currentLevel++;
		}
	}
	
	public void exit(){
		//TODO exit the dungeon
	}
	
	public boolean completed(player one) {
        if (numMonsters == 0 && this.currentLevel == size) {
            //TODO add item to invitory
            one.gold += this.loot;
            return true;
        }
        return false;
    }
	
	public String getName() {
        return this.name;
    }
}
