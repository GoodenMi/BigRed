
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
		String town;
		String npcClass;
		public kill(String name, String description, int reward, int expAwarded,int numEnemy, String town, String npcClass){
			super(name, description,reward, expAwarded);
			this.numEnemy=numEnemy;
			this.town= town;
		}
	}
	
	public class deliverTo extends quest {
		String town;
		public deliverTo(String name, String description, int reward, int expAwarded, String town){
			super(name, description, reward, expAwarded);
			this.town=town;
		}
	}
	public class fetch extends quest{
		String item;
		String town;
		public fetch(String name, String description, int reward, int expAwarded, String item, String town){
			super(name,description, reward, expAwarded);
			this.item=item;
			this.town=town;
		}
	}
	
	public class gather extends quest{
		String item;
		int numItem;
		public gather(String name, String description, int reward, int expAwarded, String item, int numItem){
			super(name,description, reward, expAwarded);
			this.item=name;
			this.numItem=numItem;
		}
	}
	
	public class complete extends quest{
		String dungeonName;
		public complete(String name, String description, int reward, int expAwarded,String dungeonName){
			super(name, description, reward, expAwarded);
			this.dungeonName= name;
		}
	}
	
	public String getName() {
        return this.name;
    }
}
