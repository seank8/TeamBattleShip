import java.util.ArrayList;
import java.util.List;
import java.awt.Point;
import java.util.Map.Entry;


public class Player {
    private String name;
    private Shot shot;
    protected OceanGrid oceanGrid = new OceanGrid();
    protected TargetGrid targetGrid = new TargetGrid();
<<<<<<< HEAD
    private ArrayList<Coordinate> coordinates;
    private ShipBuilder builder;
=======
    protected ShipBuilder builder;
>>>>>>> 4d6dc1b5139a050cd143203c3484a9c7014dfea4

    public Player(String name) {
        this.name = name;
    }

    public void setOceanGrid(OceanGrid grid){
        this.oceanGrid = grid;
    }
    public String getName(){
        return name;
    }
    
   
    // row and column Position bool, random do and while return

    public Shot takeShot(){
        //present target grid and ocean grid
         // get shot cordinates from user
         //create shot object
        //return shot object
        targetGrid.printGrid();
        oceanGrid.printGrid();
       
        while (true){
           String input = ConsoleHelper.getInput("take a shot");
            try {
                
                shot  = new Shot(input);
            } catch (Exception e){
                System.out.println("Invalid Shot");
               // explain to user of an invalid shot
               //continue while loop 
               continue;
            }
<<<<<<< HEAD
            if (targetGrid.isShotValid(shot)){;
            break;
=======
            if (targetGrid.isShotValid(shot)){
                return shot;
                
>>>>>>> 4d6dc1b5139a050cd143203c3484a9c7014dfea4
            }else {
            System.out.printf("You have already taken the Shot at %s%n", input);
            
            }
            
        }

        return shot;
    }
    public ShotResult receiveShot(Shot shot){
        return oceanGrid.receiveShot(shot);
    }

<<<<<<< HEAD
=======
    public void placeShips(){
        builder = new ShipBuilder(oceanGrid);
    }


    public ShotResult recieveShot(Shot shot){
        return oceanGrid.receiveShot(shot);
    }

    

}
                
             
             
            

               
            
        

        
>>>>>>> 4d6dc1b5139a050cd143203c3484a9c7014dfea4
    

}