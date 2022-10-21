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
        Cell cell = getCell(shot);
        //get corrdinates from shot row/column
        CellState cs = getCellState(shot);
        //make descion 
        if(cs == CellState.EMPTY){
            setCellState(shot, CellState.MISS);
            return ShotResult.MISS;
        }else{
            Ship ship = cell.getShip();
            ship.registerHit();
            cell.setState(CellState.HIT);
            if(ship.isSunk() == true){
                return ShotResult.SUNK;
            } else{
                return ShotResult.HIT;
            }
        } 
        
    }
    
   
    
}
