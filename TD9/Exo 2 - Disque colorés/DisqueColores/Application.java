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
        JFrame f = new JFrame();
        f.setTitle("Disques colorés");
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Panneau p = new Panneau();
        
        f.setContentPane(p);
        f.pack();
        
        f.setVisible(true);
    }
        
}
