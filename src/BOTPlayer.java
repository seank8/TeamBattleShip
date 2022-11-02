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
    public Shot takeshot() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public ShotResult receiveShot(Shot shot) {
        // TODO Auto-generated method stub
        return null;
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
