public class BOTPlayer implements IPlayer{
    private String name;
    private Shot shot;
    protected OceanGrid oceanGrid = new OceanGrid();
    protected TargetGrid targetGrid = new TargetGrid();
   
   
    public BOTPlayer(String name){
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
    public Shot takeshot() { //this is jsut copied from the player class, will need to be updated fo AI player.
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






    
}
