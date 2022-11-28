public class BOTMachine {
    private State currentState = State.HUNT;
    private Event event = Event.OUT;
    private BOTShooter shooter = new BOTShooter();
    



    public Shot takeShot(){
        shooter.setState(currentState);
        Shot shot = shooter.takeShot();
        return shot;

    }
    

    public void updateResult(ShotResult result){


        if (result == ShotResult.HIT){
            event = Event.HIT;
            currentState = nextState(currentState, event);
        } else if (result == ShotResult.MISS){
            event = Event.MISS;
            currentState = nextState(currentState, event);
        } else if (result == ShotResult.SUNK){
            event = Event.SUNK;
            currentState = nextState(currentState, event);
        } else{
            event = Event.OUT;
            currentState = nextState(currentState, event);
        }
        
    }

    public State nextState(State s, Event e){
        State change = s;
        switch(s){
            case HUNT: switch(e){
                case HIT:
                    change = State.BRACKET;
                    break;
                case MISS:
                    change = State.HUNT;
                    break;
                case SUNK:
                    change = State.HUNT;
                    break;
                case OUT:
                    change = State.HUNT;
                    break;
            }
            break;
            case BRACKET: switch(e){
                case HIT:
                    change = State.PURSUIT;
                    break;
                case MISS:
                    change = State.BRACKET;
                    break;
                case SUNK:
                    change = State.HUNT;
                    break;
                case OUT:
                    change = State.HUNT;
                    break;
            }
            break;
                
            
            case PURSUIT: switch(e){
                case HIT:
                    change = State.PURSUIT;
                    break;
                case MISS:
                    change = State.REVERSE;
                    break;
                case SUNK:
                    change = State.HUNT;
                    break;
                case OUT:
                    change = State.REVERSE;
                    break;
            }
            break;
            case REVERSE: switch(e){
                case HIT:
                    change = State.REVERSE;
                    break;
                    
                case MISS:
                    change = State.BRACKET;
                    break;
                case SUNK:
                    change = State.HUNT;
                    break;
                case OUT:
                    change = State.BRACKET;
                    break;
            }
            break;
            
            
        }
        return change;

    }

    
}
