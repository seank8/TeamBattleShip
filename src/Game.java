import java.util.ArrayList;

public class Game {
    private ArrayList<IPlayer> players = new ArrayList<IPlayer>();
    private int currentPlayerIndex = 0;
    private IPlayer winner;
    
    // note from John - you don't need the player1 and player2 lines... your players are being kept in the players collection
    // you DO need an instance variable to keep track of which index is the current player (maybe currentPlayerIndex?)


    public void play(){
        
        launchScreen();
        players.forEach((player) -> player.placeShips());

        while(true){ // game loop

            //start turn
            
            IPlayer currentP = players.get(currentPlayerIndex);

            //send shot
            currentP.printTargetGrid();
            currentP.printOceanGrid();
            System.out.println(currentP.getName() + " Take a Shot!");
            Shot shot = currentP.takeshot();


            //return response

            IPlayer otherP;
            if(currentPlayerIndex == 0){
                otherP = players.get(1);
            }else{
                otherP = players.get(0);
            }
            ShotResult result = otherP.receiveShot(shot);

            currentP.receiveShotResult(shot, result);


            //Print updated target grid and ocean grid
            currentP.printTargetGrid();
            currentP.printOceanGrid();
            if(result == ShotResult.SUNK){
                System.out.println("YOU" + result + "THEIR" + otherP.getRecentSunkShip());
            }else{
                System.out.println("YOU GOT A " + result);
            }
            
            //ask for player to press enter to go to next turn
            ConsoleHelper.getInput(currentP.getName() + "Hit <enter> to go to next players turn: \n");


            //clear terminal 
            System.out.print("\033\143");
            System.out.flush();  

            //check ships
            if(otherP.allShipsAreSunk() == true){
                winner = currentP;
                break;
            }
            if(currentPlayerIndex == 0){
                ++currentPlayerIndex;
            }else{
                --currentPlayerIndex;
            }



    
            


            

        }
        endGame(winner);

        
        
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

    public void endGame(IPlayer winner){
        System.out.println(winner.getName() + " IS THE WINNER!! ");
    }


    
}
