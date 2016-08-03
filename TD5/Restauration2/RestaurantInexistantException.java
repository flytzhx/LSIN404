
/**
 * Write a description of class RestaurantInexistantException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RestaurantInexistantException extends ArrayIndexOutOfBoundsException
{
    private int numeroResto;
    
    public RestaurantInexistantException(int num)
    {
        super("Le restaurant avec numéro "+num+" n'éxiste pas.");
        numeroResto = num;
    }
}
