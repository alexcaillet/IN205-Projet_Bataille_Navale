package ensta;
import ensta.ships.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Board Plateau3 = new Board("Alexandre", 20);
        Board Plateau4 = new Board("Adversaire", 20);
        Plateau3.print();

        List<AbstractShip> ships = new ArrayList<AbstractShip>();
        ships.add(new Destroyer());
        ships.add(new Submarine());
        ships.add(new Submarine());
        ships.add(new Battleship());
        ships.add(new Carrier());

        Player Alexandre = new Player(Plateau3, Plateau4, ships);
        Alexandre.putShips();
    }
}
