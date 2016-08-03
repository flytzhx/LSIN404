import java.io.FileReader;
import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.IOException;
/**
 * Write a description of class MoyenneElevee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MoyenneElevee
{
    public static void main()
    {
        BufferedReader f1 = null;
      
        try
        {   
            f1 = new BufferedReader( new FileReader("EtudiantsNotes.txt"));
            
            String ligne;
            String nom = "";
            double moyenneMax = 0;
            double moyenne = 0;
            double nbNote = 0;
            while((ligne = f1.readLine()) != null)
            {
                moyenne = 0;
                nbNote = 0;
                String[] mots = ligne.split(" "); // Découpe la ligne (au niveau des espaces) pour former un tableau de mots. mots[0] = nom de l'étudiant, nom[1] = première note, nom[2] = deuxieme note, etc..
              
               
                int i = 0;
                for(i = 1; i<mots.length; i++)
                { 
                    moyenne += Double.parseDouble(mots[i]);
                    nbNote++;
                }
                moyenne /= nbNote;
                
                if(moyenne > moyenneMax)
                {
                    moyenneMax = moyenne;
                    nom = mots[0];
                }
            }
            
            System.out.println(nom+" a la plus grande moyenne : "+moyenneMax);
            
   
                
        }
        catch(FileNotFoundException e)
        {
            e.getMessage();
        }
        catch(IOException e)
        {
            e.getMessage();
        }
        finally
        {
            try
            {
                if(f1 != null)
                    f1.close();
            }
            catch(IOException e)
            {
                e.getMessage();
            }
                    
        }
        
    }
}
