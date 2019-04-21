package macbookpro.cs2340.spacetrader;

import org.junit.Test;

import macbookpro.cs2340.spacetrader.model.Universe.Coord;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

public class CoordTest {

    private Coord a = new Coord(10, 15);
    private Coord b = new Coord(10, 15);
    private Coord c = new Coord(15, 10);

    @Test
    public void equalsHashCodeTest() {
        assertTrue("These X coordinates are the same" , a.getX() == b.getX());
        assertTrue("These Y coordinates are the same" , a.getY() == b.getY());
        assertFalse("These X coordinates are not the same" , b.getX() == c.getX());
        assertFalse("These Y coordinates are not the same" , b.getY() == c.getY());

        assertTrue("These coordinates are the same.", a.equals(b));
        assertFalse("These coordinates are not the same.", b.equals(c));

        assertEquals("These coordinates have the same hashcode.", a.hashCode(), b.hashCode());
        assertNotEquals("These coordinates do not have the same hashcode.",
                b.hashCode(), c.hashCode());
    }

    @Test
    public void distanceTest() {
        assertTrue("This method calculates the correct distance.",
                7 == a.calculateDistance(c));
        assertTrue("This method says that the distance is 0 because the coordinates"
                        + " are the same.", 0 == a.calculateDistance(b));
    }
}
