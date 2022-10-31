import java.util.ArrayList;
import java.util.List;
import java.awt.Point;
import java.util.Map.Entry;


public class Player {
    private String name;
    private Shot shot;
    protected OceanGrid oceanGrid = new OceanGrid();
    protected TargetGrid targetGrid = new TargetGrid();
    
    
    protected ShipBuilder builder;

    public Player(String name) {
        this.name = name;
    }
    public void printOceanGrid(){
        oceanGrid.printGrid();
    }
    public void printTargetGrid(){
        targetGrid.printGrid();
    }

    public void setOceanGrid(OceanGrid grid){
        this.oceanGrid = grid;
    }
    public String getName(){
        return name;
    }
    
   
    // row and column Position bool, random do and while return

    public Shot takeShot(){
       
        while (true){
           String input = ConsoleHelper.getInput("Take a Shot> ");
            try {
                
                shot  = new Shot(input);
            } catch (Exception e){
                System.out.println("Invalid Shot");
               // explain to user of an invalid shot
               //continue while loop 
               continue;
            }
            
            if (targetGrid.isShotValid(shot)){
                return shot;
                
            }else {
            System.out.printf("You have already taken the Shot at %s%n", input);
            
            }
        }
            
        }

    public void placeShips(){
        ShipBuilder builder = new ShipBuilder();
        for (Ship ship : builder.getShips()) {
            oceanGrid.setShipCells(ship);
        }

    }


    public ShotResult recieveShot(Shot shot){
        return oceanGrid.receiveShot(shot);
    }

}
                