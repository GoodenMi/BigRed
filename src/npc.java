import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Miles on 9/17/2016.
 */
public class npc {
    private static final List<String> NPC_FIRST_NAMES = new ArrayList<>();
    private static final List<String> NPC_LAST_NAMES = new ArrayList<>();
    private static final List<String> NPC_TITLES = new ArrayList<>();
    private static final int INIT_KARMA = 50;

    private static final List<String> SHOPKEEPER_NAMES = new ArrayList<>();
    private static final List<String> ENEMY_NAMES = new ArrayList<>();

    String name;
    String description;
    String[] talkingTree;
    int karma;

    /**
     * Constructs a random NPC
     */
    public npc() {
        if (NPC_FIRST_NAMES.size() == 0) {
            initNpc();
        }
        this.name = NPC_FIRST_NAMES.get(new Random().nextInt(NPC_FIRST_NAMES.size()))
                + " " + NPC_LAST_NAMES.get(new Random().nextInt(NPC_LAST_NAMES.size()));
        this.description = NPC_TITLES.get(new Random().nextInt(NPC_TITLES.size()));
        this.karma = INIT_KARMA;

    }

    /**
     * Initializes NPC String Lists
     */
    public void initNpc() {
        try {
            Scanner scf = new Scanner(new File("first_names.txt"));
            while (scf.hasNextLine()) {
                NPC_FIRST_NAMES.add(scf.nextLine().trim());
            }
            Scanner scl = new Scanner(new File("last_names.txt"));
            while (scl.hasNextLine()) {
                NPC_LAST_NAMES.add(scl.nextLine().trim());
            }
            Scanner sct = new Scanner(new File("people.txt"));
            while (sct.hasNextLine()) {
                NPC_TITLES.add(sct.nextLine().trim());
            }
        }catch (FileNotFoundException fnfe){

        }
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

        public enemy(int expAwarded, player one) {
            super();
            Random rand = new Random();
            this.level = one.level + rand.nextInt(2);
            this.expAwarded = expAwarded * this.level;
        }

        public static class goblin extends enemy {
            public goblin( int exp, player one) {
                super( exp, one);
                this.dex = 6 + (this.level/2);
                this.strength = 5 + (this.level / 2);
                this.protection = 8;
                this.wisdom = 3;
                this.hp = 20 + (this.level*5);
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

        public Shopkeeper(String name, int karma, int itemsNumber, int goldOnHand) {
            super();
            this.Shop = new item[itemsNumber];
            this.itemsNumber = itemsNumber;
            this.goldOnHand = goldOnHand;
        }
    }
}