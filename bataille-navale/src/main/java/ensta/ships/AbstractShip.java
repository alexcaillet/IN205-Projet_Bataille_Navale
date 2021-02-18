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
     * Compte le nombre de frappe sur la navire
     */
    private int strikeCount;

    /**
     * Orientation
     */
    private Orientation orientation;


    public AbstractShip(String name, char label, int size, Orientation orientation){
        this.name = name;
        this.label = label;
        this.size = size;
        this.orientation = orientation;
        this.strikeCount = 0;
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

    /**
     * Ajoute une frappe au navire
     */
    public void addStrike(){
        if(strikeCount<size){
            strikeCount++;
        }
    }

    /**
     * Indique si le bateau est coulé
     * @return
     */
    public boolean isSunk(){
        if(strikeCount==size){
            return true;
        }
        else{
            return false;
        }
    }

    
}