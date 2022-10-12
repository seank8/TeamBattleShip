
public class Cell {
    private Ship ship;
    private CellState state;

    public Cell(Ship ship, CellState state){
        this.ship = ship;
        this.state = state;

    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state){
        this.state = state;
    }

    public Ship getShip(){
        return ship;
    }
    public void setShip(Ship ship){
        this.ship = ship;
    }

}
