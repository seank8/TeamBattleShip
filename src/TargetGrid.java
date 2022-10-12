public class TargetGrid {
    private Cell[][] cells = new Cell[10][10];

    public TargetGrid() {
        for (int row = 0; row < 10; row++) {
            for (int column = 0; column < 10; column++) {
                cells [row][column] = new Cell();

            }

        }
    }

    public void printGrid() {
        printDivider();
        printHeader();
        printDivider();

        for (int row = 0; row < 10; row++){
            System.out.print("| A |");
            for (int column = 0; column < 10; column++) {
                System.out.print("   |");
            }
            System.out.println();
            printDivider();
        }
            
        

        

    }

    private void printHeader() {
        
        System.out.println("|   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |");

    }

    private void printDivider(){
        System.out.println("+---+---+---+---+---+---+---+---+---+---+---+");
        
    }

} 