import java.io.Serializable;
import java.util.StringTokenizer;
/**
 * Write a description of class Joueur here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Joueur implements Serializable
{
    private String nom;
    private int score;
    /**
     * Constructor for objects of class Joueur
     */
    public Joueur(String str)
    {
        StringTokenizer stk = new StringTokenizer(str);
        this.nom = stk.nextToken();
        this.score = Integer.parseInt(stk.nextToken());
    }

    public String getNom()
    {
        return nom;
    }
    
    public int getScore()
    {
        return score;
    }
    
    @Override
    public String toString()
    {
        return "Nom : "+getNom()+", Score : "+getScore();
    }

}
