package ensta;

import ensta.ships.*;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Player {
    /*
     * ** Attributs
     */
    protected Board board;
    protected Board opponentBoard;
    protected int destroyedCount;
    protected AbstractShip[] ships;
    protected boolean lose;

    /*
     * ** Constructeur
     */
    public Player(Board board, Board opponentBoard, List<AbstractShip> ships) {
        this.board = board;
        this.ships = ships.toArray(new AbstractShip[0]);
        this.opponentBoard = opponentBoard;
    }

    /*
     * ** Méthodes
     */

    /**
     * Read keyboard input to get ships coordinates. Place ships on given
     * coodrinates.
     */
    public void putShips() {
        boolean done = false;
        int i = 0;

        do {
            AbstractShip s = ships[i];
            String msg = String.format("placer %d : %s(%d)", i + 1, s.getName(), s.getSize());
            System.out.println(msg);
            InputHelper.ShipInput res = InputHelper.readShipInput();

            boolean restart = true;
            while (restart) {
                switch (res.orientation) {
                    case "n":
                        s.setOrientation(Orientation.NORTH);
                        break;
                    case "s":
                        s.setOrientation(Orientation.SOUTH);
                        break;
                    case "e":
                        s.setOrientation(Orientation.EAST);
                        break;
                    case "w":
                        s.setOrientation(Orientation.WEST);
                    default:
                        break;
                }
                try {
                    board.putShip(s, res.x, res.y);
                    restart = false;
                } catch (Exception e) {
                    msg = String.format("placer %d : %s(%d)", i + 1, s.getName(), s.getSize());
                    System.out.println(msg);
                    res = InputHelper.readShipInput();
                    System.out.println(res.x + " " + res.y + res.orientation);
                    restart = true;
                }
            }

            ++i;
            done = i == 5;
            board.print();
        } while (!done);
    }

    public Hit sendHit(int[] coords) { 
        boolean done = false; 
        Hit hit = null;
        do {
            System.out.println("où frapper?");
            InputHelper.CoordInput hitInput = InputHelper.readCoordInput(); // TODO call sendHit on this.opponentBoard
            hit = this.opponentBoard.sendHit(hitInput.y, hitInput.x);
            coords[0] = hitInput.y;
            coords[1] = hitInput.x;
            done = true;
            // TODO : Game expects sendHit to return BOTH hit result & hit coords.
            //return hit is obvious. But how to return coords at the same time ?
        } while (!done);
        return hit;
    }

    public AbstractShip[] getShips() {
        return ships;
    }

    public void setShips(AbstractShip[] ships) {
        this.ships = ships;
    }
}
