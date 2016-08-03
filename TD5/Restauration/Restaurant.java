
/**
 * Write a description of class Restaurant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Restaurant
{
    // instance variables - replace the example below with your own
    private String nom;
    private int nbPlaces;
    private double prixMenuDeuxPlats;
    private int nbVendusDeuxPlats;
    private int nbVendusTroisPlats;
    private int nbVendusCinqPlats;
    

    /**
     * Constructor for objects of class Restaurant
     */
    public Restaurant(String nom, int nbPlaces, double prixMenuDeuxPlats)
    {
        this.nom = nom;
        this.nbPlaces = nbPlaces;
        this.prixMenuDeuxPlats = prixMenuDeuxPlats;
        this.nbVendusDeuxPlats = 0;
        this.nbVendusTroisPlats = 0;
        this.nbVendusCinqPlats = 0;
    }

    /**
     * Methodes d'instances
     */
    
    // Renvoie le nombre de places encore disponibles dans le restaurant.
    public int nombrePlacesDisponibles()
    {
        return nbPlaces - (nbVendusDeuxPlats + nbVendusTroisPlats + nbVendusCinqPlats);
    }
    
    public void vendreMenus(int nombre, int quelMenu) throws MenuInexistantException, PasAssezDePlacesException
    {
        if(nombre < nombrePlacesDisponibles())
        {
            double prix = 0;
            if(quelMenu == 2)
            {
                nbVendusDeuxPlats += nombre;
                prix = nombre * prixMenuDeuxPlats;

            }
            else if(quelMenu == 3)
            {
                nbVendusTroisPlats += nombre;
                prix = nombre * (prixMenuDeuxPlats + (20 * prixMenuDeuxPlats / 100));
            }
            else if(quelMenu == 5)
            {
                nbVendusCinqPlats += nombre;
                prix = nombre * (prixMenuDeuxPlats + (50 * prixMenuDeuxPlats / 100));
            }
            else
            {
                throw new MenuInexistantException(quelMenu);
            }
          
            System.out.println("Prix à payer : "+prix);
        }
        else
        {
            throw new PasAssezDePlacesException(nombre);
        }
    }
    
    public void remiseAZero()
    {
        this.nbVendusDeuxPlats = 0;
        this.nbVendusTroisPlats = 0;
        this.nbVendusCinqPlats = 0;
    }
    
    public double chiffreAffaires()
    {
        return (prixMenuDeuxPlats * nbVendusDeuxPlats) + ((prixMenuDeuxPlats + (20 * prixMenuDeuxPlats / 100))* nbVendusTroisPlats) + ((prixMenuDeuxPlats + (50 * prixMenuDeuxPlats / 100))* nbVendusCinqPlats) ;
    }
    
    public double tauxRemplissage()
    {
       return  ( ((double) nbPlaces - (double) nombrePlacesDisponibles()) / (double) nbPlaces) * 100;
    }
    
    public int getNombrePlaces()
    {
       return nbPlaces; 
    }
    
    public int getNombreClients()
    {
        return nbPlaces - nombrePlacesDisponibles();
    }
    
    @Override
    public String toString()
    {
        return " Restaurant : "+nom+" \n Nombre de places : "+nbPlaces+" \n Prix menu deux plats :"+prixMenuDeuxPlats+" \n Nombre de menus à deux plats vendus : "+nbVendusDeuxPlats+" \n Nombre de menus à trois plats Vendus : "+nbVendusTroisPlats+" \n Nombre de menus à cinq plats vendus : "+nbVendusCinqPlats+"\n";
    }
    
    public void affichage()
    {
        System.out.println(toString());
    }
}
