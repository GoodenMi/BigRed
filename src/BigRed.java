/**
 * Created by Miles on 9/16/2016.
 */
import java.util.Scanner;
public class BigRed {
    public static void main(String[] args) {
        int choice;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome. Choose the number for what class you would like to be.");
        System.out.println("1.Knight. 2.Mage. 3.Rouge");
        choice = input.nextInt();
        if(choice >3||choice<1){
            while(choice>3||choice<1){
                System.out.println("That is not a valid choice. Choose again.");
                choice = input.nextInt();
            }
        }
        System.out.println("What would you like your character's name to be?");
        String name = input.nextLine();
        player one = new player(choice,name);
    }
    public player battleLoop(){}

    public void standardLoop(){}

}
