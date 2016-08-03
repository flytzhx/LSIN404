
/**
 * Write a description of class Fichier here.
 * 
 * @author Quentin 
 * @version 2016
 */

// Modèle Conception Composite : Class Fichier => Objet Simple
public class Fichier extends Objet
{
    // instance variables - replace the example below with your own
    private int taille;

    /**
     * Constructor for objects of class Fichier
     */
    public Fichier()
    {
        this.nom = "inconnu";
        this.taille = 0;
    }
    
    public Fichier(String nom, int taille)
    {
        this.nom = nom;
        this.taille = taille;
    }
    
    /*
     * Accesseurs
     */
    
    @Override
    public int getTaille()
    {
        return this.taille;
    }
    
    @Override
    public String toString()
    {
        return super.toString() + "Taille : " +getTaille()+"ko \n";
    }

}
