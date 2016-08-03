import java.util.Scanner;
import java.io.IOException;
/**
 * Write a description of class Application here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Application
{
    public static void main(String[] args)
    {
        Enregistreur enr = null;
        try
        {    
            enr = new Enregistreur(args[0]);
            Scanner sc = new Scanner(System.in);
            boolean AjoutJoueur = false; 
            
            while(!AjoutJoueur)
            {
                System.out.println("Entrer le nom du joueur et son score, sous la forme : {joueur} {score}");
                Joueur j  = new Joueur(sc.nextLine());
               
                    enr.ecrire(j);
               
              
                System.out.println("Souhaitez vous ajouter un autre joueur ? (Oui/Non)");
                if(sc.nextLine().equals("Non"))
                    AjoutJoueur= true;
                
            }
             
                enr.afficher();
           
 
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            e.getMessage();
        }
      
    
            
        
    }
}
