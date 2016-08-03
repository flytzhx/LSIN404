import javax.swing.JFrame;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;


/**
 * Write a description of class Fenetre here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fenetre extends JFrame implements WindowListener
{
    Panneau panneau = new Panneau();
    
    /**
     * Constructor for objects of class Fenetre
     */
    public Fenetre()
    {
        setTitle("Disque Noir/Rouge");

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        addWindowListener(this);
        
        setContentPane(panneau);
        
        // L'utilisation de pack() permet de construire la fenetre principale sur la taille du composant Panneau (+ les bordures) donnée par setPreferredSize() dans la classe Panneau. 
        // Il n'est pas nécéssaire de donenr un taille à la fenêtre principale, si on a définit la taille via setPreferredSize de son conteneur et utilisé la méthode pack()
        // -> la taille de la fenêtre principale sera adaptée pour contenir le conteneur + la bordure de la fenetre (titre + boutons).
        
        pack();
        
        setVisible(true);
        
        
        
    }

      public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }
    
    public void windowActivated(WindowEvent e)
    {
       panneau.rouge = true;
       panneau.repaint();
    }
    
    public void windowDeactivated(WindowEvent e)
    {
        panneau.rouge = false;
        panneau.repaint();
       
    }
    
    
    public void windowOpened(WindowEvent e){}
    public void windowClosed(WindowEvent e){}
    public void windowIconified(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}

}
