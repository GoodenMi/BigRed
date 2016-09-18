import java.util.Random;

/**
 * Created by Miles on 9/17/2016.
 */
public class npc {
    String name;
    String description;
    String[] talkingTree;
    int karma;

    public npc(String name, String description, int karma) {
        this.name = name;
        this.description = description;
        this.karma = karma;

    }

    public class enemy extends npc {
        int hp;
        int level;
        int dex;
        int strength;
        int wisdom;
        int protection;
        int expAwarded;

        public enemy(String name, String description, int karma, int expAwarded,player one) {
            super(name, description,karma);
            Random rand = new Random();
            this.expAwarded = expAwarded;
            this.level = one.level + rand.nextInt(2);
        }
    }
    public static class goblin extends enemy{
        public goblin(String name, String description,int karma, int exp, player one){
            super(name,description,karma,exp,one);
            this.dex = 6+this.level;
            this.strength = 5 + (this.level/2);
            this.protection = 8;
            this.wisdom = 3;
            this.hp = 6 + this.level;
        }
        public int hitChance(boolean isMagic){
            int hitChance;
            Random rand = new Random();
            int x = rand.nextInt(15)+1;
            hitChance = this.dex * x;
            return hitChance;
        }
    }

        //public class Shopkeeper extends npc {
            //item[] Shop;
            //int itemsNumber;
            //int goldOnHand;

            //public Shopkeeper(String name, String description, String[] talkingTree, int karma, int talkingPoints, int itemsNumber, int goldOnHand) {
                //super(name, description, talkingTree, karma, talkingPoints);
                //this.Shop = new item[itemsNumber];
                //this.goldOnHand = goldOnHand;
          //  }
        //}

    }