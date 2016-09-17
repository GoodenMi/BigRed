import java.util.ArrayList;
import java.util.List;

/**
 * Created by Connor on 9/17/2016.
 */
public class pointofinterest {

    private String name;
    private List<pointofinterest> neighbors;
    private tile[][] tiles;

    public pointofinterest(String name, int tilesX, int tilesY) {
        this.name = name;
        this.neighbors = new ArrayList<>();
        tile[][] area = new tile[tilesX][tilesY];
        for (int i = 0; i < tilesX; i++) {
            for (int j = 0; j < tilesY; j++) {
                //area[i][j] = new tile();
            }
        }
    }

    /** GETTERS */

    public String getName() {
        return this.name;
    }

    public List<pointofinterest> getNeighbors() {
        return this.neighbors;
    }

    public tile[][] getTiles() {
        return this.tiles;
    }

}
