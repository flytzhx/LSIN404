import javax.swing.JFrame;
/**
 * Write a description of class Application here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Application
{
    public static void main()
    {
        JFrame fenetre = new JFrame();
        fenetre.setTitle("Un Cercle centré");
        fenetre.setLocationRelativeTo(null);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Panneau p = new Panneau();
        fenetre.setContentPane(p);
                fenetre.pack();

        fenetre.setVisible(true);
        
        
    }
}
