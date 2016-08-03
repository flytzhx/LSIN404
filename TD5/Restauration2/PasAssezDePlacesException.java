
/**
 * Write a description of class PasAssezDePlaceException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PasAssezDePlacesException extends IllegalArgumentException
{
   private int nombrePlaces;
   
    /**
     * Constructor for objects of class PasAssezDePlaceException
     */
    public PasAssezDePlacesException(int nombre)
    {
        super("Il n'y a pas assez de places disponibles dans le restaurant.");
        nombrePlaces = nombre;
    }
    
    public int getNombrePlaces()
    {
        return nombrePlaces;
    }
}
