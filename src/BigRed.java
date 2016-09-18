/**
 * Created by Miles on 9/16/2016.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class BigRed {
    public static void main(String[] args) {
        initWeapon();
        initArmor();
        initShield();
        initHeadGear();
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
        one.putEItem(getRandomArmor(one));
        standardLoop(one);
    }

    public static int battleLoop(player one, npc.enemy.goblin two){
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
            }else{
                System.out.println(one.name+ " missed.");
                System.out.println(one.name+ " has " + playerHp +"/"+one.hp+" hp left.");
                System.out.println(two.name+ " has " + enemyHp +"/"+two.hp+" hp left.");
                System.out.println("Press enter to continue.");
                input.nextLine();
            }
            int enemyAttack = two.hitChance(false);
            int playerDefence = one.hitChance(false) + one.defence;
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
                npc.enemy.goblin two = new npc.enemy.goblin("test goblin ", "short green. angry", 0,30,one);
                tempexp -= battleLoop(one,two);

            }else{
                System.out.println("That is not a valid choice.");
            }
        }
    }
    public static List<item.weapon> WEAPON_TIER_0 = new ArrayList<>();
    public static List<item.weapon> WEAPON_TIER_1 = new ArrayList<>();
    public static List<item.weapon> WEAPON_TIER_2 = new ArrayList<>();
    public static List<item.weapon> WEAPON_TIER_3 = new ArrayList<>();
    public static List<item.weapon> WEAPON_TIER_4 = new ArrayList<>();
    public static List<item.weapon> WEAPON_TIER_5 = new ArrayList<>();

    public item.weapon getRandomWeapon(player player) {
        Random ran = new Random();
        item.weapon hg;
        switch (player.level/10) {
            case 0:
                hg = WEAPON_TIER_0.get(ran.nextInt(WEAPON_TIER_0.size()));
                break;
            case 1:
                hg = WEAPON_TIER_1.get(ran.nextInt(WEAPON_TIER_1.size()));
                break;
            case 2:
                hg = WEAPON_TIER_2.get(ran.nextInt(WEAPON_TIER_2.size()));
                break;
            case 3:
                hg = WEAPON_TIER_3.get(ran.nextInt(WEAPON_TIER_3.size()));
                break;
            case 4:
                hg = WEAPON_TIER_4.get(ran.nextInt(WEAPON_TIER_4.size()));
                break;
            case 5: case 6:
                hg = WEAPON_TIER_5.get(ran.nextInt(WEAPON_TIER_5.size()));
                break;
            default:
                hg = WEAPON_TIER_0.get(ran.nextInt(WEAPON_TIER_0.size()));
        }
        return hg;
    }
    public static void initWeapon() {
        try {
            Scanner sc = new Scanner(new File("src/weapon.txt"));
            String weaponName;
            int tierCounter = 0;
            while (sc.hasNextLine()) {
                weaponName = sc.nextLine().trim();
                if (weaponName.equals("Tier")) {
                    tierCounter++;
                } else {
                    switch (tierCounter) {
                        case 0:
                            WEAPON_TIER_0.add(new item.weapon(weaponName.split(",")));
                            break;
                        case 1:
                            WEAPON_TIER_1.add(new item.weapon(weaponName.split(",")));
                            break;
                        case 2:
                            WEAPON_TIER_2.add(new item.weapon(weaponName.split(",")));
                            break;
                        case 3:
                            WEAPON_TIER_3.add(new item.weapon(weaponName.split(",")));
                            break;
                        case 4:
                            WEAPON_TIER_4.add(new item.weapon(weaponName.split(",")));
                            break;
                        case 5:
                            WEAPON_TIER_5.add(new item.weapon(weaponName.split(",")));
                            break;
                    }
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println("The file armor.txt.txt is not found in the src folder.");
        }
    }
    public static void initArmor() {
        try {
            Scanner sc = new Scanner(new File("src/headgear.txt"));
            String armorName;
            int tierCounter = 0;
            while (sc.hasNextLine()) {
                armorName = sc.nextLine().trim();
                if (armorName.equals("Tier")) {
                    tierCounter++;
                } else {
                    switch (tierCounter) {
                        case 0:
                            ARMOR_TIER_0.add(new item.armor(armorName.split(",")));
                            break;
                        case 1:
                            ARMOR_TIER_1.add(new item.armor(armorName.split(",")));
                            break;
                        case 2:
                            ARMOR_TIER_2.add(new item.armor(armorName.split(",")));
                            break;
                        case 3:
                            ARMOR_TIER_3.add(new item.armor(armorName.split(",")));
                            break;
                        case 4:
                            ARMOR_TIER_4.add(new item.armor(armorName.split(",")));
                            break;
                        case 5:
                            ARMOR_TIER_5.add(new item.armor(armorName.split(",")));
                            break;
                    }
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println("The file armor.txt.txt is not found in the src folder.");
        }
    }

    private static final List<item.armor> ARMOR_TIER_0 = new ArrayList<>();
    private static final List<item.armor> ARMOR_TIER_1 = new ArrayList<>();
    private static final List<item.armor> ARMOR_TIER_2 = new ArrayList<>();
    private static final List<item.armor> ARMOR_TIER_3 = new ArrayList<>();
    private static final List<item.armor> ARMOR_TIER_4 = new ArrayList<>();
    private static final List<item.armor> ARMOR_TIER_5 = new ArrayList<>();

    public static item.armor getRandomArmor(player player) {
        Random ran = new Random();
        item.armor hg;
        switch (player.level/10) {
            case 0:
                hg = ARMOR_TIER_0.get(ran.nextInt(ARMOR_TIER_0.size()));
                break;
            case 1:
                hg = ARMOR_TIER_1.get(ran.nextInt(ARMOR_TIER_1.size()));
                break;
            case 2:
                hg = ARMOR_TIER_2.get(ran.nextInt(ARMOR_TIER_2.size()));
                break;
            case 3:
                hg = ARMOR_TIER_3.get(ran.nextInt(ARMOR_TIER_3.size()));
                break;
            case 4:
                hg = ARMOR_TIER_4.get(ran.nextInt(ARMOR_TIER_4.size()));
                break;
            case 5: case 6:
                hg = ARMOR_TIER_5.get(ran.nextInt(ARMOR_TIER_5.size()));
                break;
            default:
                hg = ARMOR_TIER_0.get(ran.nextInt(ARMOR_TIER_0.size()));
        }
        return hg;
    }
    private static final List<item.headgear> HEADGEAR_TIER_0 = new ArrayList<>();
    private static final List<item.headgear> HEADGEAR_TIER_1 = new ArrayList<>();
    private static final List<item.headgear> HEADGEAR_TIER_2 = new ArrayList<>();
    private static final List<item.headgear> HEADGEAR_TIER_3 = new ArrayList<>();
    private static final List<item.headgear> HEADGEAR_TIER_4 = new ArrayList<>();
    private static final List<item.headgear> HEADGEAR_TIER_5 = new ArrayList<>();

    public static void initHeadGear() {
        try {
            Scanner sc = new Scanner(new File("src/headgear.txt"));
            String headgearName;
            int tierCounter = 0;
            while (sc.hasNextLine()) {
                headgearName = sc.nextLine().trim();
                if (headgearName.equals("Tier")) {
                    tierCounter++;
                } else {
                    switch (tierCounter) {
                        case 0:
                            HEADGEAR_TIER_0.add(new item.headgear(headgearName.split(",")));
                            break;
                        case 1:
                            HEADGEAR_TIER_1.add(new item.headgear(headgearName.split(",")));
                            break;
                        case 2:
                            HEADGEAR_TIER_2.add(new item.headgear(headgearName.split(",")));
                            break;
                        case 3:
                            HEADGEAR_TIER_3.add(new item.headgear(headgearName.split(",")));
                            break;
                        case 4:
                            HEADGEAR_TIER_4.add(new item.headgear(headgearName.split(",")));
                            break;
                        case 5:
                            HEADGEAR_TIER_5.add(new item.headgear(headgearName.split(",")));
                            break;
                    }
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println("The file headgear.txt.txt is not found in the src folder.");
        }
    }

    public static item.headgear getRandomHeadGear(player player) {
        Random ran = new Random();
        item.headgear hg;
        switch (player.level/10) {
            case 0:
                hg = HEADGEAR_TIER_0.get(ran.nextInt(HEADGEAR_TIER_0.size()));
                break;
            case 1:
                hg = HEADGEAR_TIER_1.get(ran.nextInt(HEADGEAR_TIER_1.size()));
                break;
            case 2:
                hg = HEADGEAR_TIER_2.get(ran.nextInt(HEADGEAR_TIER_2.size()));
                break;
            case 3:
                hg = HEADGEAR_TIER_3.get(ran.nextInt(HEADGEAR_TIER_3.size()));
                break;
            case 4:
                hg = HEADGEAR_TIER_4.get(ran.nextInt(HEADGEAR_TIER_4.size()));
                break;
            case 5: case 6:
                hg = HEADGEAR_TIER_5.get(ran.nextInt(HEADGEAR_TIER_5.size()));
                break;
            default:
                hg = HEADGEAR_TIER_0.get(ran.nextInt(HEADGEAR_TIER_0.size()));
        }
        return hg;
    }


}

