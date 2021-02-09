package ensta;

public class Battleship extends AbstractShip{
    public Battleship(Orientation orientation){
        super("Battleship", 'B', 4, orientation);
    }

    public Battleship(){
        super("Battleship", 'B', 4, Orientation.EAST);
    }
}
