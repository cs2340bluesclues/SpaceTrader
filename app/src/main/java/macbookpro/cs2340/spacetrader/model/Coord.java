package macbookpro.cs2340.spacetrader.model;

public class Coord {

    private int x;
    private int y;

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    public boolean equals() {
        return false;
    }

}
