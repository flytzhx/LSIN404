import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.util.Vector;
import java.awt.Font;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

/**
 * Write a description of class Fenetre here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fenetre extends JFrame implements ListSelectionListener
{
    // La liste selectionnable de polices
    private JList<Police> listePolices;
    // La zone de texte
    private JTextArea champTexte = new JTextArea(4,15);
    // Police courante
    private Police policeCourante;
   
    
    

    /**
     * Constructor for objects of class Fenetre
     */
    public Fenetre()
    {
        // Définit le les propriétés de la fenêtre principale
        setTitle("Liste des polices");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Créer le conteneur intermédiaire
        JPanel conteneur = new JPanel();
        // Les composants du conteneur intermédiaire seront agencés selon un disposition de type BorderLayout.
        conteneur.setLayout(new BorderLayout());
        
        // Création du panneau du milieu qui contiendra la liste déroulante et la zone de texte.
        JPanel panMilieu = new JPanel();
        // Création du panneau bas qui contiendra l'étiquette d'information.
        JPanel panBas = new JPanel();
        
        // Créer un panneau déroulant contenant la zone de texte
        JScrollPane panTexteDeroulant = new JScrollPane(champTexte);
        champTexte.setText("Inserez votre texte ici");
        // Créer l'étiquette contenant le texte d'information.
        JLabel etiqInfo = new JLabel("Vous pouvez changer la police", SwingConstants.CENTER);
        // Créer un panneau déroulant, vide pour le moment, auquel on va ajouter la JList de police.
        JScrollPane panListeDeroulante = new JScrollPane();
    
        // Création du vecteur de polices permettant de regrouper les polices dans un tableau pour ensuite les ajouter dans la liste.
        Vector<Police> polices = new Vector<Police>();
        polices.add(new Police("Arial",1));
        polices.add(new Police("Arial",2));
        polices.add(new Police("Courier",0));
        polices.add(new Police("TimesRoman",2));
        polices.add(new Police("Serif",0));
        polices.add(new Police("DIALOG",1));
        // Ajout du vecteur de polices dans la JList listePolices.
        listePolices = new JList<Police>(polices);
        // Par défaut, selectionne le premier élément de la liste.
        listePolices.setSelectedIndex(0);
        // On enregistre la premiere police selectionnée comme police courante.
        policeCourante = listePolices.getSelectedValue();
        // On définit la police de la zone de texte selon la première police selectionnée par défaut
        Font f = new Font(policeCourante.getNom(),policeCourante.getStyle(), 18);
        champTexte.setFont(f);
        
        // Ajout de la fenêtre principale comme écouteur de la JList listePolices
        listePolices.addListSelectionListener(this);
        
        // Ajout de la liste de police dans le panneau déroulant.
        panListeDeroulante.setViewportView(listePolices);
        
        // Ajout des deux panneaux déroulants dans le panneau du milieu
        panMilieu.add(panListeDeroulante);
        panMilieu.add(panTexteDeroulant);
        // Ajout de l'étiquette d'information dans le panneau bas.
        panBas.add(etiqInfo);
        
        // Ajout du panneau milieu et du panneau bas dans le conteneur intermédiaire.
        conteneur.add(panMilieu, BorderLayout.CENTER);
        conteneur.add(panBas, BorderLayout.SOUTH);
        
        // Ajout du conteneur intermédiaire dans la fenêtre principale.
        setContentPane(conteneur);
        
        // Permet d'ajuster la taille de la fenêtre principal pour qu'elle fasse apparaitre tous les composants qu'elle contient.
        pack();
        
        // Afficher la fenêtre principale.
        setVisible(true);

        
    }
    
    // --> Méthode de l'interface ListSelectionListener à implémenter <--
    
    // Permet de définir les actions à produire lors de l'évènement : "changement d'élément séléctionné dans la liste".
    // On change la police courante par la nouvelle selectionnée
    // On créer une Font en conséquence, et on l'applique à la zone de texte.
    public void valueChanged(ListSelectionEvent e)
    {
        policeCourante = listePolices.getSelectedValue();
        Font f = new Font(policeCourante.getNom(),policeCourante.getStyle(), 18);
        champTexte.setFont(f);
    }

   
}
