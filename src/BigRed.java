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
    public static ArrayList<String[]> enemies;
    public static void main(String[] args) {
        weapons = loadItems("weapon.txt");
        armors = loadItems("armor.txt");
        headgears = loadItems("headgear.txt");
        shields = loadItems("shield.txt");
        enemies = loadItems("enemies");
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
                } else if(filename == "enemies"){
                    items.add(itemVals);
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
        System.out.println("Enemy: "+two.name);
        System.out.println("Level: "+ two.level);
        System.out.println(two.description);
        while(playerHp > 0 || enemyHp>0) {
            int playerDamage = (one.damage);
            int enemyDamage = (two.damage);
            int playerAttack = one.hitChance(false) + one.damage;
            int enemyDefence = two.hitChance(false) +two.protection;
            if(playerAttack> enemyDefence) {
                enemyHp -= playerDamage;
                System.out.println(two.name + " was hit for " + playerDamage + " damage.");
                if (enemyHp <= 0) {
                    System.out.println(two.name + " was killed by the player. " + two.expAwarded + "exp and " + two.goldAwarded + " awarded for winning.");
                    System.out.println();
                    one.exp += two.expAwarded;
                    one.gold += two.goldAwarded;
                    System.out.println("Press enter to continue.");
                    input.nextLine();
                    return two.expAwarded;
                }
            } else{
                System.out.println(one.name + " Missed.");
            }
            System.out.println(one.name+ " has " + playerHp +"/"+one.hp+" hp left.");
            System.out.println(two.name+ " has " + enemyHp +"/"+two.hp+" hp left.");
            System.out.println("Press enter to continue;");
            input.nextLine();
            if(one.playerClass.equals("Rogue")) {
                 playerDamage = (one.damage);
                 enemyDamage = (two.damage);
                 playerAttack = one.hitChance(false);
                 enemyDefence = two.hitChance(false) +two.protection;
                if(playerAttack> enemyDefence){
                    enemyHp -= playerDamage;
                    System.out.println(two.name +" was hit for " + playerDamage + " damage.");
                    if(enemyHp <=0){
                        System.out.println(two.name + " was killed by the player. " + two.expAwarded+ "exp gained for winning.");
                        System.out.println();
                        one.exp+=two.expAwarded;
                        one.gold+= two.goldAwarded;
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
            int enemyAttack = two.hitChance(false)+two.damage;
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

    public static void shopLoop(player one) {
        String shopChoice = " ";
        while (!shopChoice.equals("quit")) {
            System.out.println("Welcome to the shop. What items are you looking for? armors, weapons, shields or headgear?");
            System.out.println("(Type the name of the category you want to see and hit enter. Type 'quit' to leave the store.)");
            Scanner input = new Scanner(System.in);
            shopChoice = input.nextLine();
            if (shopChoice.equals("armors")) {
                armorShopLoop(one);
            } else if (shopChoice.equals("weapons")) {
                weaponShopLoop(one);
            } else if (shopChoice.equals("shields")) {
                shieldShopLoop(one);
            } else if (shopChoice.equals("headgear")) {
                headgearShopLoop(one);
            }
        }
    }

    public static void weaponShopLoop(player one){
        Scanner input = new Scanner(System.in);
        boolean lookingA = true;
        while (lookingA == true) {
            System.out.println("These are the weapons we have in stock.");
            for ( item.weapon weapon : weapons) {
                System.out.println(weapon.name);
            }
            System.out.println("Which one would you like to look at?");
            System.out.println("(Type the name of the item you want to inspect.)");
            String armorName = input.nextLine();
            for (item.weapon weapon : weapons) {
                if (armorName.equals(weapon.name)) {
                    weapon.weaponStats();
                    System.out.println();
                    System.out.println("Would you like to buy it?");
                    System.out.println("(Type 'yes' or 'no'.)");
                    String answer = input.nextLine();
                    boolean isBuyingLoop = true;
                    while (isBuyingLoop == true) {
                        if (answer.equals("yes")) {
                            isBuyingLoop = false;
                            if (one.gold >= weapon.value) {
                                one.gold -= weapon.value;
                                boolean wasPut = one.putEItem(weapon);
                                if (wasPut == false) {
                                    one.gold += weapon.value;
                                }
                            } else {
                                System.out.println("Sorry, you don't have enough gold.");
                                System.out.println();
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
            System.out.println("Do you still want to look at weapons?");
            System.out.println("(Type 'yes' or 'no')");
            String isLooking = input.nextLine();
            boolean isLookingLoop = true;
            while (isLookingLoop == true) {
                if (isLooking.equals("yes")) {
                    lookingA = true;
                    isLookingLoop = false;
                } else if (isLooking.equals("no")) {
                    lookingA = false;
                    isLookingLoop = false;
                } else {
                    System.out.println("That is not a valid choice. Try again.");
                }
            }
        }
    }

    public static void shieldShopLoop(player one){
        Scanner input = new Scanner(System.in);
        boolean lookingA = true;
        while (lookingA == true) {
            System.out.println("These are the shields we have in stock.");
            for ( item.shield shield : shields) {
                System.out.println(shield.name);
            }
            System.out.println("Which one would you like to look at?");
            System.out.println("(Type the name of the item you want to inspect.)");
            String armorName = input.nextLine();
            for (item.shield shield : shields) {
                if (armorName.equals(shield.name)) {
                    shield.shieldStats();
                    System.out.println();
                    System.out.println("Would you like to buy it?");
                    System.out.println("(Type 'yes' or 'no'.)");
                    String answer = input.nextLine();
                    boolean isBuyingLoop = true;
                    while (isBuyingLoop == true) {
                        if (answer.equals("yes")) {
                            isBuyingLoop = false;
                            if (one.gold >= shield.value) {
                                one.gold -= shield.value;
                                boolean wasPut = one.putEItem(shield);
                                if (wasPut == false) {
                                    one.gold += shield.value;
                                }
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
            System.out.println("Do you still want to look at Shields?");
            System.out.println("(Type 'yes' or 'no')");
            String isLooking = input.nextLine();
            boolean isLookingLoop = true;
            while (isLookingLoop == true) {
                if (isLooking.equals("yes")) {
                    lookingA = true;
                    isLookingLoop = false;
                } else if (isLooking.equals("no")) {
                    lookingA = false;
                    isLookingLoop = false;
                } else {
                    System.out.println("That is not a valid choice. Try again.");
                }
            }
        }
    }

    public static void headgearShopLoop(player one){
        Scanner input = new Scanner(System.in);
        boolean lookingA = true;
        while (lookingA == true) {
            System.out.println("These are the armors we have in stock.");
            for ( item.headgear headgear : headgears) {
                System.out.println(headgear.name);
            }
            System.out.println("Which one would you like to look at?");
            System.out.println("(Type the name of the item you want to inspect.)");
            String armorName = input.nextLine();
            for (item.headgear headgear : headgears) {
                if (armorName.equals(headgear.name)) {
                    headgear.headgearStats();
                    System.out.println("Would you like to buy it?");
                    System.out.println("(Type 'yes' or 'no'.)");
                    String answer = input.nextLine();
                    boolean isBuyingLoop = true;
                    while (isBuyingLoop == true) {
                        if (answer.equals("yes")) {
                            isBuyingLoop = false;
                            if (one.gold >= headgear.value) {
                                one.gold -= headgear.value;
                                boolean wasPut = one.putEItem(headgear);
                                if (wasPut == false) {
                                    one.gold += headgear.value;
                                }
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
            System.out.println("Do you still want to look at headgear?");
            System.out.println("(Type 'yes' or 'no')");
            String isLooking = input.nextLine();
            boolean isLookingLoop = true;
            while (isLookingLoop == true) {
                if (isLooking.equals("yes")) {
                    lookingA = true;
                    isLookingLoop = false;
                } else if (isLooking.equals("no")) {
                    lookingA = false;
                    isLookingLoop = false;
                } else {
                    System.out.println("That is not a valid choice. Try again.");
                }
            }
        }
    }

    public static void armorShopLoop(player one){
        Scanner input = new Scanner(System.in);
        boolean lookingA = true;
        while (lookingA == true) {
            System.out.println("These are the armors we have in stock.");
            for ( item.armor armor : armors) {
                System.out.println(armor.name);
            }
            System.out.println("Which one would you like to look at?");
            System.out.println("(Type the name of the item you want to inspect.)");
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
                                boolean wasPut = one.putEItem(armor);
                                if (wasPut == false) {
                                    one.gold += armor.value;
                                }
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
            while (isLookingLoop == true) {
                if (isLooking.equals("yes")) {
                    lookingA = true;
                    isLookingLoop = false;
                } else if (isLooking.equals("no")) {
                    lookingA = false;
                    isLookingLoop = false;
                } else {
                    System.out.println("That is not a valid choice. Try again.");
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
                expTillLevelup+=expTillLevelup*one.level;
                tempexp = expTillLevelup* one.level;
            }
            System.out.println("What would you like to do?");
            System.out.println("Type 'equip' to equip and item. Type 'unequip' to unequip an item.");
            System.out.println("Type 'stats' to display your character's statistics.");
            System.out.println("Type 'inventory' to see your equippable items.");
            System.out.println("Type 'battle' to battle.");
            System.out.println("Type 'shop' to go to the shop");
            System.out.println("Type 'quit' to quit the game.");
            String action = input.nextLine();
            if (action.equals("equip")){
                System.out.println("What would you like to equip?");
                choice = input.nextLine();
                one.equip(choice);
                System.out.println("Press enter to continue.");
                input.nextLine();
            } else if(action.equals("unequip")){
                System.out.println("What would you like to unequip.");
                choice = input.nextLine();
                one.unequip(choice);
                System.out.println("Press enter to continue.");
                input.nextLine();
            } else if (action.equals("stats")){
                one.printStats();
                System.out.println("Press enter to continue.");
                input.nextLine();
            }else if(action.equals("quit")) {
                System.out.println("All done! Bye!");
                System.exit(0);
            }else if(action.equals("inventory")) {
                one.printEquipableInv();
                System.out.println("Press enter to continue.");
                input.nextLine();
            }else if(action.equals("battle")){
                System.out.println("What level enemy do you want to fight?");
                System.out.println("You get 20exp and 50 gold per level.");
                int level = input.nextInt();
                int enemyNum = enemies.size();
                Random rand = new Random();
                int enemy = rand.nextInt(enemyNum);
                String[] enemyStats = enemies.get(enemy);
                npc.enemy two = new npc.enemy(enemyStats[0],enemyStats[1],level,Integer.parseInt(enemyStats[2]),Integer.parseInt(enemyStats[3]),Integer.parseInt(enemyStats[4]),Integer.parseInt(enemyStats[5]),Integer.parseInt(enemyStats[6]),Integer.parseInt(enemyStats[7]));
                tempexp -= battleLoop(one,two);
            }else if(action.equals("shop")){
                shopLoop(one);
                System.out.println("Press enter to continue.");
                input.nextLine();
            } else{
                System.out.println("That is not a valid choice.");
                System.out.println("Press enter to continue.");
                input.nextLine();
            }
        }
    }
}

