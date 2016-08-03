
/**
 * Write a description of class Document here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Document
{
    // instance variables - replace the example below with your own
    private String titre;

    /**
     * Constructor for objects of class Document
     */
    public Document(String titre)
    {
       this.titre = titre;
    }

    /*
     * Accesseurs
    */
   
   public String getTitre()
   {
       return this.titre;
   }
   
   
   public String toString()
   {
       return " Titre : "+ getTitre();
   }
   
   /*
    * Mutateurs
    */
   
   public void setTitre(String titre)
   {
       this.titre = titre;
   }
   
   
   /*
    * Autres Méthodes
    */
   
   public boolean contient(String motcle)
   {
       if(motcle != null)
       {
           if(titre.contains(motcle))
                return true;
       }
       return false;
   }
   
   
}
