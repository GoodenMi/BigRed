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

    public static class enemy extends npc {
        int hp;
        int level;
        int dex;
        int strength;
        int wisdom;
        int protection;
        int expAwarded;
        int damage;

        public enemy(String name, String description, int karma, int expAwarded, player one) {
            super(name, description, karma);
            Random rand = new Random();
            this.level = one.level + rand.nextInt(2);
            this.expAwarded = expAwarded * this.level;
        }

        public static class goblin extends enemy {
            public goblin(String name, String description, int karma, int exp, player one) {
                super(name, description, karma, exp, one);
                this.dex = 6 + (this.level * 2);
                this.strength = 5 + (this.level / 2);
                this.protection = 8;
                this.wisdom = 3;
                this.hp = 50 + (this.level * 10);
                this.damage = 4;
            }

            public int hitChance(boolean isMagic) {
                int hitChance;
                Random rand = new Random();
                int x = rand.nextInt(15) + 1;
                hitChance = this.dex * x;
                return hitChance;
            }
        }
    }

    public class Shopkeeper extends npc {
        item[] Shop;
        int itemsNumber;
        int goldOnHand;

        public Shopkeeper(String name, String description, int karma, int itemsNumber, int goldOnHand) {
            super(name, description, karma);
            this.Shop = new item[itemsNumber];
            this.itemsNumber = itemsNumber;
            this.goldOnHand = goldOnHand;
        }
    }
}