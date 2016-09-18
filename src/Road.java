/**
 * Defines roads between towns. Used in weighted graph
 */
public class Road {

    private town toTown;
    private town fromTown;
    private int distance;

    public Road(town to, town from, int distance ) {
        this.toTown = to;
        this.fromTown = from;
        this.distance = distance;
    }

    public town getToTown() {
        return this.toTown;
    }

    public town getFromTown() { return this.fromTown; }

    public int getDistance() { return this.distance; }
}
