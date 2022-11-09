import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BOTPlayer implements IPlayer{
    private String name;
    private Shot shot;
    protected OceanGrid oceanGrid = new OceanGrid();
    protected TargetGrid targetGrid = new TargetGrid();
    private List<Shot> shotList = new ArrayList<Shot>();
   
   
    public BOTPlayer(String name){
        this.name = name;
        shuffleShotList();
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
        
        shot = shotList.get(0);
        shotList.remove(0);
            
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
        // TODO Auto-generated method stub
        
    }
    @Override
    public boolean allShipsAreSunk() {
        // TODO Auto-generated method stub
        return false;
    }

    private void shuffleShotList(){
        
        String letters = "ABCDEFGHIJ";
        char[] rows = letters.toCharArray();
            
        for(int i = 0; i < 10; i++)
        {
            for(int j = 1; j < 11; j++)
            {
                char row = rows[i];
                int column = j;
                try {
                    shotList.add(new Shot("" + row + column));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
            
        Collections.shuffle(shotList);
        
    }






    
}
