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

        public enemy(String name, int level, int expAwarded, int goldAwarded, player one) {
            super(name);
            Random rand = new Random();
            this.level = level;
            this.expAwarded = expAwarded * this.level;
            this.goldAwarded = goldAwarded * this.level;
        }

        public static class knight extends enemy{
            public knight(String name,int level, int exp,int gold, player one){
                super(name,level, exp, gold,one);
                this.damage = 5 +(this.strength/2 +(this.level));
                this.dex = 3 +(this.level/2);
                this.strength = 3 +(this.level*2);
                this.protection = 6+ (this.level);
                this.wisdom = 6;
                this.hp = 10 + (this.level*5);
            }
        }

        public static class mage extends enemy {
            public mage(String name, int level, int exp, int gold, player one) {
                super(name,level, exp,gold, one);
                this.dex = 5 + (this.level);
                this.strength = 3 + (this.level / 2);
                this.protection = 8;
                this.wisdom = 10 * (this.level * 2);
                this.hp = 10 + (this.level);
                this.damage = 4 + (this.level);
            }
        }

            public int hitChance(boolean isMagic) {
                int hitChance;
                Random rand = new Random();
                if(isMagic == true){
                    hitChance = this.wisdom*(rand.nextInt(20)+1);
                }else {
                    hitChance= this.dex*(rand.nextInt(15) + 1);
                }
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
