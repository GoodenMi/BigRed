/**
 * Created by Miles on 9/16/2016.
 */
import java.util.Scanner;
public class BigRed {
    public static void main(String[] args) {
        String choice = " ";
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Welcome. Choose the class you would like to be.");
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
        System.out.println("all done.");
    }
    public static void standardLoop(player one){
        String choice = " ";
        while(!choice.equals("quit")) {
            Scanner input = new Scanner(System.in);
            System.out.println("What would you like to do?");
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
            }else {
                System.out.println("That is not a valid choice.");
            }
        }
    }

}
