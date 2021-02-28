package ensta;
import ensta.ships.*;
import org.junit.Test;

import java.util.Arrays;

public class TestGame{
    @Test
    public void main(){
        Board Plateau = new Board("Alexandre");
        Plateau.print();

        AbstractShip ships[] = new AbstractShip[5];
        ships[0] = new Destroyer();
        ships[1] = new Submarine();
        ships[2] = new Submarine();
        ships[3] = new Battleship();
        ships[4] = new Carrier();

        BattleShipsAI ai = new BattleShipsAI(Plateau, Plateau);
        ai.putShips(ships);

        Plateau.print();
        int sunkShip = 0;
        int coords[] = new int[2];
        String hitLabels[] = {"Frégate", "Sous-marin", "Croiseur", "Porte-avion"};
        Hit hit;
        while(sunkShip<5){
            hit = ai.sendHit(coords);
            System.out.println("x : " + coords[0] + " " + coords[1] + " " + hit.toString());
            if (Arrays.asList(hitLabels).contains(hit.toString())){
                sunkShip++;
            }
            Plateau.print();

            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        
        }
        System.out.println("done");

    }
}