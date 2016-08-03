import java.awt.Color;
import java.awt.Graphics;
/**
 * Write a description of class Disque here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Disque
{

   private int x, y;
   private int rayon;
   private Color couleur;
   
    /**
     * Constructor for objects of class Disque
     */
    public Disque(int x, int y, int r, Color c)
    {
        this.x = x;
        this.y = y;
        this.rayon = r;
        this.couleur = c;
        
        
    }
    
    // Dessine un dique
    // Le disque dessiné doit être centré sur le clic de l'utilisateur
    // Lors du clic sur un point on enregistre ses coordonnées dans les attributs x et y du Cercle, seulement x et y sont les coordonnées du point haut gauche qui entoure le cercle.
    // Il est donc nécéssaire de dessiner le cercle à partir d'un nouveau point haut gauche de coordonnées (x-rayon, y-rayon) pour centrer le cercle sur le clic.
    public void dessiner(Graphics g)
    {
        g.setColor(couleur);
        g.fillOval(x - rayon,y - rayon, rayon*2 ,rayon*2 );
    }
        

   
}
