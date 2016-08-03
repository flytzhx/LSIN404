public class Application
{
	public static void main(String[] args)
	{
		Fichier f1 = new Fichier("Chat", 20);
		Fichier f2 = new Fichier("Chien", 30);

		Dossier d1 = new Dossier("Métazoaires");
		Dossier d2 = new Dossier("Eumétazoaires");
		Dossier d3 = new Dossier("Bilatériens");

		d1.ajoutObjet(d2);
		System.out.println(d1.toString());
		d2.ajoutObjet(d3);
		System.out.println(d2.toString());
		d3.ajoutObjet(f1);
		System.out.println(d3.toString());
		d3.ajoutObjet(f2);
		System.out.println(d3.toString());

		System.out.println(f1.toString());
		System.out.println(f2.toString());

		System.out.println("Taille du dossier Métazoaires : " +d1.getTaille()+"ko");

	}
}