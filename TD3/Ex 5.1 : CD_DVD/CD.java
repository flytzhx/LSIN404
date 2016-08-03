
/**
 * Write a description of class CD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CD extends Document
{
    // instance variables - replace the example below with your own
    private String artiste;
    private int nbTitres;

    /**
     * Constructor for objects of class CD
     */
    public CD(String titre, String artiste, int nbTitres)
    {
        super(titre);
        this.artiste = artiste;
        this.nbTitres = nbTitres;
    }

    /*
     * Accesseurs
     */
    
    public String getArtiste()
    {
        return this.artiste;
    }
   
    public int getNbTitres()
    {
        return this.nbTitres;
    }
    
    @Override
    public String toString()
    {
        return "CD : "+ super.toString() +" Artiste : "+artiste+" / - Nombre de titres : " + nbTitres +"\n";
    }
    
      /*
     * Mutateurs
     */
   
    
    public void setArtiste(String artiste)
    {
        this.artiste = artiste;
    }
    
    public void setNbTitres(int nbTitres)
    {
        this.nbTitres = nbTitres;
    }
    
    /*
     *  Autres Méthodes 
     */
    
    @Override
    public boolean contient(String motcle)
   {
       if(motcle != null)
       {
           if(super.contient(motcle) || artiste.contains(motcle)) 
                return true;
       }
       return false;
   }
}


    
