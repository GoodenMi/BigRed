import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Connor on 9/17/2016.
 */
public class town {

    private static final List<String> TOWN_NAMES = new ArrayList<>();

    private String name;
    private String description;
    // String is name of town, Integer is distance to town
    private List<Road> neighbors;
    private Map<String, pointofinterest> pointsOfInterest;
    private pointofinterest frontGate;

    public town() {
        Random ran = new Random();
        this.name = TOWN_NAMES.remove(ran.nextInt(TOWN_NAMES.size()));
        // generate description
        String desc = "";
        this.neighbors = new ArrayList<>();

    }

    public void initTown() {
        try {
            Scanner sc = new Scanner(new File("resources/town_names.txt"));
            String town_name;
            while (sc.hasNextLine()) {
                town_name = sc.nextLine().trim();
                TOWN_NAMES.add(town_name);
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println("The file town_names.txt is not found in the resources folder.");
        }
    }

    /** GETTERS */

    public pointofinterest getFrontGate() {
        return this.frontGate;
    }

    public List<Road> getNeighbors() {
        return this.neighbors;
    }

    public String getName() {
        return this.name;
    }

    public Map<String, pointofinterest> getPointsOfInterest() {
        return this.pointsOfInterest;
    }


}
