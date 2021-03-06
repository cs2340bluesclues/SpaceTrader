package macbookpro.cs2340.spacetrader.model.Universe;

/**
 * Coordinate class for the location of solar systems
 */
public class Coord {

    private final int x;
    private final int y;

    /**
     * Constructor for Coord object. Sets x and y coordinates
     * @param xcoord location on x-axis
     * @param ycoord location on y-axis
     */
    public Coord(int xcoord, int ycoord) {
        x = xcoord;
        y = ycoord;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = (31 * result) + y;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) { return true; }
        if (!(o instanceof Coord)) { return false; }
        Coord c = (Coord) o;
        return (c.x == this.x) && (c.y == this.y);
    }

    @Override
    public String toString() {
        return "(" + x +
                ", " + y +
                ")";
    }

    /**
     * Calculates the distance between this coord and another
     * @param c The coord to compare this one to
     * @return The distance between the coords as an int
     */
    public int calculateDistance(Coord c) {
        return (int) Math.sqrt(Math.pow(this.getX() - c.getX(), 2)
                + Math.pow(this.getY() - c.getY(), 2));
    }

    /**
     * Getter for x axis location
     * @return integer on x-axis
     */
    public int getX() {
        return x;
    }

    /**
     * getter for y axis location
     * @return integer on y-axis
     */
    public int getY() {
        return y;
    }
}
