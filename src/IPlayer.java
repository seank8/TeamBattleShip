public interface IPlayer {

    
    public String getName();

    public void placeShips();

    public Shot takeshot();

    public ShotResult receiveShot(Shot shot);

    public void receiveShotResult(Shot shot, ShotResult result);

    public boolean allShipsAreSunk();

    public void printOceanGrid();
    
    public void printTargetGrid();
}
