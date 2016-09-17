import java.util.List;
import java.util.Map;

/**
 * Created by Connor on 9/17/2016.
 */
public class town {

    private String name;
    // String is name of town, Integer is distance to town
    private Map<String, Integer> neighbors;
    private Map<String, pointofinterest> pointsOfInterest;
    private pointofinterest frontGate;

    public town() {

    }

    /** GETTERS */

    public pointofinterest getFrontGate() {
        return this.frontGate;
    }

    public Map<String, Integer> getNeighbors() {
        return this.neighbors;
    }

    public String getName() {
        return this.name;
    }

    public Map<String, pointofinterest> getPointsOfInterest() {
        return this.pointsOfInterest;
    }


}
