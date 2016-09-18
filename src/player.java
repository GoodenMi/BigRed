/**
 * player class
 */
import java.util.Random;
import java.util.Scanner;

public class player{
    int level;
    int dex;
    int damage;
    int strength;
    int wisdom;
    int hp;
    int exp;
    int mana;
    int defence;
    int inventorySize;
    int equipInventorySize;
    int gold;
    attacks[] attackList;
    item[] inventory;
    item.equippable[] equipInventory;
    item.equippable[] equipped;
    String playerClass;
    String name;

    /**
     * Constructor for player object. Creates representation of the human player.
     *
     * @param choice
     * @param name
     */
    public player(String choice, String name){
        this.level = 1;
        this.name = name;
        this.exp = 0;
        this.inventory = new item[15];
        this.inventorySize = 15;
        this.equipInventory = new item.equippable[10];
        this.equipInventorySize = 10;
        this.equipped = new item.equippable[5];
        this.gold = 30;
        if(choice.equals("Knight")){
            this.playerClass = "Knight";
            this.strength = 10;
            this.dex = 8;
            this.hp = 30;
            this.wisdom = 5;
            this.mana = 4;
            this.equipped[0]= new item.armor("Iron Plate Mail","Heavy plate armor",10,100,100,0,0,0);
            this.equipped[1] = new item.headgear("Iron Helmet", "Good head protection",5,80,100,0,0,0);
            this.equipped[2] = new item.weapon("Iron Broadsword","A dull broadsword",5,50,100,0,0,0);
            this.equipped[3] = new item.shield("Iron Kite Shield","A favorite of knights",7,80,100,0,0,0);
            this.equipInventory[0]= this.equipped[0];
            this.equipInventory[1]= this.equipped[1];
            this.equipInventory[2]= this.equipped[2];
            this.equipInventory[3]= this.equipped[3];
            this.defence = this.equipped[0].protection + this.equipped[1].protection +this.equipped[3].protection;
            this.damage = 5;
        } else if(choice.equals("Mage")){
            this.playerClass = "Mage";
            this.strength = 5;
            this.dex = 6;
            this.wisdom = 17;
            this.hp = 15;
            this.mana = 20;
            this.equipped[0] = new item.armor("Simple robes","The cloth robes of a mage",2,30,100,5,0,0);
            this.equipped[1] = new item.headgear("mage hood", "A cloth hood",1,15,100,3,0,0);
            this.equipped[2] = new item.weapon("Staff","A wooden staff.",3,10,100,3,0,0);
            this.equipInventory[0]= this.equipped[0];
            this.equipInventory[1]= this.equipped[1];
            this.equipInventory[2]= this.equipped[2];
            this.defence = this.equipped[0].protection + this.equipped[1].protection;
            this.damage = 10;
        } else if(choice.equals("Rogue")){
            this.playerClass = "Rogue";
            this.strength = 7;
            this.dex = 12;
            this.wisdom = 7;
            this.hp = 20;
            this.mana = 2;
            this.equipped[0] = new item.equippable.armor("Leather armor", " light armor made of cowhide",5,50,100,0,0,3);
            this.equipped[1] = new item.headgear("Cloak", "A smiple cloth cloak.",0,20,100,0,0,5);
            this.equipped[2] = new item.weapon("Dagger","Dull Iron dagger",3,20,100,0,0,2);
            this.equipped[3] = new item.weapon("Dagger","Dull Iron dagger",3,20,100,0,0,2);
            this.equipInventory[0]= this.equipped[0];
            this.equipInventory[1]= this.equipped[1];
            this.equipInventory[2]= this.equipped[2];
            this.equipInventory[3]= this.equipped[3];
            this.defence = this.equipped[0].protection + this.equipped[1].protection;
            this.damage = 6;
        } else{
            System.out.println("That is not a valid class.");
        }

    }

    public void printEquipableInv() {
        for (int i = 0; i < equipInventorySize; i++) {
            if (equipInventory[i] != null) {
                System.out.println(equipInventory[i].name);
            }
        }
    }


    public void equip(String item){
        item.equippable subject = getEItemInv(item);
        if(subject!= null){
            if(subject == this.equipped[subject.getSlot()]){
                System.out.println("You already have it equipped.");
            }else if (this.equipped[subject.getSlot()]==null){
                this.equipped[subject.getSlot()] = subject;
                System.out.println("you are now wearing " +item);
            } else {
                unequip(this.equipped[subject.getSlot()].location);
                this.equipped[subject.getSlot()] = subject;
                System.out.println("you now have the" + item +" equippped.");
            }
        } else{
            System.out.println("That Item is not in your inventory.");
        }
    }

    public void putEItem(item.equippable subject){
        for(int i=0; i<equipInventorySize; i++){
            if(equipInventory[i]==null){
                equipInventory[i] = subject;
                break;
            }
        }
        System.out.println("Your equippable item inventory is full.");
    }

    public item.equippable getEItemInv(String item){
        for(int i = 0; i<this.equipInventorySize; i++){
            if(this.equipInventory[i]!= null) {
                if (this.equipInventory[i].name.equals(item)) {
                    return this.equipInventory[i];
                }
            }
        }
        return null;
    }
    public void unequip(String item){
        if(item.equals("chest")){
            if(this.equipped[0]!= null) {
                System.out.println(this.equipped[0].name + " removed.");
                this.equipped[0] = null;
            } else{
                System.out.println("Chest armor is already removed.");
            }
        } else if(item.equals("head")){
            if(this.equipped[1]!= null) {
                System.out.println(this.equipped[1].name + " removed.");
                this.equipped[1] = null;
            } else{
                System.out.println("Head armor is already removed.");
            }
        } else if(item.equals("right")){
            if(this.equipped[2]!=null) {
                System.out.println(this.equipped[2].name + " removed.");
                this.equipped[2] = null;
            }else{
                System.out.println("Your right hand is already free.");
            }
        } else if(item.equals("left")){
            if(this.equipped[3] != null) {
                System.out.println(this.equipped[3].name + " removed.");
                this.equipped[3] = null;
            } else{
                System.out.println("Your left hand is already free.");
            }
        }else{
            System.out.println("That is not a valid option");
        }
    }

    public int hitChance(boolean isMagic){
        int hitChance;
        Random rand = new Random();
        int x = rand.nextInt(20)+1;
        if(this.playerClass == "Mage"){
            hitChance = this.wisdom*x;
        }else {
            hitChance = this.dex * x;
        }
        return hitChance;
    }
    public int getLevel(){
        return this.level;
    }

    public void printStats(){
        System.out.println("Your name is "+ this.name);
        System.out.println("Your level is: " + this.level);
        System.out.println("Your hp is: " + this.hp);
        System.out.println("Your mana is: " + this.mana);
        System.out.println("Your strength is: " + this.strength);
        System.out.println("Your dexterity is: "+ this.dex);
        System.out.println("Your wisdom is: " + this.wisdom);
        if(this.equipped[0]!= null) {
            System.out.println("You are wearing " +this.equipped[0].name);
        }
        if(this.equipped[1]!= null) {
            System.out.println("You are wearing " +this.equipped[1].name);
        }
        if(this.equipped[2]!= null) {
            System.out.println("You are wielding a " +this.equipped[2].name + " in your right hand.");
        }
        if(this.equipped[3]!= null){
            System.out.println("You are wielding a " + this.equipped[3].name + " in your left hand.");
        }

    }
    public void levelUp(){
        this.level++;
        this.damage+=3;
        Scanner input = new Scanner(System.in);
        System.out.println("Congratulations! You have leveled up! You have 5 skill points to use. " +
                "Where would you like to use them?");
        int points = 5;
        while (points!= 0) {
            System.out.println("1.Strength 2.Dexterity 3.Wisdom 4.hp 5.mana");
            int choice = input.nextInt();
            if(choice == 1){
                this.strength++;
                points--;
            } else if(choice == 2){
                this.dex++;
                points--;
            } else if(choice == 3){
                this.wisdom++;
                points--;
            } else if(choice == 4){
                this.hp++;
                points--;
            } else if(choice == 5){
                this.mana++;
                points--;
            } else{
                System.out.println("That is not a valid input. Try again.");
            }
        }
    }

}