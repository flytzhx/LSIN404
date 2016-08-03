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
public class Fenetre extends JFrame implements ActionListener
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
        
        // On ajoute la Fenetre à la liste des objets qui écoutent le bouton Allumer et le bouton Eteindre
        // La méthode addActionListener() attend un objet de type ActionListener : Comme la classe fenêtre implémente l'interface ActionListener, "this" peut être de ce type.
        // Il ne reste alors plus qu'à définir la méthode actionPerformed() seule méthode déclarée par l'interface ActionListener pour indiquer ce qui doit se passer lorsqu'on clique sur un des deux boutons.
        boutonAllumer.addActionListener(this);
        boutonEteindre.addActionListener(this);
        
        // Ajout du content pane à la fenêtre principal
        this.setContentPane(conteneur);
        

        this.setVisible(true);
    }
    
    // La méthode actionPerformed(ActionEvent e) est appelée lorsque l'écouteur (ici la Fenetre) recoit un évènement detecté par un objet source (ici les Boutons)
    // Lorsqu'un évènement se produit l'écouteur reçoit un objet ActionEvent
    // Permet d'effectuer des actions selon la nature de l'évènement reçu
    // On peut utiliser la méthode e.getsource() pour connaitre la source qui a detecté l'évenement :
    //          * Si la source est le bouton Allumer, on modifie le PanneauDessin de sorte que les carrés des fenêtres deviennent jaune
    //          * Si la source est le bouton Eteindre, on modifie le PanneauDessin de sorte que les carrés des fenêtres deviennent noirs
    // On utilise la methode panneauDessin.repaint() pour que le panneauDessin recharge sa methode painComponent() (pour dessiner les modifications éventuelles)
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == boutonAllumer)
        {
            panneauDessin.setLumiere(true);
        }
        else if(e.getSource() == boutonEteindre)
        {
           panneauDessin.setLumiere(false); 
        }
        panneauDessin.repaint();
    }

}