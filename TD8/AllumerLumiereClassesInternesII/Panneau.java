import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Write a description of class Panneau here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Panneau extends JPanel
{
    // instance variables - replace the example below with your own
    private boolean lumiere = false;

    /**
     * Constructor for objects of class Panneau
     */
    public Panneau(int largeur, int hauteur)
    {
       setSize(largeur,hauteur);
       setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(150,400,200,250);
        g.setColor(Color.BLACK);
        if(lumiere == true)
            g.setColor(Color.YELLOW);
        g.fillRect(170,450,60,30);
        g.fillRect(270,450,60,30);
        g.fillRect(220,550,60,100);
        g.setColor(Color.YELLOW);
        g.fillOval(300,80,80,80);
        g.setColor(Color.RED);
        int[] xpoints = {130,250,370};
        int[] ypoints = {400,250,400};
        g.fillPolygon(xpoints,ypoints,3);
    }
    
    public void setLumiere(boolean b)
    {
        lumiere = b;
    }
}
