import java.util.HashMap;
import java.util.Map;

/**
 * Created by Connor on 9/17/2016.
 */
public class world {

    private Map<String, town> world;

    /**
     * Constructor. Creates the start town and initializes the graph representation of the world.
     */
    public world() {
        town startTown = new town();
        this.world = new HashMap<String, town>();
        this.world.put(startTown.getName(), startTown);
    }

}
