import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;

/**
 * Write a description of class Panneau here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Panneau extends JPanel
{
    // instance variables - replace the example below with your own
    boolean rouge = false;

    /**
     * Constructor for objects of class Panneau
     */
    public Panneau()
    {
        // Définit la taille de notre panneau
        // Ce panneau occupe toute la fenêtre (sauf bordure) grâce à l'utilisation de la méthode pack().
        setPreferredSize(new Dimension(300,300));
        
        setBackground(Color.WHITE);
        
        
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        if(rouge)
            g.setColor(Color.RED);
        // Le panneau mesure 300 en hauteur et 300 en largeur.
        // Le point haut gauche du carré entourant le cercle est de coordonnées (40,40) pour laisser une marge entre le cercle et les bords de la fenêtre.
        // La hauteur et la largeur du cercle doivent donc être de 220 chacun.
        g.fillOval(40,40, 220, 220);
    }
    
}
