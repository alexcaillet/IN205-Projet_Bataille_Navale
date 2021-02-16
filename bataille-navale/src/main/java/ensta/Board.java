package ensta;
import ensta.ships.*;

public class Board implements IBoard {

    /**
     * nom du joueur
     */
    private final String name;

    /**
     * Grille où le joueur place ses bateaux
     */
    private char[][] my_grid;

    /**
     * Grille où le joueur place ses frappes sur l'adversaire
     */
    private boolean[][] target_grid;

    /**
     *
     * @param name      name of the player
     * @param grid_size size of the grid
     */
    public Board(String name, int grid_size) {
        this.name = name;
        this.my_grid = new char[grid_size][grid_size];
        this.target_grid = new boolean[grid_size][grid_size];
    }

    /**
     * Initialise une grille de 10x10
     * 
     * @param name name of the player
     */
    public Board(String name) {
        this.name = name;
        this.my_grid = new char[10][10];
        this.target_grid = new boolean[10][10];
    }

    /**
     * Print the complete board
     */
    public void print() {
        System.out.println("Navires :" + " ".repeat(2 * my_grid.length - 6 + 5) + "Frappes :");

        System.out.print("   ");
        print_letter();
        System.out.print(" ".repeat(8));
        print_letter();
        System.out.print("\n");

        for (int i = 0; i < my_grid.length; i++) {
            System.out.print(i + 1 + " ");
            if (i < 9) {
                System.out.print(" ");
            }

            for (int j = 0; j < my_grid.length; j++) {
                print_my_grid_status(i, j);
            }
            System.out.print(" ".repeat(5));

            System.out.print(i + 1 + " ");
            if (i < 9) {
                System.out.print(" ");
            }

            for (int j = 0; j < my_grid.length; j++) {
                print_target_grid_status(i, j);
            }

            System.out.print("\n");
        }
    }

    /**
     * Print the line at the top of the board with the letters
     */
    private void print_letter() {
        char letter = 'A';
        int counter = 0;
        while (counter < my_grid.length) {
            System.out.print(letter + " ");
            counter++;
            letter++;
        }
    }

    /**
     * Print the (i,j) point of the gamer's grid
     * 
     * @param i line index of the grid
     * @param j column index of the grid
     */
    private void print_my_grid_status(int i, int j) {
        switch (my_grid[i][j]){
            case 'D':
                System.out.print("D ");
                break;
            case 'S':
                System.out.print("S ");
                break;
            case 'C':
                System.out.print("C ");
                break;
            case 'B':
                System.out.print("B ");
                break;
            case 'X':
                System.out.print("X ");
                break;
            default:
                System.out.print(". ");
                break;
        }
    }

    /**
     * Print the (i,j) point of the target grid
     * 
     * @param i line index of the grid
     * @param j column index of the grid
     */
    private void print_target_grid_status(int i, int j) {
        if (target_grid[i][j]) {
            System.out.print("x ");
        } else {
            System.out.print(". ");
        }
    }

    public int getSize() {
        return this.my_grid.length;
    }

    public void putShip(AbstractShip ship, int x, int y) throws Exception {
        try{
            checkLengthShip(x, y, ship);
        }
        catch (Exception e){
            System.out.println(e);
            throw new Exception("Replacez le bateau correctement");
        }

        switch (ship.getOrientation()) {
            case NORTH:
                for(int i=0; i<ship.getSize(); i++){
                    this.my_grid[x-1-i][y-1] = ship.getLabel();
                }
                break;
            case SOUTH:
                for(int i=0; i<ship.getSize(); i++){
                    this.my_grid[x-1+i][y-1] = ship.getLabel();
                }
                break;
            case EAST:
                for(int i=0; i<ship.getSize(); i++){
                    this.my_grid[x-1][y+i-1] = ship.getLabel();
                }
                break;
            case WEST:
                for(int i=0; i<ship.getSize(); i++){
                    this.my_grid[x-1][y-i-1] = ship.getLabel();
                }
                break;
            default:
                break;
        }

    }

    /**
     * Check if the ship is not too long to fit in the grid and if there are not other ships in the way
     * 
     * @param x    position of the ship starting from 1
     * @param y    position of the ship starting from 1
     * @param ship
     */
    private void checkLengthShip(int x, int y, AbstractShip ship) throws Exception {
        String listOfLabel = "DSBCX";
        boolean fitInTheGrid = true;
        switch (ship.getOrientation()) {
            case NORTH:
                if ((x - 1) - ship.getSize() < 0) {
                    fitInTheGrid = false;
                    throw new Exception("Le navire ne rentre pas, repositionner le navire");
                }
                if (fitInTheGrid){
                    for(int i=0; i<ship.getSize(); i++){
                        if (listOfLabel.contains(String.valueOf(my_grid[(x - 1) - i][y-1]))){
                            throw new Exception("Il y a déjà un navire à cette position");
                        }
                    }
                }
                break;
            case SOUTH:
                if ((x - 1) + ship.getSize() > this.getSize() - 1) {
                    fitInTheGrid = false;
                    throw new Exception("Le navire ne rentre pas, repositionner le navire");
                }
                if (fitInTheGrid){
                    for(int i=0; i<ship.getSize(); i++){
                        if (listOfLabel.contains(String.valueOf(my_grid[(x - 1) + i][y-1]))){
                            throw new Exception("Il y a déjà un navire à cette position");
                        }
                    }
                }                
                break;
            case EAST:
                if ((y - 1) + ship.getSize() > this.getSize()-1) {
                    fitInTheGrid = false;
                    throw new Exception("Le navire ne rentre pas, repositionner le navire");
                }
                if (fitInTheGrid){
                    for(int i=0; i<ship.getSize(); i++){
                        if (listOfLabel.contains(String.valueOf(my_grid[(x - 1)][y-1+i]))){
                            throw new Exception("Il y a déjà un navire à cette position");
                        }
                    }
                }
                break;
            case WEST:
                if ((y - 1) - ship.getSize() < 0) {
                    fitInTheGrid = false;
                    throw new Exception("Le navire ne rentre pas, repositionner le navire");
                }
                if (fitInTheGrid){
                    for(int i=0; i<ship.getSize(); i++){
                        if (listOfLabel.contains(String.valueOf(my_grid[(x - 1)][y-1-i]))){
                            throw new Exception("Il y a déjà un navire à cette position");
                        }
                    }
                }
                break;
            default:
                break;
        }
    }

    public boolean hasShip(int x, int y) {
        if (this.my_grid[x][y] != '.') {
            return true;
        } else {
            return false;
        }
    }

    public void setHit(boolean hit, int x, int y) {
        this.target_grid[x][y] = hit;
    }

    public Boolean getHit(int x, int y) {
        if (my_grid[x][y] == '.') {
            return false;
        } else {
            return true;
        }
    }
}