import java.util.LinkedList;

/**
 * Interface definissant la structure de donnees abstraites d'un ensemble de villes
 */
public interface TableVilles {

	/**
	 * Ajoute une ville a l'ensemble. On supposera que la ville n'est pas presente 
	 */	
	public void ajouterVille(Ville v);

	/**
	 * Teste si une ville est presente avec les coordonnees passees en parametre. Si oui on retourne la ville, sinon on retourne null
	 */	
	public Ville rechercherVille(double latitude,double longitude);
	
	/**
	 * Renvoie le nombre de villes de l'ensemble
	 */	
	public int nombreVilles();
	
	
	/**
	 * Donne des infos sur l'ensemble (taille par exemple)
	 */
	public String infos();
	
	/**
	 * Renvoie une liste contenant tous les elements de l'ensemble
	 */
	public LinkedList<Ville> traverser();
	
}
