
/**
 * Write a description of class RestaurantInexistantException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RestaurantInexistantException extends ArrayIndexOutOfBoundsException
{
    private int numeroRestaurant;

    /**
     * Constructor for objects of class RestaurantInexistantException
     */
    public RestaurantInexistantException(int numResto)
    {
        super("Le restaurant avec le n°"+numResto+" n'existe pas.");
        this.numeroRestaurant = numResto;
    }
    
    public int getNumeroRestaurant()
    {
        return numeroRestaurant;
    }

}
