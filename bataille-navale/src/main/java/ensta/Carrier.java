package ensta;

public class Carrier extends AbstractShip {
    public Carrier(Orientation orientation){
        super("Aircraft-Carrier", 'C', 5, orientation);
    }

    public Carrier(){
        super("Aircraft-Carrier", 'C', 5, Orientation.EAST);
    }
}
