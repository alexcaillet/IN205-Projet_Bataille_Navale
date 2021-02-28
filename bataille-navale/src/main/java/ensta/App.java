package ensta;
import ensta.ships.*;
import java.util.List;
import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        Game jeu = new Game();
        jeu.init().run();
    }
}
