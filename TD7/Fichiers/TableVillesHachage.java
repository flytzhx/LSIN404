import java.util.LinkedList;

public class TableVillesHachage implements TableVilles {

	//champs: un tableau de TableVilles (implementation par des listes) + une fonction de hachage
	public TableVilles[] table;
	public FonctionHachage hash;

	// constructeur
	public TableVillesHachage(int m, FonctionHachage hash) {
		//completer
		
	}

	// ajoute une ville a la table
	public void ajouterVille(Ville v) {
		//completer
	}

	// fonction de recherche d'une ville dans la table
	public Ville rechercherVille(double latitude,double longitude){
		//completer
		return null;
	}
	
	// fonction retournant le nombre de villes stoquees dans la table
	public int nombreVilles(){
		//completer
		return 0;
	}

	// fonction retournant le nombre de cases de la table contenant un ensemble non vide de villes
	public int remplissage(){
		//completer
		return 0;
	}

	// fonction retournant le plus grand ensemble de villes dans la table
	public TableVilles elementMaximal(){
		// completer
		return null;	
	}
	
	// Donne des infos sur l'ensemble
	public String infos() {
		//completer
	  return null;
	}

	//  Retourne une liste chainee contenant tous les elements stoques
	public LinkedList<Ville> traverser(){
		// completer
		 return null;	
  }
}