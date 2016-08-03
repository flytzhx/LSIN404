import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.EOFException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;

/**
 * Write a description of class Enregistreur here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enregistreur
{
    private File fichier;

    /**
     * Constructor for objects of class Enregistreur
     */
    public Enregistreur(String fic)
    {
        if(fic != null)
            fichier = new File(fic);
    }
    
    public void ecrire(Joueur nouveauJoueur)
    {
        if((!fichier.exists()) || (fichier.length() == 0))
        {
            try( FileOutputStream fos = new FileOutputStream(fichier); ObjectOutputStream sortie = new ObjectOutputStream(fos))
            {
                sortie.writeObject(nouveauJoueur);
            }
            catch(FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
           try(FileInputStream fis = new FileInputStream(fichier); ObjectInputStream entree = new ObjectInputStream(fis);
               FileOutputStream fos = new FileOutputStream("temp.bin"); ObjectOutputStream sortie = new ObjectOutputStream(fos))
           {
               boolean finDeFichier = false;
               boolean joueurDejaPresent = false;
               while(!finDeFichier)
               {
                   try
                   {
                       Joueur joueurEnCours = (Joueur) entree.readObject();
                       if(joueurEnCours.getNom().equals(nouveauJoueur.getNom()))
                       {
                           sortie.writeObject(nouveauJoueur);
                           joueurDejaPresent = true;
                       }
                       else
                       {
                           sortie.writeObject(joueurEnCours);
                       }
                   }
                   catch(ClassNotFoundException e)
                   {
                       e.printStackTrace();
                   }
                   catch(EOFException e)
                   {
                       finDeFichier = true;
                   }
                   catch(IOException e)
                   {
                       e.printStackTrace();
                   }
               }
               
               if(!joueurDejaPresent)
                    sortie.writeObject(nouveauJoueur);
           }
           catch(FileNotFoundException e)
           {
               e.printStackTrace();
           }
           catch(IOException e)
           {
               e.printStackTrace();
           }
           
           try
           {
              
               String nomFichier = fichier.getName();
               fichier.delete();
               
               Path fichierTemp = Paths.get("temp.bin");
               Path fichierScore = Paths.get(nomFichier);
               Files.copy(fichierTemp, fichierScore);
               Files.delete(fichierTemp);
           } 
           catch(FileNotFoundException e)
           {
               e.printStackTrace();
           }
           catch(IOException e)
           {
               e.printStackTrace();
           }
           
           
        }
        
    }
    
    public void afficher() 
    {
       if(!(fichier.length() == 0))
        {
            try
            (
                FileInputStream fis = new FileInputStream(fichier);
                ObjectInputStream entree = new ObjectInputStream(fis);
            )
            {
                boolean finDuFichier = false;
                System.out.println(" #########################################################################################################");
                System.out.println(" ################################### Contenu du fichier de sauvegarde ####################################");
                System.out.println(" #########################################################################################################");
                while(!finDuFichier)
                {
                    try{
                        Joueur joueurCourant = (Joueur) entree.readObject();
                        System.out.println(joueurCourant.toString());
                    }
                    catch(EOFException e)
                    {
                        finDuFichier = true;
                    }
                    catch(ClassNotFoundException e)
                    {
                        e.printStackTrace();
                    }
                }
                System.out.println(" ################################### Fin du fichier de sauvegarde ####################################");
            
            }
            catch(FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
             System.out.println("----> Le fichier de sauvegarde est vide <----");
        }
    }
    
}
