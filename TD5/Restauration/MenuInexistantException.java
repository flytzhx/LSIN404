
/**
 * Write a description of class MenuInexistantException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuInexistantException extends Exception
{
    // instance variables - replace the example below with your own
    private int numeroMenu;

    /**
     * Constructor for objects of class MenuInexistantException
     */
    public MenuInexistantException(int numMenu)
    {
        super("Un menu à "+numMenu+" plats n'est pas disponible dans ce restaurant");
    }

    public int getNumeroMenu()
    {
        return numeroMenu;
    }
}
