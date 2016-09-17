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
    attacks[] attackList;
    item[] inventory;
    item.armor[] equipped;
    item rightwield;
    item leftwield;
    String playerClass;
    String name;
    public player(int choice, String name){
        this.level = 1;
        this.name = name;
        this.inventory = new item[15];
        this.equipped = new item.armor[3];
        if(choice == 1){
            this.playerClass = "Knight";
            this.strength = 10;
            this.dex = 8;
            this.hp = 12;
            this.wisdom = 5;
            this.mana = 4;
            this.equipped[0]= new item.armor("Iron Plate Mail","Heavy plate armor",10,100,100,0,0,-2,0,0);
            this.equipped[1] = new item.armor("Iron Helemt", "Good head protection",5,80,100,0,0,-1,0,0);
            this.leftwield = new item.armor("Iron Kite Shield","A favorite of kinghts",7,80,100,0,0,-1,0,0);
            this.rightwield = new item.weapon("Iron Broadsword","A dull broadsword",5,50,100,0,0,0,0,0);
            this.defence = this.equipped[0].getProtection() + this.equipped[1].getProtection();
        } else if(choice ==2){
            this.playerClass = "Mage";
            this.strength = 5;
            this.dex = 6;
            this.wisdom = 10;
            this.hp = 5;
            this.mana = 12;
            this.equipped[0] = new item.armor("Simple robes","The cloth robes of a mage",2,30,100,5,0,0,3,0);
            this.equipped[1] = new item.armor("mage hood", "A cloth hood",1,15,100,3,0,0,1,0);
            this.rightwield = new item.weapon("Staff","A wooden staff.",3,10,100,3,0,0,2,0);
        } else if(choice == 3){
            this.playerClass = "Rouge";
            this.strength = 7;
            this.dex = 12;
            this.wisdom = 7;
            this.hp = 8;
            this.mana = 2;
            this.equipped[0] = new item.armor("Leather armor", " light armor made of cowhide",5,50,100,0,0,3,0,0);
            this.equipped[1] = new item.armor("Cloak", "A smiple cloth cloak.",0,20,100,0,0,5,0,0);
            this.rightwield = new item.weapon("Dagger","Dull Iron dagger",3,20,100,0,0,2,0,0);
        }

    }
    public int attack(){
        Random rand = new Random();
        int x = rand.nextInt(20)+1;
        int hitChance = this.dex * x;
        return hitChance;
    }
    public int getLevel(){
        return this.level;
    }

    public void printStats(player one){
        System.out.println("Your level is: " + one.level);
        System.out.println("Your hp is: " + one.hp);
        System.out.println("Your mana is: " + one.mana);
        System.out.println("Your strength is: " + one.strength);
        System.out.println("Your dexterity is: "+ one.dex);
        System.out.println("Your wisdom is: " + one.wisdom);
    }
    public void levelUp(player one){
        Scanner input = new Scanner(System.in);
        System.out.println("Congratulations! You have leveled up! You have 5 skill points to use. " +
                "Where would you like to use them?");
        int points = 5;
        while (points!= 0) {
            System.out.println("1.Strength 2.Dexterity 3.Wisdom 4.hp 5.mana");
            int choice = input.nextInt();
            if(choice == 1){
                one.strength++;
                points--;
            } else if(choice == 2){
                one.dex++;
                points--;
            } else if(choice == 3){
                one.wisdom++;
                points--;
            } else if(choice == 4){
                one.hp++;
                points--;
            } else if(choice == 5){
                one.mana++;
                points--;
            } else{
                System.out.println("That is not a valid input. Try again.");
            }
        }
    }

}