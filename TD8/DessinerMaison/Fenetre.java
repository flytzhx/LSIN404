import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
/**
 * Write a description of class Fenetre here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fenetre extends JFrame
{

    /**
     * Constructor for objects of class Fenetre
     */
    public Fenetre(String titre, int large, int haut)
    {
       this.setTitle(titre);
        this.setSize(large, haut);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /* Instanciation d'un objet Paneau (JPanel) */
        Panneau conteneur = new Panneau(large, haut);
        
        /* L'objet conteneur sera le conteneur de notre objet Fenetre */
        this.setContentPane(conteneur);
        
        /* Affiche l'objet Fenetre */
        this.setVisible(true);
    }

}