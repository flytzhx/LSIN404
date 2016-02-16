
/**
 * Write a description of class ChaineCryptee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EncryptedString
{
   /* Variables d'instance
    *   Permet de former la carte d'identité d'un objet
    *   Variable spécifique à une instance
    */
        // Chaine cryptée
        private String chaine;
        // Clé de chiffrement
        private int cle;
   

    /* ############################################################################# Modèle de conception FABRICATION. ############################################################################
     * 
     * Les langages orientés objet doivent généralement avoir un nom de constructeur identique au nom de la classe, ce qui peut être ambigu s'il existe plusieurs constructeurs (par surcharge)
     * qui crééent un même objet à partir de données différentes.
     * Les méthodes de fabrication n'ont pas cette obligation et peuvent avoir un nom qui décrit mieux leur fonction.
     * Ici, la chaine de caractères cryptée peut être créée à partir d'une chaine déja cryptée ou d'une chaine claire ; l'utilisation de méthodes de fabrication ne laisse aucune ambiguïté :
     */
    
    /*
     * Méthodes - Fabrication
     * Méthodes de classe qui permettent de traiter les données avant de les envoyer au constructeur.
     * Elles retournent un objet de classe EncryptedString : l'objet créé grâce à new + constructeur().
     */
    
    /** Créer la chaine cryptée d'une instance EncryptedString à partir d'une chaine déja cryptée.
     *  On envoie directement la chaine cryptée et la clé au constructeur pour qu'il créée l'objet.
     */
    public static EncryptedString FromCrypted(String chaine, int cle)
    {
       if(chaine != null)
       {
           return new EncryptedString(chaine, cle);
       }
       return new EncryptedString();
    }
   
    /** Créer la chaine cryptée d'une instance EncryptedString à partir d'une chaine claire (non cryptée).
     * On crypte la chaine en claire, et on envoie la chaine cryptée et la clé au constructeur pour qu'il créée l'objet.
     */
    public static EncryptedString FromDecrypted(String chaine, int cle)
    {
       if(chaine != null)
       {
           String chaineCryptee = "";
           int i;
           for(i=0;i<chaine.length();i++)
           {
               chaineCryptee += decaleCaractere(chaine.charAt(i), cle);
           }
        
           return new EncryptedString(chaineCryptee, cle);
       }
       return new EncryptedString();
    }
     
    /*
     * Méthodes - Constructeurs
     * Permet de créer un objet EncryptedString.
     */
    
    /** Créer une instance de ChaineCryptee c'est à dire une chaine et sa clé de chiffrement. L'objet n'est pas créé si la chaine de caractère entrée est null. 
     *  Le constructeur de la classe est ici privé, ce qui oblige à utiliser les méthodes de fabrication qui ne prêtent pas à confusion.
     */
    private EncryptedString(String chaine, int cle)
    {
        if(chaine != null)
        {
            this.chaine = chaine;
            this.cle = cle;
        }
       
    }
    
    private EncryptedString()
    {
        if(chaine != null)
        {
            this.chaine = "Aucune chaine";
            this.cle = -1;
        }
       
    }
    // Rq : Les méthodes de fabrication et de conception sont des méthodes de Classe.
    
    /* ########################################################################## FIN - Modèle de conception FABRICATION. ######################################################################### */
    
    /*
     * Méthodes - Accesseurs
     * Permet d'accéder aux données des objets EncryptedString.
     */
    
    /** Récupère la chaine. */
    public String getChaine()
    {
        return this.chaine;
    }
    
    /** Récupère la clé de chiffrement */
    public int getCle()
    {
        return this.cle;
    }
    
    
    
    /*
     * Méthodes - Mutateurs
     * Permet de modifier les données des objets ChaineCryptee
     */
    
    /** Modifie la chaine */
    public void setChaine(String chaine)
    {
        this.chaine = chaine;
    }
    
    /** Modifie la clé de chiffrement */
    public void setCle(int cle)
    {
        this.cle = cle;
    }
    
    
    /*
     * Autres méthodes d'instance.
     * Permet la gestion des objets EncryptedString
     */
    
    /** Crypte la chaine. */
    public String crypt()
    {
        String chaineCryptee = "";
        int i;
        for(i=0;i<this.chaine.length();i++)
        {
            chaineCryptee += decaleCaractere(this.chaine.charAt(i), this.cle);
        }
        return chaineCryptee;
    }
    
    /** Decrypte la chaine */
    public String decrypt()
    {
        String chaineDecryptee = "";
        int i;
        for(i=0;i<this.chaine.length();i++)
        {
            chaineDecryptee += decaleCaractere(this.chaine.charAt(i), -this.cle);
        }
        return chaineDecryptee;
    }
    
    /** Décale un caractère majuscule. */
    private static char decaleCaractere(char c, int decalage)
    {
        return (c < 'A' || c > 'Z') ? c : (char) (((c - 'A' + decalage) % 26) + 'A');
    }
    
  
}
