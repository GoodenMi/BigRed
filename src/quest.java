
public class quest {
	String name;
	String description;
	int reward;
	int expAwarded;
	public quest(String name, String description, int reward, int expAwarded){
		this.name=name;
		this.description=description;
		this.reward=reward;
		this.expAwarded=expAwarded;
	}
	
	public class kill extends quest {
		int numEnemy;
		String[] town;
		String npcClass;
		public kill(String name, String description, int reward, int expAwarded,int numEnemy, String[] town, String npcClass){
			super(name, description,reward, expAwarded);
			this.numEnemy=numEnemy;
			this.location= town.name;
			
		}
	}
}
