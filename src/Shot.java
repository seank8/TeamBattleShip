

public class Shot {

    private int row; //first is zero
    private int column;

    public Shot(String humanValue) throws Exception{
        row = rowForInput(humanValue);
        column = columnForInput(humanValue);
    }

    public int rowForInput(String value) throws Exception {
        String lowercased = value.toLowerCase();
        char rowChar =lowercased.charAt(0);
        int row = (int)rowChar - 97;
        if(row < 0 || row > 9){
            throw new Exception("Invalid row for shot.");
        }


        return row;
    }

    public int columnForInput(String value) throws Exception {

        String columnString = value.substring(1);

        int column;

        try{
            column = Integer.parseInt(columnString) - 1;
        } catch (NumberFormatException e){
            throw new Exception(e);
        }
        
        if(column < 0 || column > 9){
            throw new Exception("Invalid row for shot.");
        }

        return column;
    }

    public int getRow(){
        return row;
    }

    public int getColumn(){
        return column;
    }





}
