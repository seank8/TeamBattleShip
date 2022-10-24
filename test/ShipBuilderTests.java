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
        ShipOrientation so = ShipOrientation.HORIZONTAL;
        int len = 3;

        // variable = shipbuilder.makeCoordinates(coord, orient, length)
        ArrayList<Coordinate> result = sb.addCoords(len, so, c);
        
        // make expected coordinates
        ArrayList<Coordinate> expected = new ArrayList<Coordinate>();
        expected.add(new Coordinate(3, 4));
        expected.add(new Coordinate(3, 5));
        expected.add(new Coordinate(3, 6));

        // verify that method coordinates match expected
        for (int i = 0; i < len; i++) {
            Coordinate coordinate = result.get(i);
            int columnR = coordinate.getColumn();
            int rowR = coordinate.getRow();
            
            Coordinate coordinate2 = expected.get(i);
            int columnA = coordinate2.getColumn();
            int rowA = coordinate2.getRow();
            assertEquals(columnA, columnR);
            assertEquals(rowA, rowR);
            
        }
    }
}