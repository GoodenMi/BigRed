/**
 * Created by Miles on 9/17/2016.
 */
public class npc {
    String name;
    String description;
    String[] talkingTree;
    int karma;
    public npc(String name, String description, String[] talkingTree, int karma,int talkingPoints){
        this.name = name;
        this.description = description;
        this.karma = karma;
        this.talkingTree = new String[talkingPoints];

    }
    public class enemy extends npc {
        int hp;
        int level;
        int dex;
        int strength;
        int wisdom;
        int protection;
        String npcClass;
        public enemy(String name, String description, String[] talkingTree, int karma, int talkingPoints, item drop, String npcClass) {
            super(name, description, talkingTree, karma, talkingPoints);
            this.npcClass = npcClass;
        }
    }
    public class Shopkeeper extends npc {
    	Shop[] items; //does this work??
    	String npcClass;
    	public Shopkeeper(String name, String description, String[] talkingTree, int karma, int talkingPoints, String[] shop.itemsTree, int Shop.itemsNumber String npcClass){
    		super(name, description, talkingTree, karma, talkingPoints);
    		this.shop.itemsTree = new String[shop.itemsNumber];
    	}
    }
    	
}