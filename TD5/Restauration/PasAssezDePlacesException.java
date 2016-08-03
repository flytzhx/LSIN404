
/**
 * Write a description of class PasAssezDePlacesException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PasAssezDePlacesException extends Exception
{
    // instance variables - replace the example below with your own
    private int nombreMenu;

    /**
     * Constructor for objects of class PasAssezDePlacesException
     */
    public PasAssezDePlacesException(int nbMenu)
    {
        super("Il n'ya pas assez de place dans le restaurant pour "+nbMenu+" menus");
        this.nombreMenu = nbMenu;
    }

    public int getNombreMenu()
    {
        return nombreMenu;
    }
}
