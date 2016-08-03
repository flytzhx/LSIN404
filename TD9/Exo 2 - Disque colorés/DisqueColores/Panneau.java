import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;



/**
 * Write a description of class Panneau here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Panneau extends JPanel implements MouseListener
{
    private ArrayList<Disque> disquesMemoire = new ArrayList<Disque>();

    /**
     * Constructor for objects of class Panneau
     */
    public Panneau()
    {
        setPreferredSize(new Dimension(800,600));
        setBackground(Color.WHITE);
        
        addMouseListener(this);
    }
    
    
   // --> Méthodes de l'interface MouseListener à implémenter <--
   
   // Gérer l'évènement "le bouton est enfoncé".
   public void mousePressed(MouseEvent e)
   {
       int rayon = 10;  // Initialise le rayon à 10 par défaut : clic gauche.
       Color couleur = Color.GREEN;     // Initialise la couleur à verte par défaut : clic au milieu du panneau.
       
       // Permet de récupérer la largeur du panneau : nécéssaire pour colorer les cercles en fonctions de l'emplacement du clic sur le panneau.
       int largeurPanneau = this.getWidth();
       
       // Définit le rayon du cercle en fonction de la nature du clic de la souris.
       if(SwingUtilities.isMiddleMouseButton(e))
            rayon = 20;
       else if(SwingUtilities.isRightMouseButton(e))
            rayon = 30;
       
       // Définit la couleur du cercle en fonction de l'emplacement du clic de la souris. 
       if(e.getX()*3 < largeurPanneau)
            couleur = Color.RED;
       else if(e.getX()* 3 > largeurPanneau*2 )
            couleur = Color.YELLOW;
       
       // Ajout du disque à la liste des disques : nécéssaire pour déssiner tous les cercles sur le panneau.    
       disquesMemoire.add(new Disque(e.getX(), e.getY(), rayon, couleur));
       repaint();
           
   }
   
   // Gérer l'évènement "le bouton est relâché".
   public void mouseReleased(MouseEvent e){}
   // Gérer l'évènement "le bouton est enfonce puis relâché sans que le curseur n'ai été déplacé".
   public void mouseClicked(MouseEvent e) { }
   // Gérer l'évènement "le curseur est entré dans le composant".
   public void mouseEntered(MouseEvent e) { }
   // Gérer l'évènement "le curseur est sorti du composant".
   public void mouseExited(MouseEvent e) { }
    
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        for(Disque d : disquesMemoire)
            d.dessiner(g);
        
    
    

    }
}
