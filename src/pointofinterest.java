import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Connor on 9/17/2016.
 */
public abstract class pointofinterest {

    private static final List<String> SHOP_NAMES = new ArrayList<>();
    private static final List<String> TAVERN_NAMES = new ArrayList<>();
    private static final List<String> TEMPLE_NAMES = new ArrayList<>();
    private static final List<String> ARENA_NAMES = new ArrayList<>();

    protected String name;
    protected String description;
    protected List<pointofinterest> neighbors;
    protected List<npc> npcs;
    protected List<item> items;

    public pointofinterest() {
        if (SHOP_NAMES.size() == 0) {
            initPointOfInterest();
        }
        this.neighbors = new ArrayList<>();
        this.npcs = new ArrayList<>();
        // generate npcs
        this.items = new ArrayList<>();
        // generate npcs
    }

    /**
     * Initializes static final Lists of names
     */
    public void initPointOfInterest() {
        try {
            Scanner sc = new Scanner(new File("resources/POI_names.txt"));
            String poi_name;
            int counter = 0; // counts where we are regarding different POI's
            while (sc.hasNextLine()) {
                poi_name = sc.nextLine().trim();
                switch (counter) {
                    case 0: // shop names
                        if (poi_name.equals("Shop End")) {
                            counter++;
                        } else {
                            SHOP_NAMES.add(poi_name);
                        }
                    case 1:
                        if (poi_name.equals("Tavern End")) {
                            counter++;
                        } else {
                            TAVERN_NAMES.add(poi_name);
                        }
                    case 2:
                        if (poi_name.equals("Temple End")) {
                            counter++;
                        } else {
                            TEMPLE_NAMES.add(poi_name);
                        }
                    case 3:
                        if (poi_name.equals("Arena End")) {
                            counter++;
                        } else {
                            ARENA_NAMES.add(poi_name);
                        }
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println("The file POI_names.txt is not found in the resources folder.");
        }
    }

    /** GETTERS */

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public List<pointofinterest> getNeighbors() {
        return this.neighbors;
    }

    public List<item> getItems() { return this.items; }

    public List<npc> getNpcs() { return this.npcs; }

    /** Child classes */

    public class Shop extends pointofinterest { //TODO

        public Shop() {
            super();
            Random ran = new Random();
            this.name = SHOP_NAMES.get(ran.nextInt(SHOP_NAMES.size()));
            //this.npcs.add(new npc.Shopkeeper());
            //this.description
        }
    }

    public class Tavern extends pointofinterest { //TODO

    }

    public class Temple extends pointofinterest { //TODO

    }

    public class Arena extends pointofinterest { //TODO


    }
}


