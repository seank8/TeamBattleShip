import java.util.ArrayList;
import java.util.Random;

public class ShipBuilder{
    private ArrayList<Ship> ships = new ArrayList<Ship>();
    private OceanGrid ocean;
    private Random rand = new Random();
    private Coordinate origin;

    public ShipBuilder(OceanGrid ocean){
        //repeat making of ship 5 times(1 for each ship)
        for (ShipType name : ShipType.values()){
            ArrayList<Coordinate> coordinates = addCoords(name.getLength(), ShipOrientation.randomOrientation());
            Ship ship = new Ship(name, name.getLength(), coordinates);
            ships.add(ship);
        }

    }

    public ArrayList<Coordinate> addCoords(int length, ShipOrientation orientation){
        ArrayList<Coordinate> shipCoords = new ArrayList<Coordinate>();
        if (orientation == ShipOrientation.HORIZONTAL){
            origin = new Coordinate(rand.nextInt(9), rand.nextInt(9 - length));
        } else{
            origin = new Coordinate(rand.nextInt(9 - length), rand.nextInt(9));
        }
        





        return shipCoords;

        
    }

    
}