
public class TestARemplir {
	/*
	 * remplissage d'un ensemble à l'aide d'un fichier texte 
	 */
	public static void remplir(TableVilles table, String fichier)  {
		
        // A completer
	}
		
		
	
	  
	/*
	 * Fonction de recherche d'une ville par ses coordonnees
	 */
	public static String rechercherVille(TableVilles table, double latitude, double longitude){
		
        // A completer
        
		return null;
	}
	
	/*
	 * Main
	 */
	public static void main(String[] args){
		long start = System.nanoTime(); // demarrage d'un chronometre

		/* Choix de l'implementation: */
		TableVilles table = new TableVillesListe(); // implementation par une liste
		//FonctionHachage h = new H1();//implementation par une table de hachage
		//TableVilles table = new TableVillesHachage(10000,h);//implementation par une table de hachage		
		
		//On remplit notre table
		
		/* Choix du jeu de donnees: */
		//remplir(table,"france_echantillon.txt");// modifier pour tester les autres fichiers 
		remplir(table,"france_all.txt");// modifier pour tester les autres fichiers 

		long temps = (System.nanoTime() - start)/1000000; // temps de calcul en millisecondes
		System.out.println("Temps de calcul construction de l'ensemble:    " + temps + " millisecondes");
		// Recherche de quelques villes
	        start=System.nanoTime(); // demarrage d'un chronometre
    		System.out.println(rechercherVille(table,44.2666667,4.1166667));
	    	System.out.println(rechercherVille(table,47.9833333,-4.3166667));
    		System.out.println(rechercherVille(table,46.5833333,1.5166667));
	        temps= (System.nanoTime() - start)/1000; // temps de calcul en microsecondes
        	System.out.println("Temps de calcul de la recherche : "+temps+" microsecondes");
	        //Informations sur la structure de donnees 
        	System.out.println();
	        System.out.println("Informations sur le jeux de donnees:");
		System.out.println("Nombre de villes: "+table.nombreVilles());
		System.out.println(table.infos());

		
	}
}
