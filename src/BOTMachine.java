public class BOTMachine {

    public State nextState(State s, Event e){
        State change = s;
        switch(s){
            case HUNT: switch(e){
                case HIT:{
                    change = State.BRACKET;
                }    
                case MISS:{
                    change = State.HUNT;
                }
                case SUNK:{
                    change = State.HUNT;
                }
                case OUT:{
                    change = State.HUNT;
                }
            }
            case BRACKET: switch(e){
                case HIT:{
                    change = State.PURSUIT;
                }    
                case MISS:{
                    change = State.BRACKET;
                }
                case SUNK:{
                    change = State.HUNT;
                }
                case OUT:{
                    change = State.HUNT;
                }
            }
            case PURSUIT:
                break;
            case REVERSE:
                break;
            default:
                break;
            
            
        }
        return change;

    }

    
}
