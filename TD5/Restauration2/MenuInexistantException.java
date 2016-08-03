
/**
 * Write a description of class MenuInexistantException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuInexistantException extends IllegalArgumentException
{
    // instance variables - replace the example below with your own
    private int numeroMenu;

    /**
     * Constructor for objects of class MenuInexistantException
     */
    public MenuInexistantException(int num)
    {
        super("Un menu à "+num+" plats n'est pas disponible dans ce restaurant.");
        numeroMenu = num;
    }

    public int getNumeroMenu()
    {
        return numeroMenu;
    }
}
