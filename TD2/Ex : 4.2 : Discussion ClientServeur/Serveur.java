import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Serveur here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Serveur
{
   /* Variables d'instance
    *   Permet de former la carte d'identité d'un objet
    *   Variable spécifique à une instance
    */
        // Liste des clients connectés au serveur.
        private List<Client> clients;
   
    /*
     * Méthodes - Constructeurs
     * Permet de créer un objet Serveur.
     */
     
    // On crée la liste des clients connectés au serveur. (Vide à la création du serveur)
    public Serveur()
    {
       clients = new ArrayList<Client>();
    }
    
  
    
    /*
     * Méthodes - Accesseurs
     * Permet d'accéder aux données des objets 
     */
    
 
    
    /*
     * Méthodes - Mutateurs
     * Permet de modifier les données des objets 
     */
    

    
    /*
     * Autres méthodes d'instance.
     * Permet la gestion des objets Serveur
     */
    
    // Permet au serveur de se connecter au client : ajoute le client auquel le serveur se connecte à la liste des clients.
    public boolean seConnecter(Client c)
    {
        if(c != null)
        {
            if(clients.add(c))
               return true;
        }
        return false;
    }
     
    // Permet au serveur de diffuser les messages à la liste des clients connectés.
    public void diffuser(String message)
    {
        if(message != null)
        {
            int i;
            for(i=0;i<this.clients.size();i++)
            {
                this.clients.get(i).recevoir(message);
            }
        }
    }
}