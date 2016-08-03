
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Collection here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Collection
{
    // instance variables - replace the example below with your own
    private List<Document> documents;

    /**
     * Constructor for objects of class Collection
     */
    public Collection()
    {
        this.documents = new ArrayList<Document>();
    }
    
    /*
     * Accesseurs
     */
    
    // Lister les documents de la collection (en affichant une chaine de caractères)
    public String listerDocuments()
    {
        String str = "";
        for(int i = 0; i<this.documents.size(); i++)
        {
            str += this.documents.get(i).toString();
        }
        return str;
    }
    
    /*
    // Lister les documents de la collection (en retournant simplement la liste de documents)
    public String listerDocuments()
    {
       return this.documents;
    }
    */
   
    /*
     * Autres méthodes d'instance
     */
    
    // Ajouter un document dans la collection
    public boolean ajouterDocument(Document doc)
    {
        if(doc != null)
        {
            if(this.documents.add(doc))
                return true;
        }
        return false;
    }
    
    // Recherche et renvoie la liste des documents contenant un mot clé (dans le titre et/ou l'artiste/réalisateur)
   
    public List<Document> rechercherDocuments(String motcle)
    {
 
        if(motcle != null)
        {
             List<Document> ListDoc = new ArrayList<Document>();
             Document doc;
             for(int i = 0; i<this.documents.size(); i++)
             {
                 doc = this.documents.get(i);
                 if(doc.contient(motcle))
                 {
                    ListDoc.add(doc); 
                 }
             }
             return ListDoc;
        }
        
        return null;
    }
 
}
