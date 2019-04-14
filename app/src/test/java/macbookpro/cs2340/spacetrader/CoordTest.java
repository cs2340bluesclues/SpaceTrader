package macbookpro.cs2340.spacetrader;

import org.junit.Test;

import macbookpro.cs2340.spacetrader.model.Universe.Coord;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

public class CoordTest {

    Coord a = new Coord(10, 15);
    Coord b = new Coord(10, 15);
    Coord c = new Coord(15, 10);

    @Test
    public void equalsHashCodeTest() {
        assertTrue("These coordinates are the same.", a.equals(b));
        assertFalse("These coordinates are not the same.", b.equals(c));
        assertEquals("These coordinates have the same hashcode.", a.hashCode(), b.hashCode());
        assertNotEquals("These coordinates do not have the same hashcode.", b.hashCode(), c.hashCode());
    }

    @Test
    public void distanceTest() {
        assertEquals("This method calculates the correct distance.", 7, a.calculateDistance(c));
        assertEquals("This method says that the distance is 0 because the coordinates are the same.", 0, a.calculateDistance(b));
    }
}
