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
    private boolean lumiere = false;

    /**
     * Constructor for objects of class Panneau
     */
    public Panneau()
    {
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
        if(lumiere)
            g.setColor(Color.YELLOW);
        else
            g.setColor(Color.BLACK);
        g.fillRect(115,170,20,20);
        g.fillRect(165,170,20,20);
        g.setColor(Color.BLACK);
        g.fillRect(140,220,20,30);
       
    }
    
    public boolean getLumiere()
    {
        return this.lumiere;
    }
    
    public void setLumiere(Boolean b)
    {
        this.lumiere = b;
    }
    
       
}
