public class OceanGrid extends Grid{
    private Ship ship;

    public OceanGrid(){
        super();

    }
    @Override
    public void printGrid(){

        System.out.println("Ocean Grid:");
        super.printGrid();

    }
    
    public ShotResult receiveShot(Shot shot){
        //get corrdinates from shot row/column
        int r = shot.getRow();
        int c = shot.getColumn();

        //use to find cell at coordinate
        Cell cell = cells[r][c];

        //get state of cell, empyty or occupied
        CellState cs = cell.getState();
        //make descion 
        if(cs == CellState.EMPTY){
            return ShotResult.MISS;
        }
        if(cs == CellState.OCCUPIED){
            if(cs == CellState.getState.OCCUPIED){
                return ShotResult.SHOT; 
            }
            return ShotResult.HIT;
        }
           if(cs == CellState.OCCUPIED){

           }
            //Occupied = 
                    // check if ship is sunk
                        // return sunk
                    //else return hit
    }

    public void placeShip(Ship ship){

    }

    public ShotResult getShotResult(Shot shot){
        
    }
    
}
