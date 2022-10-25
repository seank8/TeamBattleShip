import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players =new ArrayList<Player>();
    private Player player1;
    private Player player2;

    public void play(){
        launchScreen();

        for(Player player: players){
            player.placeShips(player.oceanGrid);
        }

        player1.targetGrid.printGrid();
        player1.oceanGrid.printGrid();
        
        Shot shot = player1.takeShot();

        ShotResult result = player2.recieveShot(shot);

        System.out.println(result);
        

    } 

    public void launchScreen(){
        String entry = startupMenu();
        if (entry.equals("1")){
            String entry2 = newgameMenu();
            if (entry2.equals("1")){
                
                String name = ConsoleHelper.getInput("Please enter name for Player 1: ");
                player1 = new Player(name);
                players.add(player1);
                String name2 = ConsoleHelper.getInput("Please enter name for Player 2: ");
                player2 = new Player(name2);
                players.add(player2);
                
                
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
