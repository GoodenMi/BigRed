/**
 * Created by Miles on 9/16/2016.
 */
import java.lang.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class BigRed {
    public static ArrayList<item.weapon> weapons;
    public static ArrayList<item.armor> armors;
    public static ArrayList<item.headgear> headgears;
    public static ArrayList<item.shield> shields;
    public static void main(String[] args) {
        //commit test
        weapons = loadItems("weapon.txt");
        armors = loadItems("armor.txt");
        headgears = loadItems("headgear.txt");
        shields = loadItems("shield.txt");
        //for(item.weapon weapon:weapons){
          //  weapon.weaponStats();
        //}
        //for(item.armor armor:armors){
          //  armor.armorStats();
        //}
        //for(item.headgear headgear:headgears){
          //  headgear.Stats();
        //}
        //for(item.shield shield: shields){
          //  shield.Stats();
        //}
        String choice = " ";
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome. What class would you like to be? Mage, Rogue, or Knight?");
        while (true){
            System.out.println("(Type the name of the class as it is shown above and hit enter.)");
            choice= input.nextLine();
            if(choice.equals("Knight") ||choice.equals("Mage")||choice.equals("Rouge")){
                break;
            } else{
                System.out.println("That is not a valid class. Try again.");
            }
        }
        System.out.println("What would you like your character's name to be?");
        String name = input.nextLine();
        player one = new player(choice,name);
        standardLoop(one);
    }
    public static ArrayList loadItems(String filename){
        ArrayList<String> txtRes = new ArrayList();
        ArrayList items = new ArrayList();
        String line;
        try {
            Scanner arm = new Scanner(BigRed.class.getResourceAsStream(filename));
            while(arm.hasNextLine()){
                line = arm.nextLine();
                txtRes.add(line);
            }
            for(String txtline:txtRes) {
                int count = 0;
                String[] itemVals = new String[8];
                for (String value : txtline.split(",")) {
                    itemVals[count] = value;
                    count++;
                }
                if (filename == "armor.txt") {
                    item.armor armor = new item.armor(itemVals[0], itemVals[1], Integer.parseInt(itemVals[2]), Integer.parseInt(itemVals[3]),
                            Integer.parseInt(itemVals[4]), Integer.parseInt(itemVals[5]), Integer.parseInt(itemVals[6]), Integer.parseInt(itemVals[7]));
                    items.add(armor);
                } else if (filename == "weapon.txt") {
                    item.weapon weapon = new item.weapon(itemVals[0], itemVals[1], Integer.parseInt(itemVals[2]), Integer.parseInt(itemVals[3]),
                            Integer.parseInt(itemVals[4]), Integer.parseInt(itemVals[5]), Integer.parseInt(itemVals[6]), Integer.parseInt(itemVals[7]));
                    items.add(weapon);
                } else if (filename == "headgear.txt") {
                    item.headgear headgear = new item.headgear(itemVals[0], itemVals[1], Integer.parseInt(itemVals[2]), Integer.parseInt(itemVals[3]),
                            Integer.parseInt(itemVals[4]), Integer.parseInt(itemVals[5]), Integer.parseInt(itemVals[6]), Integer.parseInt(itemVals[7]));
                    items.add(headgear);
                } else if (filename == "shield.txt") {
                    item.shield shield = new item.shield(itemVals[0], itemVals[1], Integer.parseInt(itemVals[2]), Integer.parseInt(itemVals[3]),
                            Integer.parseInt(itemVals[4]), Integer.parseInt(itemVals[5]), Integer.parseInt(itemVals[6]), Integer.parseInt(itemVals[7]));
                    items.add(shield);
                }
            }
        } catch (Exception e){}
        return items;
    }

    public static int battleLoop(player one, npc.enemy two){
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int playerHp = one.hp;
        int enemyHp = two.hp;
        System.out.println("Enemy level: "+ two.level);
        while(playerHp > 0 || enemyHp>0) {
            int playerDamage = (one.damage+(one.strength/2))/(rand.nextInt(3)+1);
            int enemyDamage = (two.damage+ (two.strength/2))/(rand.nextInt(3)+1);
            int playerAttack = one.hitChance(false);
            int enemyDefence = two.hitChance(false) +two.protection;
            if(playerAttack> enemyDefence){
                enemyHp -= playerDamage;
                System.out.println(two.name +" was hit for " + playerDamage + " damage.");
                if(enemyHp <=0){
                    System.out.println(two.name + " was killed by the player. " + two.expAwarded+ "exp gained for winning.");
                    System.out.println();
                    one.exp+=two.expAwarded;
                    return two.expAwarded;
                }
                System.out.println(one.name+ " has " + playerHp +"/"+one.hp+" hp left.");
                System.out.println(two.name+ " has " + enemyHp +"/"+two.hp+" hp left.");
                System.out.println("Press enter to continue;");
                input.nextLine();
            }
            if(one.playerClass.equals("Rogue")) {
                if(one.playerClass.equals("Mage")){
                    playerDamage = (one.damage+(one.strength/2))/(rand.nextInt(5)+1)+(one.mana/2);
                }else {
                    playerDamage = (one.damage + (one.strength / 2))/(rand.nextInt(3) + 1);
                }
                 enemyDamage = (two.damage+ (two.strength/2))/(rand.nextInt(3)+1);
                 playerAttack = one.hitChance(false);
                 enemyDefence = two.hitChance(false) +two.protection;
                if(playerAttack> enemyDefence){
                    enemyHp -= playerDamage;
                    System.out.println(two.name +" was hit for " + playerDamage + " damage.");
                    if(enemyHp <=0){
                        System.out.println(two.name + " was killed by the player. " + two.expAwarded+ "exp gained for winning.");
                        System.out.println();
                        one.exp+=two.expAwarded;
                        return two.expAwarded;
                    }
                    System.out.println(one.name+ " has " + playerHp +"/"+one.hp+" hp left.");
                    System.out.println(two.name+ " has " + enemyHp +"/"+two.hp+" hp left.");
                    System.out.println("Press enter to continue;");
                    input.nextLine();

            }

                System.out.println(one.name+ " missed.");
                System.out.println(one.name+ " has " + playerHp +"/"+one.hp+" hp left.");
                System.out.println(two.name+ " has " + enemyHp +"/"+two.hp+" hp left.");
                System.out.println("Press enter to continue.");
                input.nextLine();
            }
            int enemyAttack = two.hitChance(false);
            int playerDefence;
            if(one.playerClass.equals("Mage")) {
                playerDefence = (one.hitChance(false) + one.defence)/3;
            }else {
                playerDefence = one.hitChance(false) + one.defence;
            }
            if(enemyAttack> playerDefence){
                playerHp-=enemyDamage;
                System.out.println(one.name+ " was hit for " + enemyDamage + " damage.");
                if(playerHp <=0){
                    System.out.println(one.name + " was killed by "+two.name);
                    break;
                }
                System.out.println(one.name+ " has " + playerHp +"/"+one.hp+" hp left.");
                System.out.println(two.name+ " has " + enemyHp +"/"+two.hp+" hp left.");
                System.out.println("Press enter to continue;");
                input.nextLine();
            }else{
                System.out.println(two.name+ " missed.");
                System.out.println(one.name+ " has " + playerHp +"/"+one.hp+" hp left.");
                System.out.println(two.name+ " has " + enemyHp +"/"+two.hp+" hp left.");
                System.out.println("Press enter to continue;");
                input.nextLine();
            }

        }
        return 0;

    }

    public static void shopLoop(player one){
        System.out.println("Welcome to the shop. What items are you looking for?");
        System.out.println("Type 1 for armor. 2 for weapons. 3 for headgear. 4 for shields.");
        Scanner input = new Scanner(System.in);
        int shopChoice = input.nextInt();
        if(shopChoice == 1) {
            boolean looking = true;
            while (looking ==true) {
                System.out.println("These are the armors we have in stock.");
                for (item.armor armor : armors) {
                    System.out.println(armor.name);
                }
                System.out.println("Which one would you like to look at?");
                System.out.println("(Type the name of the armor you want to inspect.)");
                String armorName = input.nextLine();
                for (item.armor armor : armors) {
                    if (armorName.equals(armor.name)) {
                        armor.armorStats();
                        System.out.println("Would you like to buy it?");
                        System.out.println("(Type 'yes' or 'no'.)");
                        String answer = input.nextLine();
                        boolean isBuyingLoop = true;
                        while (isBuyingLoop == true) {
                            if (answer.equals("yes")) {
                                isBuyingLoop = false;
                                if (one.gold >= armor.value) {
                                    one.gold -= armor.value;
                                    one.putEItem(armor);
                                } else {
                                    System.out.println("Sorry, you don't have enough gold.");
                                }
                            } else if (answer.equals("no")) {
                                System.out.println("No problem!");
                                isBuyingLoop = false;
                            } else {
                                System.out.println("That's not a valid answer. Try again.");
                                answer = input.nextLine();
                            }
                        }
                    }
                }
                System.out.println("Do you still want to look at armor?");
                System.out.println("(Type 'yes' or 'no')");
                String isLooking = input.nextLine();
                boolean isLookingLoop = true;
                while(isLookingLoop == true) {
                    if (isLooking.equals("yes")) {
                        looking = true;
                        isLookingLoop = false;
                    } else if (isLooking.equals("no")) {
                        looking = false;
                        isLookingLoop = false;
                    } else {
                        System.out.println("That is not a valid choice. Try again.");
                    }
                }
            }
        }
    }

    public static void standardLoop(player one){
        String choice = " ";
        int expTillLevelup = 100;
        int tempexp = 100;
        while(!choice.equals("quit")) {
            Scanner input = new Scanner(System.in);
            if(tempexp <=0){
                one.levelUp();
                tempexp = expTillLevelup* one.level;
            }
            System.out.println("What would you like to do?");
            System.out.println("Type 1 to equip and item. Type 2 to unequip an item.");
            System.out.println("Type 3 to display your character's statistics.");
            System.out.println("Type 4 to see your equippable items.");
            System.out.println("Type 5 to battle.");
            System.out.println("Type 6 to go to the shop");
            System.out.println("Type 0 to quit the game.");
            int actNum = input.nextInt();
            if (actNum == 1){
                System.out.println("What would you like to equip?");
                choice = input.nextLine();
                one.equip(choice);
            } else if(actNum ==2){
                System.out.println("What would you like to unequip.");
                choice = input.nextLine();
                one.unequip(choice);
            } else if (actNum==3){
                one.printStats();
            }else if(actNum==0) {
                System.out.println("All done! Bye!");
                System.exit(0);
            }else if(actNum==4) {
                one.printEquipableInv();
            }else if(actNum==5){
                System.out.println("What level enemy do you want to fight?");
                int opponent = input.nextInt();
                npc.enemy two = new npc.enemy.knight("Knight", opponent, 20, one);
                tempexp -= battleLoop(one,two);
            }else if(actNum ==6){
                shopLoop(one);
            } else{
                System.out.println("That is not a valid choice.");
            }
        }
    }
}

