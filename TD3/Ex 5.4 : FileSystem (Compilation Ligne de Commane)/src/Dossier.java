import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class Dossier here.
 * 
 * @author Quentin
 * @version 2016
 */

// Modèle Conception Composite : Class Dossier => Objet Composite
public class Dossier extends Objet
{
    // Le contenu d'un dissier est une liste d'éléments Objet.
    private ArrayList<Objet> contenu;

    /**
     * Constructor for objects of class Dossier
     */
    // Création d'un dossier avec un nom et une liste d'éléments Objets.
    public Dossier(String nom)
    {
        this.nom = nom;
        this.contenu = new ArrayList<Objet>();
    }
    
    // Ajoute un objet dans un repertoire. (Fichier ou autre Dossier)
    public boolean ajoutObjet(Objet obj)
    {
        if(obj != null && this != obj)  // On vérifie que l'objet n'est pas null et si qu'il ne s'agit pas de lui même.
        {
            // Si l'objet est un dossier, on vérifie qu'il ne contient pas le dossier dans lequel on souhaite l'ajouter.
            if(obj instanceof Dossier)
            {
                if(verifDescendance((Dossier)obj, this))  // On change le type indifferencié Objet en Dossier pour utiliser la fonction verifDescendance.
                    return false;
            }
             
            if(contenu.add(obj))
                return true;
        }
        return false;
    }
    
    // Vérifie si le Dossier 2 est contenu dans le Dossier 1 donner en entrée : Renvoie vrai si c'est le cas, faux sinon.
    // Fonction récursive, on re-apelle verifDescendance jusqu'à ce qu'on trouve le dossier 1 ou jusqu'à ce qu'il n'y est plus de dossiers parmi la descendance du dossier entré.
    private boolean verifDescendance(Dossier dos1, Dossier dos2)
    {
        if(dos1 !=null && dos2 != null)
        {
            for(int i=0; i<dos1.contenu.size(); i++)
            {
                if(dos1.contenu.get(i) instanceof Dossier)
                {
                     if(dos1.contenu.get(i) == dos2) { return true;}
                     else { verifDescendance((Dossier)dos1.contenu.get(i), dos2); }  //On change le type indifferencié Objet en Dossier pour utiliser la fonction verifDescendance.
                }    
            }
        }
        return false;
    
    }
            
            
    
    
    
    // Donne la taille du dossier
    // Redéfinie pour celà la méthode abstraite getTaille() de la classe Objet
    //
    // Principe : On parcourt tout le contenu du dossier et on récupère la taille de chaque élément, deux cas possibles :
    //      - si l'élément est un fichier, la méthode getTaille() redéfinie dans la classe Fichier est appelée.
    //      - si l'élément est un dossier, la méthode getTaille() redéfinie dans la classe Dossier est appelée (celle ci -> recursivité).
    //
    // Explications : - Le contenu d'un dossier est une liste d'éléments Objet, il peut s'agir aussi bien de Fichier que de Dossier car ces deux classes héritent de la classe abstraite Objet.
    //                      -> Covariance de la liste contenu.
    //                - Définir la méthode abstraite getTaille() dans la classe abstraite Objet permet d'appliquer la fonction à tous les éléments Objet de la liste indépendamment de leur type. 
    //                  Sa redéfinition dans les classes Fichier et Dossier permet ensuite de traiter l'opération de manière spécifique (selon la classe).
    //                      -> getTaille() est une méthode polymorphe
 
    @Override
    public int getTaille()
    {
        int taille = 0;
        for(int i = 0; i<contenu.size(); i++)
        {
            taille += contenu.get(i).getTaille();
        }
        return taille;
    }
    
    @Override
    public String toString()
    {
        return super.toString()+" / Taille : "+getTaille()+"ko \n";
    }
}
