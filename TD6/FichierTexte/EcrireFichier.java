import java.io.FileWriter;
import java.io.BufferedWriter;

import java.io.RandomAccessFile;

import java.io.FileNotFoundException;
import java.io.IOException;

// Ou juste import java.io.*
/**
 * Write a description of class EcrireFichier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EcrireFichier
{
   
    public static void main(String[] args)
    {
        // En utilisant la classe BufferedWriter
        
        BufferedWriter f1 = null;
        try
        {
            // On utilise :
            // - public FileWriter(String fileName,boolean append)
            //        * fileName - String The system-dependent filename.
            //        * append - boolean if true, then data will be written to the end of the file rather than the beginning.
            // - public BufferedWriter(Writer out)
            //        * out - A Writer (flux de fichier ouvert en écriture).
            
            f1  = new BufferedWriter( new FileWriter("testBW.txt", true));
            f1.write("C'est la fin du fichier.");
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
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
                e.printStackTrace();
            }
        }
        
        
        // En utilisant la classe RandomAccessFile
        
        RandomAccessFile f2 = null;
        
        try
        {
            f2 = new RandomAccessFile("testRAF.txt", "rw");
            long f2length = f2.length();    // Permet de récupérer la longueur du fichier, nombre de caractères du fichier.
            f2.seek(f2length);              // Permet de positionner le curseur après le dernier caractère du fichier.
            f2.writeBytes("C'est la fin du fichier");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                
                if(f2 != null)
                    f2.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
