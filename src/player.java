/**
 * Created by Miles on 9/17/2016.
 */
import java.util.Random;
import java.util.Scanner;

public class player{
    int level;
    int dex;
    int strength;
    int wisdom;
    int hp;
    int mana;
    int defence;
    int inventorySize;
    int gold = 30;
    attacks[] attackList;
    item[] inventory;
    item.equippable[] equipInventory;
    item.equippable[] equipped;
    item.equippable rightwield;
    item.equippable leftwield;
    String playerClass;
    String name;
    public player(String choice, String name){
        this.level = 1;
        this.name = name;
        this.inventory = new item[15];
        this.inventorySize = 15;
        this.equipInventory = new item.equippable[10];
        this.equipped = new item.equippable[3];
        if(choice == "Knight"){
            this.playerClass = "Knight";
            this.strength = 10;
            this.dex = 8;
            this.hp = 12;
            this.wisdom = 5;
            this.mana = 4;
            inventory[0] = new item.armor("Iron Plate Mail 2","Heavy plate armor",10,100,100,0,0,-2,0,0);
            inventory[1] = new item.armor("Iron Helmet 2", "Good head protection",5,80,100,0,0,-1,0,0);
            this.equipped[0]= new item.armor("Iron Plate Mail","Heavy plate armor",10,100,100,0,0,-2,0,0);
            this.equipped[1] = new item.armor("Iron Helmet", "Good head protection",5,80,100,0,0,-1,0,0);
            this.leftwield = new item.armor("Iron Kite Shield","A favorite of knights",7,80,100,0,0,-1,0,0);
            this.rightwield = new item.weapon("Iron Broadsword","A dull broadsword",5,50,100,0,0,0,0,0);
            this.defence = this.equipped[0].protection + this.equipped[1].protection;
            this.dex += this.rightwield.dexMod;
            this.dex += this.leftwield.dexMod;
            this.dex += this.equipped[0].dexMod;
            this.dex += this.equipped[1].dexMod;
        } else if(choice =="Mage"){
            this.playerClass = "Mage";
            this.strength = 5;
            this.dex = 6;
            this.wisdom = 10;
            this.hp = 5;
            this.mana = 12;
            this.equipped[0] = new item.armor("Simple robes","The cloth robes of a mage",2,30,100,5,0,0,3,0);
            this.equipped[1] = new item.armor("mage hood", "A cloth hood",1,15,100,3,0,0,1,0);
            this.rightwield = new item.weapon("Staff","A wooden staff.",3,10,100,3,0,0,2,0);
            this.wisdom+= this.equipped[0].wisMod;
            this.wisdom+= this.equipped[1].wisMod;
            this.wisdom+= this.rightwield.wisMod;
            this.defence = this.equipped[0].protection + this.equipped[1].protection;
        } else if(choice == "Rouge"){
            this.playerClass = "Rouge";
            this.strength = 7;
            this.dex = 12;
            this.wisdom = 7;
            this.hp = 8;
            this.mana = 2;
            this.equipped[0] = new item.armor("Leather armor", " light armor made of cowhide",5,50,100,0,0,3,0,0);
            this.equipped[1] = new item.armor("Cloak", "A smiple cloth cloak.",0,20,100,0,0,5,0,0);
            this.dex+= this.equipped[0].dexMod;
            this.dex+= this.equipped[1].dexMod;
            this.rightwield = new item.weapon("Dagger","Dull Iron dagger",3,20,100,0,0,2,0,0);
            this.leftwield = new item.weapon("Dagger","Dull Iron dagger",3,20,100,0,0,2,0,0);
            this.dex+= this.rightwield.dexMod;
            this.dex+= this.leftwield.dexMod;
        } else{
            System.out.println("That is not a valid class.");
        }

    }

    public void equip(String item){
        item.equippable subject = getEItemInv(item);
        if(hasItem(subject)==true){
            if (this.equipped[subject.getSlot()]==null && subject.equipSlot!= -1){
                this.equipped[subject.getSlot()] = subject;
            } else {
                unequip(equipped[subject.getSlot()].name);
                this.equipped[subject.getSlot()] = subject;
            }
        } else{
            System.out.println("That Item is not in your inventory.");
        }
    }
    public item.equippable getEItemInv(String item){
        for(int i = 0; i<inventorySize; i++){
            if(inventory[i].name == item && inventory[i].equipSlot!= -1){
                return equipInventory[i];
            }
        }
        return null;
    }
    public void unequip(String item){
        item.equippable subject = getEItemInv(item);
        if(equipped[subject.getSlot()]==subject){
            for(int i=0; i<inventorySize;i++){
                if(inventory[i] ==null){
                    equipInventory[i] = subject;
                    break;
                }
            }
            equipped[subject.getSlot()] = null;
        } else{
            System.out.println("This item is not equipped.");
        }
    }

    public boolean hasItem(item subject){
        for(int i=0;i<this.inventorySize;i++){
            if(this.inventory[i]==subject){
                return true;
            }
        }
        return false;
    }

    public int hitChance(boolean isMagic){
        int hitChance;
        Random rand = new Random();
        int x = rand.nextInt(20)+1;
        if(this.playerClass == "Mage" && isMagic==true){
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
        System.out.println("Your level is: " + this.level);
        System.out.println("Your hp is: " + this.hp);
        System.out.println("Your mana is: " + this.mana);
        System.out.println("Your strength is: " + this.strength);
        System.out.println("Your dexterity is: "+ this.dex);
        System.out.println("Your wisdom is: " + this.wisdom);
    }
    public void levelUp(){
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