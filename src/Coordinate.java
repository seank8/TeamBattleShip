public class Coordinate {
    private int row;
    private int column;

    public Coordinate(int row, int column){
        this.column = column;
        this.row = row;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }

    
    public boolean equals(Coordinate coordinate){
        int column = coordinate.getColumn();
        int row = coordinate.getRow();
        if(this.getColumn() == column && this.getRow() == row){
            return true;
        } else{
            return false;
        }

    }
    
}

