import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Document here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Document
{
   /* Variables d'instance
    * Permet de former la carte d'identité d'un objet
    * Variable spécifique à une instance
    */
     
     // Titre du document
     private String titre;
     // Auteur du document
     private String auteur;
     // Année de publication du document
     private int annee;
     // Références du document : Liste de documents traitant du même sujet 
     private List<Document> references;
      
       
   
    /*
     * Méthodes - Constructeurs
     * Permet de créer un objet Serveur.
     */
     
     public Document(String titre, String auteur, int annee)
     {
         this.titre = titre;
         this.auteur = auteur;
         this.annee = annee;
         this.references = new ArrayList<Document>();
     }
         
       
    
    /*
     * Méthodes - Accesseurs
     * Permet d'accéder aux données des objets 
     */
     
    // Récupère le titre d'un document
     public String getTitre()
     {
         return this.titre;
     }
     
    // Récupère l'auteur d'un document
    public String getAuteur()
    {
        return this.auteur;
    }
    
    // Récupère la date de parution d'un document
    public int getAnnee()
    {
        return this.annee;
    }
     
    // Récupère la liste de références d'un document
    public List<Document> getReference()
    {
        return this.references;
    }
     
     public String affichage()
     {
         String affichage;
         int i;
         affichage = "Titre : "+ this.titre +"\n Auteur : "+ this.auteur +"\n Références : ";
         for(i=0; i<this.references.size(); i++)
         {
             affichage += this.references.get(i).titre +"\n";
         }
         return affichage;
     }
 
    
    /*
     * Méthodes - Mutateurs
     * Permet de modifier les données des objets 
     */
     
     // Modifie le titre d'un document
     public void setTitre(String titre)
     {
         this.titre = titre;
     }
     
    // Modifie l'auteur d'un document
     public void setAuteur(String auteur)
     {
         this.auteur = auteur;
     }
     
    
     // Modifie l'année de parution d'un document
     public void setAnnee(int annee)
     {
         this.annee = annee;
     }
     
    
    /*
     * Autres méthodes d'instance.
     * Permet la gestion des objets Serveur
     */
    
     // Ajout d'une référence à un document.
     public boolean ajoutReference(Document reference)
     {
         if(reference != null)
         {
             if(this.references.add(reference))
                return true;
         }
         return false;
     }
     
     
     
}