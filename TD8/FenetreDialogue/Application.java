import javax.swing.JOptionPane;
/**
 * Write a description of class Application here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Application
{
    public static void main(String args[])
    {
        String s = null;
        double nb1, nb2, res;
 
        s = JOptionPane.showInputDialog("Donner le premier nombre");
        nb1 = Double.parseDouble(s);
        s = JOptionPane.showInputDialog("Donner le second nombre");
        nb2 = Double.parseDouble(s);
        JOptionPane.showMessageDialog(null,"Le produit est "+nb1*nb2);
        
    }
}
