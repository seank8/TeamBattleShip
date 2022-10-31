import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<Player>();
    private int currentPlayerIndex = 0;
    private String name1;
    private String name2;
    // note from John - you don't need the player1 and player2 lines... your players are being kept in the players collection
    // you DO need an instance variable to keep track of which index is the current player (maybe currentPlayerIndex?)


    public void play(){
        launchScreen();
        players.add(new Player(name1));
        players.add(new Player(name2));

        for(Player player: players){
            player.placeShips(); 
        }
 
        players.get(currentPlayerIndex).printOceanGrid();
        players.get(currentPlayerIndex).printTargetGrid();
        
        Shot shot = players.get(currentPlayerIndex).takeShot();

        ShotResult result = players.get(currentPlayerIndex + 1).recieveShot(shot);

        System.out.println(result);
        
    } 

    public void launchScreen(){
        String entry = startupMenu();
        if (entry.equals("1")){
            String entry2 = newgameMenu();
            if (entry2.equals("1")){
                
                name1 = ConsoleHelper.getInput("Please enter name for Player 1: ");
                
                name2 = ConsoleHelper.getInput("Please enter name for Player 2: ");
                
            }else{

            }
        }else{

        }

        
    }


    public String startupMenu(){
        System.out.println("Welcome to BattleShip!");
        System.out.println("Press '1' to Start a New Game");
        System.out.println("Press '2' to Load a Saved Game");
        System.out.println("Press 'X' to Exit");
        String entry = ConsoleHelper.getInput("> ");
        return entry;

    }

    public String newgameMenu(){
        System.out.println("Player vs Player : Press '1'");
        System.out.println("Player vs AI : Press '2'");
        String entry = ConsoleHelper.getInput("> ");
        return entry;
    }



    
}
