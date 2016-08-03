
/**
 * Write a description of class Police here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Police
{
    // instance variables - replace the example below with your own
    private String nom;
    private int style;

    /**
     * Constructor for objects of class Police
     */
    public Police(String nom, int style)
    {
        this.nom = nom;
        this.style = style;
    }

    public String getNom()
    {
        return this.nom;
    }
    
    public int getStyle()
    {
        return style;
    }
    
    public String toString()
    {
        String str = "";
        
        if(style == 0)
            str = "PLAIN";
        else if(style == 1)
            str = "BOLD";
        else if(style == 2)
            str = "ITALIC";
            
        return getNom()+" "+str;
    }
}
