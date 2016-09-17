/**
 * Created by Miles on 9/17/2016.
 */
import java.util.Scanner;

public class player{
    int level;
    int dex;
    int strength;
    int wisdom;
    int hp;
    int mana;
    item[] inventory;
    String playerClass;
    String name;
    public player(int choice, String name){
        this.level = 1;
        this.name = name;
        this.inventory = new item[15];
        if(choice == 1){
            this.playerClass = "Knight";
            this.strength = 10;
            this.dex = 8;
            this.hp = 12;
            this.wisdom = 5;
            this.mana = 4;
        } else if(choice ==2){
            this.playerClass = "Mage";
            this.strength = 5;
            this.dex = 6;
            this.wisdom = 10;
            this.hp = 5;
            this.mana = 12;
        } else if(choice == 3){
            this.playerClass = "Rouge";
            this.strength = 7;
            this.dex = 12;
            this.wisdom = 7;
            this.hp = 8;
            this.mana = 2;
        }

    }
    public int getLevel(player one){
        return one.level;
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
                points--
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