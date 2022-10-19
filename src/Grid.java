public class Grid {
    protected Cell[][] cells = new Cell[10][10];
    private Ship ship = null;
    private CellState state = CellState.EMPTY;
    

    public Grid(){
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++){
                cells[row][column] = new Cell(ship, state);
            }
            
        }
    }

    private void printDivider(){
        System.out.println("+---+---+---+---+---+---+---+---+---+---+---+");
    } 

    private void printHeader(){
        System.out.println("|   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 |10 |");
    }


    public void printGrid() {
        
        printDivider();
        printHeader();
        printDivider();
        for(int row = 0; row < 10 ; row++){
            System.out.print("| A |");
            for(int column = 0; column < 10; column++){
                if(cells[row][column].getState() == CellState.EMPTY){
                    System.out.print("   |");
                }
                
            }
            System.out.println();
            printDivider();
        }

    }

    protected Cell getCell(Shot shot){
        int r = shot.getRow();
        int c = shot.getColumn();

        //use to find cell at coordinate
        Cell cell = cells[r][c];
        return cell;
    }

    protected CellState getCellState(Shot shot){
        

        //use to find cell at coordinate
        Cell cell = getCell(shot);

        //get state of cell, empyty or occupied
        CellState cs = cell.getState();
        return cs;

    }

    protected void setCellState(Shot shot, CellState state){
        

        //use to find cell at coordinate
        Cell cell = getCell(shot);

        //get state of cell, empyty or occupied
        cell.setState(state);

    }

}
