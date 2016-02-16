/**
 * Write a description of class Client here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Client
{
   /* Variables d'instance
    *   Permet de former la carte d'identité d'un objet
    *   Variable spécifique à une instance
    */
        // Nom du client
        private String nom;
        // Serveur auquel le client se connecte
        private Serveur serveur;
        
   
    /*
     * Méthodes - Constructeurs
     * Permet de créer un objet EncryptedString.
     */
     
    public Client(String nom)
    {
        if(nom != null)
        {
            this.nom = nom;
            this.serveur = null;
        }
    }
    
  
    
    /*
     * Méthodes - Accesseurs
     * Permet d'accéder aux données des objets 
     */
    
    public String getNom()
    {
        return this.nom;
    }
    
    public Serveur getServeur()
    {
        return this.serveur;
    }
 
    
    /*
     * Méthodes - Mutateurs
     * Permet de modifier les données des objets 
     */
    
    public void setNom(String nom)
    {
        this.nom = nom;
    }
    
    public void setNom(Serveur serveur)
    {
        this.serveur = serveur;
    }
    
    /*
     * Autres méthodes d'instance.
     * Permet la gestion des objets 
     */
    
     public boolean seConnecter(Serveur s)
     {
         if(s != null)
         {
             this.serveur = s;
             return true;
         }
         return false;
     }
     
    public void envoyer(String message)
    {
        if(message != null)
        {
            this.serveur.diffuser(message);
        }
    }
    
    public String recevoir(String message)
    {
        return message;
    }
     
}