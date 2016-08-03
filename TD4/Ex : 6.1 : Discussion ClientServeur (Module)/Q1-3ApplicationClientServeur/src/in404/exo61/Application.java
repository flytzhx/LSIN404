package in404.exo61;

import in404.exo61.client.Client;
import in404.exo61.serveur.Serveur;

/**
 * Write a description of class Application here.
 * 
 * @author Quenitn
 * @version 2016
 */
public class Application
{
    static public void main(String[] args)
    {
        Serveur s = new Serveur();
        Client c1 = new Client("Toto");
        Client c2 = new Client("Tata");
        Client c3 = new Client("Momo");
        
        c1.seConnecter(s);
        c2.seConnecter(s);
        c3.seConnecter(s);
        
        c3.envoyer("Bonjour");
	System.out.println("########################## TEST #######################################");

    }
}
