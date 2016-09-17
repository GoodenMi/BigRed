/**
 * Created by Miles on 9/17/2016.
 */
public class item {
    String name;
    String description;
    int value;
    public item(String name,String description,int value){
        this.name = name;
        this.value = value;
        this.description = description;
    }
    public static class equippable extends item{
        int wisMod;
        int dexMod;
        int strMod;
        int manaMod;
        int hpMod;
        public equippable(String name, String description, int value, int wisMod, int dexMod, int manaMod, int hpMod, int strMod){
            super(name,description,value);
            this.wisMod = wisMod;
            this.strMod = strMod;
            this.manaMod = manaMod;
            this.dexMod = dexMod;
            this.hpMod = hpMod;
        }
        public void Stats() {
            System.out.println(this.name + ": " + this.description +" It is worth " + this.value + " gold coins.");
            if (this.hpMod != 0) {
                System.out.println("It's hp modifier is " + hpMod);
            }
            if (this.strMod != 0) {
                System.out.println("It's strength modifier is " + strMod);
            }
            if (this.dexMod != 0) {
                System.out.println("It's dexterity modifier is " + dexMod);
            }
            if (this.wisMod != 0) {
                System.out.println("It's wisdom modifier is " + wisMod);
            }
            if (this.manaMod != 0) {
                System.out.println("It's mana modifier is " + manaMod);
            }
        }

    }
    public static class weapon extends equippable{
        int damage;
        int condition;
        public weapon(String name, String description, int damage, int value,int condition,int wisMod, int strMod, int dexMod, int manaMod, int hpMod){
            super(name,description,value,wisMod,strMod,dexMod,manaMod,hpMod);
            this.damage = damage;
            this.condition = condition;
        }
    }
    public static class armor extends equippable {
        int protection;
        int condition;

        public armor(String name, String description, int protection, int value, int condition, int wisMod, int strMod, int dexMod, int manaMod, int hpMod) {
            super(name, description, value, wisMod, dexMod, manaMod, hpMod, strMod);
            this.protection = protection;
            this.condition = condition;
            this.dexMod = dexMod;
            this.strMod = strMod;
            this.manaMod = manaMod;
            this.wisMod = wisMod;
        }

        public int getProtection() {
            return this.protection;
        }

        public void armorStats() {
            System.out.println(this.name + ": " + this.description + " has " + this.protection + "protection. Is worth " + this.value + " gold coins. Condition: " + this.condition + "/100");
            if (this.hpMod != 0) {
                System.out.println("It's hp modifier is " + hpMod);
            }
            if (this.strMod != 0) {
                System.out.println("It's strength modifier is " + strMod);
            }
            if (this.dexMod != 0) {
                System.out.println("It's dexterity modifier is " + dexMod);
            }
            if (this.wisMod != 0) {
                System.out.println("It's wisdom modifier is " + wisMod);
            }
            if (this.manaMod != 0) {
                System.out.println("It's mana modifier is " + manaMod);
            }
        }
    }
}
