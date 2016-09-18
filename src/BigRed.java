/**
 * Created by Miles on 9/16/2016.
 */
import java.util.Scanner;
public class BigRed {
    public static void main(String[] args) {
        String choice = " ";
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Welcome. Type the name of the class you would like to be.");
            System.out.println("Knight. Mage. Rouge");
            choice = input.nextLine();
            if(choice.equals("Knight")){
                break;
            } else if(choice.equals("Mage")){
                break;
            } else if(choice.equals("Rouge")) {
                break;
            } else{
                System.out.println("That is not a valid Class.");
            }
        }
        System.out.println("What would you like your character's name to be?");
        String name = input.nextLine();
        player one = new player(choice,name);
        standardLoop(one);
    }

    public static void battleLoop(player one, npc.enemy.goblin two){
        while(one.hp > 0 || two.hp>0) {
            int playerAttack = one.hitChance(false);
            int enemyDefence = two.hitChance(false);
            if()
        }

    }

    public static void standardLoop(player one){
        String choice = " ";
        while(!choice.equals("quit")) {
            Scanner input = new Scanner(System.in);
            System.out.println("What would you like to do?");
            System.out.println("Type 'equip' to equip and item. Type 'unequip' to unequip an item.");
            System.out.println("Type 'stats' to display your character's statistics.");
            System.out.println("Type 'einv' to see your equippable items.");
            System.out.println("Type 'move' to enter move mode.");
            System.out.println("Type 'quit' to quit the game.");
            System.out.println("Type 'fight' to fight a battle");
            choice = input.nextLine();
            if (choice.equals("equip")){
                System.out.println("What would you like to equip?");
                choice = input.nextLine();
                one.equip(choice);
            } else if(choice.equals("unequip")){
                System.out.println("What would you like to unequip.");
                choice = input.nextLine();
                one.unequip(choice);
            } else if (choice.equals("stats")){
                one.printStats();
            }else if(choice.equals("quit")) {
                System.out.println("All done! Bye!");
                System.exit(0);
            }else if(choice.equals("einv")) {
                one.printEquipableInv();
            } else if(choice.equals("fight")){
                npc.goblin two = new npc.goblin("first", "short green. angry", 0,30,one);
                battleLoop(one,two);
            }else{
                System.out.println("That is not a valid choice.");
            }
        }
    }

}
