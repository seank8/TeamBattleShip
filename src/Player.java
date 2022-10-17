import java.util.List;

public class Player {
    private String name;
    private Shot shot;
    protected OceanGrid oceanGrid = new OceanGrid();
    protected TargetGrid targetGrid = new TargetGrid();

    public Player(String name) {
        this.name = name;
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
            if (targetGrid.shotnottakenyet(shot)){;
            break;
            }else {
            System.out.println("You have already taken the Shot");{

            }
            
        }

        return shot;
    }
}
}
                
             
             
            

               
            
        

        
    

        
    
