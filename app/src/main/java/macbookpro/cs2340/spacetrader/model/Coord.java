package macbookpro.cs2340.spacetrader.model;

public class Coord {

    private int x;
    private int y;

    public Coord(int xcoord, int ycoord) {
        x = xcoord;
        y = ycoord;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) { return true; }
        if (!(o instanceof Coord)) { return false; }
        Coord c = (Coord) o;
        return c.x == this.x && c.y == this.y;
    }

}
