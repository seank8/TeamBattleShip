public class OceanGrid extends Grid{
    

    public OceanGrid(){
        super();

    }
    @Override
    public void printGrid(){

        System.out.println("Ocean Grid:");
        super.printGrid();

    }
    
    public ShotResult receiveShot(Shot shot) {
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
        }else{
            Ship ship = cell.getShip();
            ship.registerHit();
            if(ship.isSunk() == true){
                return ShotResult.SUNK;
            } else{
                return ShotResult.HIT;
            }
        } 
        
    }
    
   
    
}
