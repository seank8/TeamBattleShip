import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class ShipBuilderTests {
    
    @Test
    public void testMakeCoordinates(){
        // make a shipbuilder
        ShipBuilder sb = new ShipBuilder();
        // make a coordinate, orientation, and length for ship
        Coordinate c = new Coordinate(3, 4);
        ShipOrientation so = ShipOrientation.VERTICAL;
        int len = 3;

        // variable = shipbuilder.makeCoordinates(coord, orient, length)
        ArrayList<Coordinate> result = sb.addCoords(len, so, c);
        
        // make expected coordinates
        ArrayList<Coordinate> expected = new ArrayList<Coordinate>();
        expected.add(new Coordinate(3, 4));
        expected.add(new Coordinate(4, 4));
        expected.add(new Coordinate(5, 5));

        // verify that method coordinates match expected
        assert(expected, result);
    }
}