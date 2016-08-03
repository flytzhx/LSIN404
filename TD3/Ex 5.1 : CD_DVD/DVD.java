
/**
 * Write a description of class DVD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DVD extends Document
{
    // instance variables - replace the example below with your own
    private String realisateur;
    private int annee;
    

    /**
     * Constructor for objects of class DVD
     */
    public DVD(String titre, String realisateur, int annee)
    {
        super(titre);
        this.realisateur = realisateur;
        this.annee = annee;
    }

    /*
     * Accesseurs
     */
    
    public int getAnnee()
    {
        return this.annee;
    }
   
     public String getRealisateur()
    {
        return this.realisateur;
    }
    
    
    @Override
    public String toString()
    {
        return "DVD : "+ super.toString() +" Réalisateur : "+realisateur+" / - Année de sortie : " +annee+"\n";
    }
    
    /*
     * Mutateurs
     */
    
    public void setAnnee(int annee)
    {
        this.annee = annee;
    }
    public void setRealisateur(String realisateur)
    {
        this.realisateur = realisateur;
    }
    
    /*
     * Autres méthodes
     */
    
    @Override
    public boolean contient(String motcle)
   {
       if(motcle != null)
       {
           if(super.contient(motcle) || realisateur.contains(motcle)) 
                return true;
       }
       return false;
   }

}