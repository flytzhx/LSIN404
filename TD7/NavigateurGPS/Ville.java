
/**
 * Write a description of class Ville here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ville implements Comparable<Ville>
{
    // Nom de la Ville
    private String nom;
    // Latitude de la Ville
    private double latitude;
    // Longitude de la ville
    private double longitude;

    /**
     * Constructor for objects of class Ville
     */
    
    // Construit une instance de Ville
    public Ville(String nom, double latitude, double longitude)
    {
        this.nom = nom;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    
    /*
     * Méthodes d'instances
     */
        
    public String getNom()
    {
        return nom;
    }
    
    public double getLatitude()
    {
        return latitude;
    }
    
    public double getLongitude()
    {
        return longitude;
    }
    
    @Override
    public String toString()
    {
        return "Nom de la Ville : "+nom+" / Latitude : "+latitude+" / Longitude : "+longitude+"\n";
    }
    
    @Override
    public int compareTo(Ville v)
    {
        if(getLatitude() == v.getLatitude())
        {
            if(getLongitude() < v.getLongitude())
                return -1;
            else if(getLongitude() > v.getLongitude())
                return 1;
            else
                return 0;
        }
        else
        {
            if(getLatitude() < v.getLatitude())
                return -1;
            else
                return 1;
        }
    }
    
 
    public int compareTo(double latitude, double longitude)
    {
        if(getLatitude() == latitude)
        {
            if(getLongitude() < longitude)
                return -1;
            else if(getLongitude() > longitude)
                return 1;
            else
                return 0;
        }
        else
        {
            if(getLatitude() < latitude)
                return -1;
            else
                return 1;
        }
    }
    

    
}
