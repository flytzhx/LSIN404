import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
    
    public Fenetre()
    {
        setTitle("Une jolie maison");
        setSize(500,700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel conteneur = new JPanel();
        conteneur.setLayout(new BorderLayout());
        
        final Panneau pan = new Panneau(500,500);
        
        JPanel panneauBoutons = new JPanel();
        JButton boutonAllumer = new JButton("Allumer");
        JButton boutonEteindre = new JButton("Eteindre");
        panneauBoutons.add(boutonAllumer);
        panneauBoutons.add(boutonEteindre);
        
        
        
        // Deux utilisations de classe internes :
        
            
        // Non anonyme
        class boutonEteindreEcouteur implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                pan.setLumiere(false);
                pan.repaint();
            }
        }
        
        boutonEteindre.addActionListener(new boutonEteindreEcouteur());
        
        // Anonyme
        boutonAllumer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                pan.setLumiere(true);
                pan.repaint();
            }
        }
        );
        
        
        
        
        conteneur.add(pan, BorderLayout.CENTER);
        conteneur.add(panneauBoutons, BorderLayout.SOUTH);
        
        setContentPane(conteneur);
      
        setVisible(true);
        
    }
    
            

   
}
