package ensta;
import org.junit.Test;

public class TestBoard{

    @Test
    public void test(){
        Board Plateau = new Board("Alexandre");
        Plateau.print();

        Board Plateau2 = new Board("Alexandre", 5);
        Plateau2.print();

        Board Plateau3 = new Board("Alexandre", 25);
        Plateau3.print();
    }
}