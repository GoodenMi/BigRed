import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Miles on 9/17/2016.
 */
public class item {
    String name;
    String description;
    int value;

    public item(String name, String description, int value) {
        this.name = name;
        this.value = value;
        this.description = description;
    }

    public static class equippable extends item {
        int wisReq;
        int dexReq;
        int strReq;
        int protection;
        int damage;
        int equipSlot;
        String location;

        public equippable (String name, String description, int value, int wisReq, int dexReq, int strReq) {
            super(name, description, value);
            this.wisReq = wisReq;
            this.strReq = strReq;
            this.dexReq = dexReq;
        }
        public int getSlot() {
            return this.equipSlot;
        }

        public void Stats() {
            System.out.println(this.name + ": " + this.description + " It is worth " + this.value + " gold coins.");
            System.out.println("It's strength requirement is " + strReq);
            System.out.println("It's dexterity requirement is " + dexReq);
            System.out.println("It's wisdom requirement is " + wisReq);
        }
    }

    public static class weapon extends equippable {
        int damage;
        int condition;
        String location;

        public weapon(String name, String description, int damage, int value, int condition, int wisReq, int strReq, int dexReq) {
            super(name, description, value, wisReq, strReq, dexReq);
            this.damage = damage;
            this.condition = condition;
            this.equipSlot = 2;
            this.location = "right";
        }

        public weapon(String[] params) {
            // parse string
            super(params[0], params[1], Integer.getInteger(params[2]), Integer.getInteger(params[3]),
                    Integer.getInteger(params[4]), Integer.getInteger(params[5]));
            System.out.println(params.length);
            this.damage = Integer.getInteger(params[6]);
            this.condition = Integer.getInteger(params[7]);
            this.equipSlot = 2;
            this.location = "right";
        }
    }



    public static class armor extends equippable {


        int protection;
        int condition;
        int equipSlot;
        String location;
        public armor(String name, String description, int protection, int value, int condition, int wisReq, int strReq, int dexReq) {
            super(name, description, value, wisReq, dexReq, strReq);
            this.protection = protection;
            this.condition = condition;
            this.equipSlot = 0;
            this.location = "chest";
        }

        public int getProtection() {
            return this.protection;
        }

        public void armorStats() {
            System.out.println(this.name + ": " + this.description + " has " + this.protection + "protection. Is worth " + this.value + " gold coins. Condition: " + this.condition + "/100");
            System.out.println("It's strength requirement is " + strReq);
            System.out.println("It's dexterity requirement is " + dexReq);
            System.out.println("It's wisdom requirement is " + wisReq);
        }


        /**
         * Create headgear object from String array.
         *
         * @param params array of string values in order
         */
        public armor(String[] params) {
            // parse string
            super(params[0],params[1],Integer.getInteger(params[2]),Integer.getInteger(params[3]),
                    Integer.getInteger(params[4]),Integer.getInteger(params[5]));
            this.protection = Integer.getInteger(params[6]);
            this.condition = Integer.getInteger(params[7]);
            this.equipSlot = 0;
            this.location = "chest";
        }


    }

    public static class headgear extends equippable {

        int equipSlot;
        int condition;
        int protection;
        String location;
        public headgear(String name, String description, int protection, int value, int condition, int wisReq, int strReq, int dexReq) {
            super(name, description, value, wisReq, dexReq, strReq);
            this.protection = protection;
            this.condition = condition;
            this.equipSlot = 1;
            this.location = "Head";
        }

        /**
         * Create headgear object from String array.
         *
         * @param params array of string values in order
         */
        public headgear(String[] params) {
            // parse string
            super(params[0],params[1],Integer.getInteger(params[2]),Integer.getInteger(params[3]),
                    Integer.getInteger(params[4]),Integer.getInteger(params[5]));
            this.protection = Integer.getInteger(params[6]);
            this.condition = Integer.getInteger(params[7]);
            this.equipSlot = 1;
            this.location = "Head";
        }
    }
    public static class shield extends equippable{
        private static final List<item.shield> SHIELD_TIER_0 = new ArrayList<>();
        private static final List<item.shield> SHIELD_TIER_1 = new ArrayList<>();
        private static final List<item.shield> SHIELD_TIER_2 = new ArrayList<>();
        private static final List<item.shield> SHIELD_TIER_3 = new ArrayList<>();
        private static final List<item.shield> SHIELD_TIER_4 = new ArrayList<>();
        private static final List<item.shield> SHIELD_TIER_5 = new ArrayList<>();
        int equipSlot;
        int condition;
        int protection;
        String location;
        public shield(String name, String description, int protection, int value, int condition, int wisReq, int strReq, int dexReq) {
            super(name, description, value, wisReq, dexReq, strReq);
            this.protection = protection;
            this.condition = condition;
            this.equipSlot = 3;
            this.location = "left";
        }

        /*** Create headgear object from String array.
         *
         * @param params array of string values in order
         */
        public shield(String[] params) {
            // parse string
            super(params[0],params[1],Integer.getInteger(params[2]),Integer.getInteger(params[3]),
                    Integer.getInteger(params[4]),Integer.getInteger(params[5]));
            this.protection = Integer.getInteger(params[6]);
            this.condition = Integer.getInteger(params[7]);
            this.equipSlot = 3;
            this.location = "left";
        }

        public static void initShield() {
            try {
                Scanner sc = new Scanner(new File("src/headgear.txt"));
                String shieldName;
                int tierCounter = 0;
                while (sc.hasNextLine()) {
                    shieldName = sc.nextLine().trim();
                    if (shieldName.equals("Tier")) {
                        tierCounter++;
                    } else {
                        switch (tierCounter) {
                            case 0:
                                SHIELD_TIER_0.add(new item.shield(shieldName.split(",")));
                                break;
                            case 1:
                                SHIELD_TIER_1.add(new item.shield(shieldName.split(",")));
                                break;
                            case 2:
                                SHIELD_TIER_2.add(new item.shield(shieldName.split(",")));
                                break;
                            case 3:
                                SHIELD_TIER_3.add(new item.shield(shieldName.split(",")));
                                break;
                            case 4:
                                SHIELD_TIER_4.add(new item.shield(shieldName.split(",")));
                                break;
                            case 5:
                                SHIELD_TIER_5.add(new item.shield(shieldName.split(",")));
                                break;
                        }
                    }
                }
            } catch (FileNotFoundException fnfe) {
                System.err.println("The file shield.txt.txt is not found in the src folder.");
            }
        }

        public item.shield getShield(player player) {
            Random ran = new Random();
            item.shield hg;
            switch (player.level/10) {
                case 0:
                    hg = SHIELD_TIER_0.get(ran.nextInt(SHIELD_TIER_0.size()));
                    break;
                case 1:
                    hg = SHIELD_TIER_1.get(ran.nextInt(SHIELD_TIER_1.size()));
                    break;
                case 2:
                    hg = SHIELD_TIER_2.get(ran.nextInt(SHIELD_TIER_2.size()));
                    break;
                case 3:
                    hg = SHIELD_TIER_3.get(ran.nextInt(SHIELD_TIER_3.size()));
                    break;
                case 4:
                    hg = SHIELD_TIER_4.get(ran.nextInt(SHIELD_TIER_4.size()));
                    break;
                case 5: case 6:
                    hg = SHIELD_TIER_5.get(ran.nextInt(SHIELD_TIER_5.size()));
                    break;
                default:
                    hg = SHIELD_TIER_0.get(ran.nextInt(SHIELD_TIER_0.size()));
            }
            return hg;
        }
    }
    
    public String getName() {
        return this.name;
    }

}



