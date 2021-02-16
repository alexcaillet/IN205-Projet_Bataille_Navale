package ensta.ships;

public abstract class AbstractShip{
    /**
     * Label qui sera afffiché sur la grille
     */
    private char label;

    /**
     * nom du type de navire
     */
    private final String name;

    /**
     * Taille du bateau
     */
    private final int size;

    /**
     * Orientation
     */
    private Orientation orientation;


    public AbstractShip(String name, char label, int size, Orientation orientation){
        this.name = name;
        this.label = label;
        this.size = size;
        this.orientation = orientation;
    }

    public void setOrientation(Orientation orientation){
        this.orientation = orientation;
    }

    public Orientation getOrientation(){
        return this.orientation;
    }

    public int getSize(){
        return this.size;
    }

    public String getName(){
        return this.name;
    }

    public char getLabel(){
        return this.label;
    }

    
}