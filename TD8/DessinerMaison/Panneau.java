import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color; 
import java.awt.Dimension;
/**
 * Write a description of class Panneau here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Panneau extends JPanel
{

    /**
     * Constructor for objects of class Panneau
     */
    public Panneau(int large, int haut)
    {
        
        /* Définit la taille de notre objet Panneau (Jpanel conteneur) */
        this.setPreferredSize(new Dimension(large, haut));
        /* Définit le couleur de notre Objet Panneau  */
        this.setBackground(Color.WHITE);
        
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(100,150,100,100);
        g.setColor(Color.RED);
        int[] xpoints= {90,150,82}; int[] ypoints = {150,100,150};
        g.fillPolygon(xpoints, ypoints,3);
        g.setColor(Color.YELLOW);
        g.fillOval(200,20,50,50);
        g.setColor(Color.BLACK);
        g.fillRect(115,170,20,20);
        g.fillRect(165,170,20,20);
        g.fillRect(140,220,20,30);
       
    }
}
