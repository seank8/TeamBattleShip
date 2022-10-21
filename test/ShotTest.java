import org.junit.Test;
import static org.junit.Assert.*;

public class ShotTest {
    @Test
    public void testMakeShot() throws Exception{
        Shot shot = new Shot("D4");
        //assertion
        assertEquals(3, shot.getRow());
        assertEquals(3, shot.getColumn());

    }
    @Test(expected = Exception.class)
    public void testBogusRow() throws Exception {
        Shot shot = new Shot("x3");
        assertEquals(shot, shot);
    }
    
    @Test(expected = Exception.class)
    public void testBogusColumn() throws Exception {
        Shot shot = new Shot("b14");
        assertEquals(shot, shot);
    }

    @Test(expected = Exception.class)
    public void testNoInput() throws Exception {
        Shot shot = new Shot("");
        assertEquals(0, shot.getRow());
        assertEquals(0, shot.getColumn());
    }
 
    @Test(expected = Exception.class)
    public void testBogusInput() throws Exception {
        Shot shot = new Shot("b 14");
        assertEquals(1, shot.getRow());
        assertEquals(13, shot.getColumn());
    }

    @Test
    public void testBottomRightCornerShot() throws Exception {
        Shot shot = new Shot("J10");
        // assertion
        assertEquals(9, shot.getRow());
        assertEquals(9, shot.getColumn());

    }

   
    

}
