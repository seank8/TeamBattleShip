import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class BOTPlayerMedium implements IPlayer{
    private String name;
    private Shot shot;
    protected OceanGrid oceanGrid = new OceanGrid();
    protected TargetGrid targetGrid = new TargetGrid();
    
    private ShotResult lastResult;
    private BOTMachine machine;
    
   
   
    public BOTPlayerMedium(String name){
        this.name = name;
        

    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public void printOceanGrid(){
        oceanGrid.printGrid();
    }
    @Override
    public void printTargetGrid(){
        targetGrid.printGrid();
    }

    
    @Override
    public void placeShips(){
        ShipBuilder builder = new ShipBuilder();
        for (Ship ship : builder.getShips()) {
            oceanGrid.setShipCells(ship);
        }
    }
    @Override
    public Shot takeshot() { 
        
        shot = machine.takeShot();
        return shot;
        // precreate 100 shots in a list
        //make a constructor to take int row and column
        //shuffle list (random shots) pull one at a time
        
    }
    
    @Override
    public ShotResult receiveShot(Shot shot) {
        return oceanGrid.receiveShot(shot);
    }
    @Override
    public void receiveShotResult(Shot shot, ShotResult result) {
        targetGrid.receiveShotResult(result, shot);
        
    }
    @Override
    public boolean allShipsAreSunk() {
        if(oceanGrid.getSunkShips().size() >= 5){
            return true;
        }else{
            return false;
        }
    }

    

    @Override
    public String getRecentSunkShip(){
        List<String> sunkShips = oceanGrid.getSunkShips();

        
        String mostRecentSunkShip = sunkShips.get(sunkShips.size()-1);
        return mostRecentSunkShip;

    }
    
    






}
