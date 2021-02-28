package ensta;
import ensta.ships.*;
import org.junit.Test;
import static org.junit.Assert.assertSame;

import java.util.List;
import java.util.ArrayList;

public class TestBoard{

    @Test
    public void test(){
        

        Board Plateau = new Board("Alexandre");
        Plateau.print();

        List<AbstractShip> ships = new ArrayList<AbstractShip>();
        ships.add(new Destroyer());
        ships.add(new Submarine());
        ships.add(new Submarine());
        ships.add(new Battleship());
        ships.add(new Carrier());

        int i = 1;
        for(AbstractShip ship : ships){
            try{
                Plateau.putShip(ship, i, 1);
            }
            catch(Exception e){
            }
            i++;
        }

        Plateau.print();
        for(int j = 1; j<11; j++){
            try{
                Hit frappe = Plateau.sendHit(5, j);
                System.out.println(frappe.toString());
            }
            catch(Exception e){}
        }

        Plateau.print();
        
    }

    @Test
    public void testSendHit(){
        Board plateau = new Board("test");
        Carrier ship = new Carrier();
        try{
            plateau.putShip(ship, 4, 4);
        }
        catch(Exception e){
        }
        Hit hit1 = plateau.sendHit(4, 7);
        Hit hit2 = plateau.sendHit(5, 7);
        assertSame(hit1, Hit.STIKE);
        assertSame(hit2, Hit.MISS);
    }
}