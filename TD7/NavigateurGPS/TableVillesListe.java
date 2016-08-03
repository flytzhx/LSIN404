import java.util.List;
import java.util.LinkedList;
/**
 * Write a description of class TableVillesListe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TableVillesListe implements TableVilles
{
    // Liste chainée d'objets Ville
    private LinkedList<Ville> villes ;

    /**
     * Constructor for objects of class TableVillesListe
     */
    public TableVillesListe()
    {
        this.villes = new LinkedList<Ville>();
    }
    
    /*
     * Méthodes d'instance
     */
    
    @Override
    public void ajouterVille(Ville v)
    {
        villes.add(v);
    }
    
    @Override
    public int nombreVilles()
    {
        return villes.size();
      
    }
    
    @Override
    public String infos()
    {
        return "Informations sur le jeu de données : \n Nombre de Villes : "+nombreVilles();
    }
    
    @Override 
    public LinkedList<Ville> traverser()
    {
        return villes;
    }
    
    @Override 
    public Ville rechercherVille(double latitude, double longitude)
    {
        for(Ville v : villes)
        {
            if(v.getLatitude() == latitude && v.getLongitude() == longitude)
                return v;
        }
        return null;
    }
    
   
}
