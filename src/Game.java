import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players;

    public void play(){

    } 

    public void launchScreen(){
        String entry = startupMenu();
        if (entry == "1"){
            String entry2 = newgameMenu();
            if (entry2 == "1"){
                for( int i = 0; i > 2 ; i++){
                    String name = ConsoleHelper.getInput("Please enter name for Player 1: ");
                    Player player = new Player(name);
                    players.add(player);
                }
                play();
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
