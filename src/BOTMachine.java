public class BOTMachine {
    private State currentState = State.HUNT;
    private Event event = Event.OUT;
    private BOTShooter shooter;
    private ShotResult result;



    public Shot takeShot(){

    }

    public void updateResult(ShotResult result){
        this.result = result;
        
    }

    public State nextState(State s, Event e){
        State change = s;
        switch(s){
            case HUNT: switch(e){
                case HIT:
                    change = State.BRACKET;
                   
                case MISS:
                    change = State.HUNT;
                
                case SUNK:
                    change = State.HUNT;
                
                case OUT:
                    change = State.HUNT;
                
            }
            case BRACKET: switch(e){
                case HIT:
                    change = State.PURSUIT;
                    
                case MISS:
                    change = State.BRACKET;
                
                case SUNK:
                    change = State.HUNT;
                
                case OUT:
                    change = State.HUNT;
            }
                
            
            case PURSUIT: switch(e){
                case HIT:
                    change = State.PURSUIT;
                    
                case MISS:
                    change = State.REVERSE;
                
                case SUNK:
                    change = State.HUNT;
                
                case OUT:
                    change = State.REVERSE;
            }
            case REVERSE: switch(e){
                case HIT:
                    change = State.REVERSE;
                    
                case MISS:
                    change = State.BRACKET;
                
                case SUNK:
                    change = State.HUNT;
                
                case OUT:
                    change = State.BRACKET;
            }
            
            
            
        }
        return change;

    }

    
}
