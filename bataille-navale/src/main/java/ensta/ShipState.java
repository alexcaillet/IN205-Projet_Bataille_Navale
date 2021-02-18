package ensta;
import ensta.ships.*;

public class ShipState {
    public boolean hasShip = false;

    /**
     * Navire dont l'état est suivi par la classe
     */
    private AbstractShip ship;

    /**
     * Indique si le bateau est touché à cet endroit
     */
    private boolean struck = false;

    public ShipState(){
        this.struck = false;
        this.hasShip = false;
    }

    /**
     * Ajoute une frappe au bateau
     */
    public void addStrike(){
        if(!struck){
            struck = true;
            this.ship.addStrike();
        }
    };

    /**
     * Indique si le bateau est touché
     * @return
     */
    public boolean isStruck(){
        return struck;
    };

    /**
     * Renvoie le label du bateau (en rouge s'il est touché)
     */
    public String toString(){
        if(hasShip && struck){
            return ColorUtil.colorize(ship.getLabel(), ColorUtil.Color.RED)+ " ";
        }
        else if(hasShip && !struck){
            return String.valueOf(ship.getLabel()) + " ";
        }
        else{
            return ". ";
        }
    }

    /**
     * Indique si le bateau est totalement coulé
     * @return
     */
    public boolean isSunk(){
        return ship.isSunk();
    }

    /**
     * Retourne le navire concerné par cet état
     */
    public AbstractShip getShip(){
        return ship;
    }

    public void setShip(AbstractShip ship){
        this.ship = ship;
        this.hasShip = true;
    }


}
