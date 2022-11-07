import java.util.ArrayList;

public class Ship {
    private ShipType ship;
    private int hitCount;
    protected ArrayList<Coordinate> coordinates;
    protected ShipBuilder builder;
    

    public Ship(ShipType ship, int hitCount, ArrayList<Coordinate> coordinates){
        this.ship = ship;
        this.hitCount = 0;
        this.coordinates = coordinates;
    }
    public void registerHit(){
        ++hitCount;         
    }

    public boolean isSunk(){
        if(hitCount == ship.getLength()){
            return true;
        } else{
            return false;
        }
    }

    public ArrayList<Coordinate> getCoordinates(){
        return coordinates;
    }


    
}
