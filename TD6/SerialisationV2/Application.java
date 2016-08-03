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
    public static void main(String args[])
    {
        Scanner sc = null;
        try
        {
            Enregistreur enr = new Enregistreur(args[0]);
          
            sc = new Scanner(System.in);
            boolean AjoutScore = true;
            while(AjoutScore)
            {
                System.out.println("Entrer le nom du joueur et le score : ");
                Joueur j = new Joueur(sc.nextLine());
               
                enr.ecrire(j);
                    
                System.out.println("Ajouter un autre score ? (Oui/Non) ");
                if(sc.nextLine().equals("Non"))
                    AjoutScore = false;
            }
                
            
            enr.afficher();
              
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            e.printStackTrace();
        }
        finally
        {
             if(sc != null)
                sc.close();
        }
        
}
}
