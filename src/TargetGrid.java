
public class TargetGrid extends Grid {

    public TargetGrid() {
        super();
    }

    @Override
    public void printGrid() {

        System.out.println("Target Grid:");
        super.printGrid();

    }

    // return true or false if the cell state is hit or miss 
    public boolean isShotValid(Shot shot) {
        int r = shot.getRow();
        int c = shot.getColumn();

        //use to find cell at coordinate
        Cell cell = cells[r][c];

        //get state of cell, empyty or occupied
        CellState cs = cell.getState();

        if (cs == CellState.HIT) {
            return false;
        }

        if (cs == CellState.MISS) {
            return false;
        }
        return true;
    }
<<<<<<< HEAD
        
} 
      
         
    
=======
>>>>>>> 4d6dc1b5139a050cd143203c3484a9c7014dfea4

    public void receiveShotResult(ShotResult result, Shot shot) {
        if (result == ShotResult.HIT) {

        }
    }

}
    
  

    
    
    

