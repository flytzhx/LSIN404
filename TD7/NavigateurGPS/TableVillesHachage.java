import java.util.LinkedList;

public class TableVillesHachage implements TableVilles {

    //champs: un tableau de TableVilles (implementation par des listes) + une fonction de hachage
    public TableVilles[] table;
    public FonctionHachage hash;

    // constructeur
    public TableVillesHachage(int m, FonctionHachage hash) {
        
        this.table = new TableVilles[m];
        for(int i = 0; i<table.length; i++)
            table[i] = new TableVillesListe();
            
        this.hash = hash;
        
    }

    // ajoute une ville a la table
    public void ajouterVille(Ville v) {
        
        int i = hash.hashFunction(v.getLatitude(),v.getLongitude(),table.length);
        table[i].ajouterVille(v); 
    }

    // fonction de recherche d'une ville dans la table
    public Ville rechercherVille(double latitude,double longitude){
        
        int i = hash.hashFunction(latitude,longitude,table.length);
       
        return table[i].rechercherVille(latitude,longitude);
    }
    
    // fonction retournant le nombre de villes stoquees dans la table
    public int nombreVilles(){
         int nb = 0;
         for(TableVilles t : table)
            nb += t.nombreVilles();
         return nb;   
        }
         
         
    

    // fonction retournant le nombre de cases de la table contenant un ensemble non vide de villes
   public int remplissage(){
        int nb = 0;
        for(TableVilles tv : table)
        {
            if(tv.traverser().size() != 0)
            {
                nb++;
            }
        }
        return nb;
    }

    // fonction retournant le plus grand ensemble de villes dans la table
    public TableVilles elementMaximal(){
        TableVilles elmax = null;
        int nb = 0;
        for(TableVilles t : table)
        {
            if(t.nombreVilles() > nb)
            {
                nb = t.nombreVilles();
                elmax = t;
            }
        }
        return elmax;
                       
    }
    
    // Donne des infos sur l'ensemble
    public String infos() {
         return "Nombre de cases utilisés : "+remplissage()+" / élément maximal : Longueur : "+elementMaximal().nombreVilles();
    }

    //  Retourne une liste chainee contenant tous les elements stoques
    public LinkedList<Ville> traverser(){
        LinkedList<Ville> liste = new LinkedList<Ville>();
        for(TableVilles tv : table)
        {
            liste.addAll(tv.traverser());
        }
        return liste; 
  }
}
