import java.util.Random;

/**
 * Created by Miles on 9/17/2016.
 */
public class npc {
    String name;
    String description;
    String[] talkingTree;
    int karma;

    public npc(String name) {
        this.name = name;

    }

    public static class enemy extends npc {
        int hp;
        int level;
        int dex;
        int strength;
        int wisdom;
        int protection;
        int expAwarded;
        int damage;
        int goldAwarded;

        public enemy(String name, String description, int level, int expAwarded, int goldAwarded,int defence, int strength,int dex, int wisdom) {
            super(name);
            this.level = level;
            this.expAwarded = expAwarded * this.level;
            this.goldAwarded = goldAwarded * this.level;
            this.damage = ((strength/2) + (dex/2)) *level;
            this.description = description;
            this.wisdom = wisdom;
            this.protection = defence+dex;
            this.hp = 10 + ((this.level-1)*5);
            this.strength = strength +((this.level-1)*2);
            this.dex = dex+(this.level-1);
        }

        public int hitChance(boolean isMagic) {
            int hitChance;
            Random rand = new Random();
            if(isMagic == true){
                hitChance = this.wisdom*(rand.nextInt(20)+1);
            }else {
                hitChance= this.dex+ (rand.nextInt(20) + 1)+ this.level* 2;
            }
            return hitChance;
        }
    }
}
