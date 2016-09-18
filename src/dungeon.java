
public class dungeon {
	String name;
	String location;
	int size;
	int numMonsters;
	int currentLevel;
	int loot;
	item itemLoot;
	public dungeon(String name, String location, int size, int numMonsters, int currentLevel, int loot, item itemLoot){
		this.name=name;
		this.location=location;
		this.size=size;
		this.numMonsters=numMonsters;
		this.currentLevel=0;
		this.loot=loot;
		this.itemLoot=item.getName();
	}
	
	public void killedMonster(){
		if (){
			numMonsters--;
		}
	}
		
	public void increaseLevel(){
		if (numMonsters==0 && currentLevel!=size){
			currentLevel++;
		}
	}
	
	public void exit(){
		//TODO exit the dungeon
	}
	
	public boolean completed();
		if (numMonsters==0 && curentLevel==size){
			//TODO add item to invitory
			player.gold=player.gold+loot;
			return true;
		}
	
	/* getter functions*/
	
	public getSize(){
		return this.size;
	}
	
	public getLevel(){
		return this.currentLevel;
	}
	
	
	public String getName() {
        return this.name;
    }
}
