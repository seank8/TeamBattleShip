import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BOTShooter {
    private Shot shot;
    private Shot huntShot;
    private Direction brackDirection;
    private Direction pursuitDirection;
    private ShotResult result;
    private List<Shot> shotList = new ArrayList<Shot>();
    private static List<Shot> shotsTaken = new ArrayList<Shot>(); 
    private State currentState;


    public BOTShooter(){
        createShotList();
        


    }

    public void setState(State state){
        this.currentState = state;
    }

    
    public void setResult(ShotResult result){
        this.result = result;
    }

    public Shot takeShot(){
        if (currentState == State.HUNT){
            Hunt hunt = new Hunt();
            shot = hunt.getShot();
        } else if (currentState == State.BRACKET){
            Bracket bracket = new Bracket(huntShot);
            brackDirection = bracket.shotDirection();
            shot = bracket.getShot();
        }else if (currentState == State.PURSUIT){
            Pursue pursue = new Pursue(shot, brackDirection);

            shot = pursue.getShot();
        }else if (currentState == State.REVERSE){
            Direction opposite = pursuitDirection.getOpposite(pursuitDirection);
            Reverse reverse = new Reverse(huntShot,opposite);

            shot = reverse.getShot();
        }

        return shot;
    }

    public class Hunt{
        
        private Random random = new Random();
        public Hunt(){
            huntShot = shotList.get(random.nextInt(shotList.size()));
            shotList.remove(huntShot);
            shotsTaken.add(huntShot);
        }

        public Shot getShot(){
            return huntShot;
        }

    }
    public class Bracket{
        private int initialRow;
        private int initialColumn;
        private Shot nextShot;
        private Direction nextDirection;
        private Shot bracket;
        private List<Shot> bracketShots = new ArrayList<Shot>();
        private List<Direction> directionsUsed = new ArrayList<Direction>();
        
        public Bracket(Shot huntShot){
            initialRow = huntShot.getRow();
            initialColumn = huntShot.getColumn();
            for (Direction direction : Direction.values()) {
                switch(direction){
                    case NORTH:
                        bracket = new Shot(initialRow - 1, initialColumn);
                    case SOUTH:
                        bracket = new Shot(initialRow + 1, initialColumn);
                    case EAST:
                        bracket = new Shot(initialRow, initialColumn + 1);
                    case WEST:
                        bracket = new Shot(initialRow, initialColumn - 1);
                }
                if(shotsTaken.contains(bracket) || bracket.getColumn() > 10 || bracket.getColumn() < 1 || bracket.getRow() > 10 || bracket.getRow() < 1){

                }else{
                    bracketShots.add(bracket);
                    directionsUsed.add(direction);
                }
            }
        }

        public Shot getShot(){
            nextShot = bracketShots.get(0);
            return nextShot;
        }

        public Direction shotDirection(){
            nextDirection = directionsUsed.get(0);
            return nextDirection;
        }


    }
    public class Pursue{
        private Shot pursueShot;
        private Shot listShot;
        private int lastRow;
        private int lastColumn;
        private List<Shot> pursuitShots = new ArrayList<Shot>();

        
        public Pursue(Shot lastShot, Direction bracketDirection){
            lastRow = lastShot.getRow();
            lastColumn = lastShot.getColumn();
            switch(bracketDirection){
                case NORTH:
                    for(int i = 1; i < 4; i++){
                        listShot = new Shot(lastRow - i, lastColumn);
                        if(validShot(listShot) == false){

                        }else{
                            pursuitShots.add(listShot);
                        }
                    }
                    
                case SOUTH:
                    for(int i = 1; i < 4; i++){
                        listShot = new Shot(lastRow + i, lastColumn);
                        if(validShot(listShot) == false){

                        }else{
                            pursuitShots.add(listShot);
                        }
                    }
                    
                case EAST:
                    for(int i = 1; i < 4; i++){
                        listShot = new Shot(lastRow, lastColumn + i);
                        if(validShot(listShot) == false){

                        }else{
                            pursuitShots.add(listShot);
                        }
                    }
                    
                case WEST:
                    for(int i = 1; i < 4; i++){
                        listShot = new Shot(lastRow, lastColumn - i);
                        if(validShot(listShot) == false){

                        }else{
                            pursuitShots.add(listShot);
                        }
                    }
            }

        }

        public boolean validShot(Shot shot){

            if(shotsTaken.contains(shot) || shot.getColumn() > 10 || shot.getColumn() < 1 || shot.getRow() > 10 || shot.getRow() < 1){
                return false;
            } else{
                return true;
            }
        }

        public Shot getShot(){
            pursueShot = pursuitShots.get(0);
            return pursueShot;
        }


    }
    public class Reverse{
        private Shot reverseShot;
        private int huntRow;
        private int huntColumn;
        private Shot addReverse;
        private List<Shot> reverseList = new ArrayList<Shot>();

        public Reverse(Shot huntShot, Direction opposite){
            huntRow = huntShot.getRow();
            huntColumn = huntShot.getColumn();
            switch(opposite){
                case NORTH:
                    for(int i = 1; i < 4; i++){
                        addReverse = new Shot(huntRow - i, huntColumn);
                        if(validShot(addReverse) == false){

                        }else{
                            reverseList.add(addReverse);
                        }
                    }
                    
                case SOUTH:
                    for(int i = 1; i < 4; i++){
                        addReverse = new Shot(huntRow + i, huntColumn);
                        if(validShot(addReverse) == false){

                        }else{
                            reverseList.add(addReverse);
                        }
                    }
                    
                case EAST:
                    for(int i = 1; i < 4; i++){
                        addReverse = new Shot(huntRow, huntColumn + i);
                        if(validShot(addReverse) == false){

                        }else{
                            reverseList.add(addReverse);
                        }
                    }
                    
                case WEST:
                    for(int i = 1; i < 4; i++){
                        addReverse = new Shot(huntRow, huntColumn - i);
                        if(validShot(addReverse) == false){

                        }else{
                            reverseList.add(addReverse);
                        }
                    }
            }


        }
        public boolean validShot(Shot shot){

            if(shotsTaken.contains(shot) || shot.getColumn() > 10 || shot.getColumn() < 1 || shot.getRow() > 10 || shot.getRow() < 1){
                return false;
            } else{
                return true;
            }
        }

        public Shot getShot(){
            reverseShot = reverseList.get(0);
            return reverseShot;
        }

    }







    private void createShotList(){
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
        
    }


    
}
