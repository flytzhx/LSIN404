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
    private JButton boutonAllumer = new JButton("Allumer");
    private JButton boutonEteindre = new JButton("Eteindre");
    private Panneau panneauDessin = new Panneau();

    /**
     * Constructor for objects of class Fenetre
     */
    public Fenetre(String titre, int large, int haut) 
    {
       this.setTitle(titre);
        this.setSize(large, haut);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Création du content pane
        JPanel conteneur = new JPanel();
        // Définition de la disposition des composants du content pane
        conteneur.setLayout(new BorderLayout());
        
        // Création du panneau contenant les boutons
        JPanel panneauBoutons = new JPanel();
        panneauBoutons.add(boutonAllumer);
        panneauBoutons.add(boutonEteindre);
        
        // Ajout des panneaux Dessin et Boutons dans le content pane selon la disposition BorderLayout
        conteneur.add(panneauDessin, BorderLayout.CENTER);
        conteneur.add(panneauBoutons, BorderLayout.SOUTH);
        
        // On ajoute nos écouteurs specifiques (instance de nos classes internes BoutonAllumerListener et BoutonEteindreListener)
        /// à la liste des objets qui écoutent le bouton Allumer et le bouton Eteindre.
        boutonAllumer.addActionListener(new BoutonAllumerListener());
        boutonEteindre.addActionListener(new BoutonEteindreListener());
        
        // Ajout du content pane à la fenêtre principal
        this.setContentPane(conteneur);
        

        this.setVisible(true);
    }
 

    
    
    /*
     * ########################################### Classes internes #################################################
     * 
     *  -> Classes internes specialisées dans l'écoute d'une source.     
     *       
     *  Utiliser des classes internes permet de créer des implémentations de l'interface ActionListener détachées de notre classe Fenetre, mais pouvant utiliser ses attributs.   
     *  Grâce à cela, nous pourrons concevoir une classe spécialisée dans l'écoute des composants et qui effectuera un travail bien déterminé. 
     *  
     *  Ici , nous créons deux classes internes implémentant chacune l'interface ActionListener et redéfinissant la méthode actionPerformed() (pour réaliser les actions specifiques) :
     *      * BoutonAllumerListener : permet d'écouter l'objet source : boutonAllumer
     *      * BoutonEteindreListener : permet d'écouter l'objet source : boutonEteindre
     *  
     *   En utilisant les classes internes, nous n'avons plus à nous soucier du bouton qui a déclenché l'événement, car nous disposons de deux classes écoutant chacune un bouton.
     */
    public class BoutonAllumerListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            panneauDessin.setLumiere(true);
            panneauDessin.repaint();
        }
    }
    
      public class BoutonEteindreListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            panneauDessin.setLumiere(false);
            panneauDessin.repaint();
        }
    }
    
}
