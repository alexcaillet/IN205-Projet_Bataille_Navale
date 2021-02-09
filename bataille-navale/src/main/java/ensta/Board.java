package ensta;

public class Board{

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
     * @param name name of the player
     * @param grid_size size of the grid
     */
    public Board(String name, int grid_size){
        this.name = name;
        this.my_grid = new char[grid_size][grid_size];
        this.target_grid = new boolean[grid_size][grid_size];
    }

    /**
     * Initialise une grille de 10x10
     * @param name name of the player
     */
    public Board(String name){
        this.name = name;
        this.my_grid = new char[10][10];
        this.target_grid = new boolean[10][10];
    }
    
    /**
     * Print the complete board
     */
    public void print(){
        System.out.println("Navires :" + " ".repeat(2*my_grid.length-6 + 5) + "Frappes :");

        System.out.print("   ");
        print_letter();
        System.out.print(" ".repeat(8));
        print_letter();
        System.out.print("\n");

        for(int i=0; i<my_grid.length; i++){
            System.out.print(i+1 + " ");
            if(i<9){
                System.out.print(" ");
            }

            for(int j=0; j<my_grid.length; j++){
                print_my_grid_status(i,j);
            }
            System.out.print(" ".repeat(5));

            System.out.print(i+1 + " ");
            if(i<9){
                System.out.print(" ");
            }

            for(int j=0; j<my_grid.length; j++){
                print_target_grid_status(i,j);
            }

            System.out.print("\n");
        }
    }

    /**
     * Print the line at the top of the board with the letters
     */
    private void print_letter(){
        char letter = 'A';
        int counter = 0;
        while(counter<my_grid.length){
            System.out.print(letter + " ");
            counter++;
            letter++;
        }
    }

    /**
     * Print the (i,j) point of the gamer's grid
     * @param i line index of the grid
     * @param j column index of the grid
     */
    private void print_my_grid_status(int i,int j){
        System.out.print(". ");
    }

    /**
     * Print the (i,j) point of the target grid
     * @param i line index of the grid
     * @param j column index of the grid
     */
    private void print_target_grid_status(int i,int j){
        if(target_grid[i][j]){
            System.out.print("x ");
        }
        else{
            System.out.print(". ");
        }
    }
}