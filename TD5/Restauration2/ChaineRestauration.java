import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class ChaineRestauration here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChaineRestauration
{
    // instance variables - replace the example below with your own
    private ArrayList<Restaurant> restaurants;

    /**
     * Constructor for objects of class ChaineRestauration
     */
    public ChaineRestauration()
    {
       this.restaurants = new ArrayList<Restaurant>();
    }

    /**
     Methodes d'instance
     **/
     
     public void ajouterRestaurant(Restaurant r)
     {
         if(r != null)
            restaurants.add(r);
     }
     
    public int taille()
    {
        return restaurants.size();
    }
     
    public ArrayList<Restaurant> getListeResto()
    {
        return restaurants;
    }
    
    public Restaurant getRestaurant(int i) throws RestaurantInexistantException
    {
        if(i>=1 && i <= restaurants.size())
            return restaurants.get(i-1);
        else
            throw new RestaurantInexistantException(i);
    }
              
}
