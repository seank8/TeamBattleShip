import java.util.ArrayList;

public class ShipBuilder{
    private ArrayList<Ship> ships = new ArrayList<Ship>();
    private OceanGrid ocean;

    public ShipBuilder(OceanGrid ocean){
        //repeat making of ship 5 times(1 for each ship)
        for (ShipType name : ShipType.values()){
            ArrayList<Coordinate> coordinates = addCoords(name.getLength());
            Ship ship = new Ship(name, name.getLength(), coordinates);
            ships.add(ship);
        }

    }

    public ArrayList<Coordinate> addCoords(int length){

        
    }

    
}