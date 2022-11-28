enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST;


    public Direction getOpposite(Direction direction){
        Direction newDirection;
        switch(direction){
            case NORTH:
            newDirection = SOUTH;
            case SOUTH:
            newDirection = NORTH;
            case EAST:
            newDirection = WEST;
            case WEST:
            newDirection = EAST;
            default:
            newDirection = NORTH;
        }
        return newDirection;
    }

}
