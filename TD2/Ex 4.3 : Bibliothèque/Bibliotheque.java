import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Bibliotheque here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bibliotheque
{
   /* Variables d'instance
    *   Permet de former la carte d'identité d'un objet
    *   Variable spécifique à une instance
    */
        // Nom de la Bibliotheque
        private String nom;
        // Liste des documents contenus dans la bibliotheque
        private List<Document> documents;
       
   
    /*
     * Méthodes - Constructeurs
     * Permet de créer un objet Bibliothèque.
     */
     
    // On crée la Bibliotheque : nom + liste de documents
    public Bibliotheque(String nom)
    {
        this.nom = nom;
        this.documents = new ArrayList<Document>();
    }
   
    
  
    
    /*
     * Méthodes - Accesseurs
     * Permet d'accéder aux données des objets 
     */
    
    // Récupère le nom de la blibiothèque
     public String getNom()
     {
         return this.nom;
     }
     
 
    
    /*
     * Méthodes - Mutateurs
     * Permet de modifier les données des objets 
     */
    
    // Modifie le nom de la blibiothèque
     public void setNom(String nom)
     {
         this.nom = nom;
     }
     
    

    
    /*
     * Autres méthodes d'instance.
     * Permet la gestion des objets Serveur
     */
     
     // Ajoute un document dans la blibiothèque.
     public boolean ajoutDocument(Document doc)
     {
         if(doc != null)
         {
             if(this.documents.add(doc))
                return true;
         }
         return false;
     }
     
     // Recherche un document (à partir de son titre) dans la blibiothèque.
     public boolean rechercheDocument(String titre)
     {
         if(titre != null)
         {
             int i;
             for(i=0;i<this.documents.size(); i++)
             {
                 if(this.documents.get(i).getTitre() == titre)
                    return true;
             }
         }
         return false;
      }
      
      // Recherche et affiche des documents citant un document.
      public String rechercheDocEnRelation(String titre)
      {
         String affichageDocs = " "; // Affiche les documents en relation
         
         if(titre != null)
         {
             int i;
             Document docEnCours;  // Permet d'avoir le document en cours d'analyse (simplifie la lisibilité)
             List<Document> refDocEnCours = new ArrayList<Document>(); // Permet d'avoir la liste des références du document en cours d'analyse (simplifie la lisibilité)
                                                                       // Il faut bien penser à créer une nouvelle liste en mémoire pour récupérer la liste des références d'un document.
             // 1ère boucle : On parcourt tous les docs de la blibiothèque
             // 2eme boucle : On parcourt les références du docs en cours
             
             for(i=0;i<this.documents.size(); i++)
             {
                 int j;
                 docEnCours = this.documents.get(i);
                 refDocEnCours = docEnCours.getReference();
    
                 
                 // Rq : On est obligé d'utiliser les accesseurs de la classe Document pour accéder aux références et aux titre d'un document car les variables d'instances sont privées (donc accessible que depuis
                 //      la classe Document)
                 
                 for(j=0;j<refDocEnCours.size();j++)
                 {
                     if(refDocEnCours.get(j).getTitre() == titre)
                        affichageDocs += docEnCours.getTitre() + "\n";
                     
                }
             }
            
         }
         
         return affichageDocs;
          
          
      }
      
   }