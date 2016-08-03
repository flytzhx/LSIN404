
/**
 * Abstract class Objet - write a description of the class here
 * 
 * @author Quentin
 * @version 2016
 */
public abstract class Objet
{
    // instance variables - replace the example below with your own
    protected String nom;

        
    /*
     * -----> Méthodes concrètes <------
     */
    
    /*
     * Accesseurs
     */
    
    public String getNom()
    {
        return this.nom;
    }
    
    @Override 
    public String toString()
    {
        return "Type : "+this.getClass().getName()+ "/ Nom : "+this.getNom()+" ";
    }
    
    
    /*
     * -----> Méthodes abstraites <------
     */
    
    abstract int getTaille();
}
