import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.List;
import java.lang.StringBuilder.*;

/**
 * Write a description of class Palindrome here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Palindrome
{
    public static void main() throws IOException
    {
        Path chemin = null;
        
        try
        {
            
            chemin = Paths.get("palindrome.txt");
            List<String> phrases = Files.readAllLines(chemin, StandardCharsets.UTF_8);
            
            
            System.out.println("Listes des palindromes : ");
            for(String phrase : phrases)
            {
                String phraseSansEspace = phrase.replaceAll(" ","");    // La méthode replaceAll() permet d'enlever les espaces.  
                StringBuilder phraseModifiable  = new StringBuilder(phraseSansEspace);
                String phraseInversee = phraseModifiable.reverse().toString();
           /*
            * Autre méthode : Comparer caractère par caractère
            * 
            * boolean test = true;
            * for(int i = 0; i<phrase.length()/2; i++)
            * {
            *     if(phrase.charAt(i) != phrase.charAt(phrase.length()-i-1))
            *     {
            *           test = false;
            *           break;
            *     }
            * }
            * if(test)
            *       System.out.println(phrase);
            *       
            * 
            */
                
                if(phraseSansEspace.equals(phraseInversee))
                    System.out.println(phrase);
            }
        }
        catch(IOException e)
        {
            e.getMessage();
        }
     
           
           
        
        
    }
}
