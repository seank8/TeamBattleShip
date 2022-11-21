import java.util.ArrayList;
import java.util.List;

public class BOTShooter {
    private Shot shot;
    private ShotResult result;
    private List<Shot> shotList = new ArrayList<Shot>();


    public BOTShooter(ShotResult result, Shot shot){
        createShotList();
        this.result = result;
        this.shot = shot;


    }

    public void setShot(Shot shot){
        this.shot = shot;
    }
    public void setResult(ShotResult result){
        this.result = result;
    }

    public Shot takeShot(){
        if 



        return shot;
    }

    public Shot hunt(){

    }
    public Shot bracket(){

    }
    public Shot pursue(){

    }
    public Shot reverse(){

    }







    private void createShotList(){
        String letters = "ABCDEFGHIJ";
        char[] rows = letters.toCharArray();
        
            
        for(int i = 0; i < 10; i++)
        {
            for(int j = 1; j < 11; j++)
            {
                char row = rows[i];
                int column = j;
                try {
                    shotList.add(new Shot("" + row + column));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
    }


    
}
