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

        Destroyer d1 = new Destroyer(Orientation.SOUTH);
        Carrier c1 = new Carrier(Orientation.NORTH);
        Submarine s1 = new Submarine(Orientation.EAST);
        Battleship b1 = new Battleship(Orientation.WEST);
        Plateau.putShip(d1, 1, 1);
        Plateau.putShip(c1, 10, 10);
        Plateau.putShip(s1, 5, 5);
        Plateau.putShip(b1, 5, 5);
        Plateau.print();
    }
}