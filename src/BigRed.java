/**
 * Created by Miles on 9/16/2016.
 */
import java.util.Scanner;
public class BigRed {
    public static void main(String[] args) {
        String choice;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome. Choose the class you would like to be.");
        System.out.println("Knight. Mage. Rouge");
        choice = input.nextLine();
        System.out.println("What would you like your character's name to be?");
        String name = input.nextLine();
        player one = new player(choice,name);
        standardLoop(one);
    }
    public static void standardLoop(player one){
        String choice2 = " ";
        while(choice2!= "quit") {
            Scanner input = new Scanner(System.in);
            System.out.println("What would you like to do?");
            choice2 = input.nextLine();
            if (choice2 == "equip"){
                System.out.println("What would you like to equip?");
                choice2 = input.nextLine();
                one.equip(choice2);
            } else if(choice2 == "unequip"){
                System.out.println("What would you like to unequip.");
                choice2 = input.nextLine();
                one.unequip(choice2);
            } else{
                System.out.println("That is not a valid choice.");
            }
        }
    }

}
