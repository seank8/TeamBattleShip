import java.util.ArrayList;

public class Game {
    private ArrayList<IPlayer> players = new ArrayList<IPlayer>();
    private int currentPlayerIndex = 0;
    
    // note from John - you don't need the player1 and player2 lines... your players are being kept in the players collection
    // you DO need an instance variable to keep track of which index is the current player (maybe currentPlayerIndex?)


    public void play(){
        while(true){
            //identify current player
            //display player info
        }
        launchScreen();
<<<<<<< HEAD
    
=======
        
        IPlayer currentP = players.get(currentPlayerIndex);
        IPlayer otherP;
        if(currentPlayerIndex == 0){
            otherP = players.get(1);
        }else{
            otherP = players.get(0);
        }
        
>>>>>>> 163b6558b42b6e3c9d2f54a18d812c99fb6c3f3f

        

        for(IPlayer player: players){
            player.placeShips(); 
        }
 
        currentP.printTargetGrid();
        currentP.printOceanGrid();

        
        Shot shot = currentP.takeshot();

        ShotResult result = otherP.receiveShot(shot);

        System.out.println(result);
        
<<<<<<< HEAD


       // private void display playerinfo(Player Player)

=======
>>>>>>> 163b6558b42b6e3c9d2f54a18d812c99fb6c3f3f
    } 

    //consuole input hit enter before printing the turn
    //code that pause the game for entry before game

    public void launchScreen(){
        String entry = startupMenu();
        if (entry.equals("1")){
            String entry2 = newgameMenu();
            if (entry2.equals("1")){
                
                String name1 = ConsoleHelper.getInput("Please enter name for Player 1: ");
                players.add(new Player(name1));
                
                String name2 = ConsoleHelper.getInput("Please enter name for Player 2: ");
                players.add(new Player(name2));
                
            }else{
                String name1 = ConsoleHelper.getInput("Please enter name for Player: ");
                players.add(new Player(name1));

                String name2 = "JohnBot Infinity v2.3";
                players.add(new BOTPlayer(name2));
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
