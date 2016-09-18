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
            this.protection = 0;
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
        public weapon(String name, String description, int damage, int value, int condition, int wisMod, int strMod, int dexMod) {
            super(name, description, value, wisMod, strMod, dexMod);
            this.damage = damage;
            this.condition = condition;
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
    }
    public static class shield extends equippable{
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
    }
    
    public String getName() {
        return this.name;
    }

}



