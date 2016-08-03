
public class H2 implements FonctionHachage {
	
	// coordonnees de la boite englobante (qui contient toutes les villes de France)
	static double longMin=-10., longMax=10.;
	static double latMin=40., latMax=60.;

	public int hashFunction(double latitude, double longitude, int m) {
	    
		return (int) Math.floor((latitude - latMin)/((latMax - latMin) / m));
		
	}
	

}