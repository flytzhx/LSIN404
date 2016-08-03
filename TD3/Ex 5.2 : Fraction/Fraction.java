
/**
 * Write a description of class Fraction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
// On utilise final pour créer une Classe immuable
// La classe est immuable, elle contient des attributs immuables, on ne peut donc pas modifier le numérateur et le dénominateur, il faut à chaque opération créer une nouvelle Fraction.
public final class Fraction
{
    // --> Variables d'instance
   
    // Numérateur
    private final int numerateur; 
    // Dénominateur
    private final int denominateur;
    
    // Rq : On utilise final pour indiquer que ces variables ne seront pas modifiées.
    
    // --> Constantes (variables de classe)
    
    // Une fraction repéresentant "0"
    public static final Fraction ZERO = new Fraction (0,1);
    // Une fraction représentant "1"
    public static final Fraction UN = new Fraction(1,1);
    
    // Rq : On utilise static car ce sont des variables constantes, communes à toutes les instances de la classe.
    
    

    /*
     * Constructor for objects of class Fraction
     */
    
    public Fraction()
    {
        this.numerateur = 0;
        this.denominateur = 1;
    }
    
    public Fraction(final int numerateur)
    {
        this.numerateur = numerateur;
        this.denominateur = 1;
    }
    
    public Fraction(final int numerateur, final int denominateur)
    {
        this.numerateur = numerateur;
        this.denominateur = denominateur;
    }
    
    
    /*
     * Accesseurs
     */
    
    // Récupère le numérateur
    public int getNumerateur()
    {
        return this.numerateur;
    }
    
    // Récupère le dénominateur
    public int getDenominateur()
    {
        return this.denominateur;
    }
    
    // Donne une déscription (chaine de caractères)
    @Override
    public String toString()
    {
        return "Numérateur : "+numerateur+" / Dénominateur : "+denominateur;
    }
    
    
    // Retourne la valeur décimale de la fraction
    public double doubleValue()
    {
        return (double)numerateur / (double)denominateur;
    }
    
    // Créer une nouvelle fraction : somme de la fraction appelant la fonction avec une autre fraction passée en argument. 
    public Fraction addition(Fraction fraction)
    {
        if(fraction != null)
        {
            // Mêmes dénominateurs : On additionne juste les numérateurs.
            if(denominateur == fraction.getDenominateur())
            {
                return new Fraction(numerateur + fraction.numerateur, denominateur);
            }
            // Dénominateurs différents : On multiplie chaque fraction pour avoir un dénominateur identique, et on additione les numérateurs.
            else
            {
                return new Fraction(numerateur * fraction.denominateur + fraction.numerateur * denominateur, denominateur * fraction.denominateur);
            }
        }
        return new Fraction(numerateur, denominateur);
    }
    
    // Méthode de classe, calcule le pgcd pour créer la forme réduite d'une fraction.
    private static int PGCD(int a, int b)
    {
        while(b!=0)
        {
            int c=a%b;
            a=b;
            b=c;
        }
        
        return a;
    }
    
    // Créer la forme réduite d'une fraction
    public Fraction getReducedFraction()
    {
        int numdim;
        int dendim;
        int r;
        r=PGCD(numerateur,denominateur);
        numdim=numerateur/r;
        dendim=denominateur/r;
        //pas de - au dénominateur
        if(dendim<0)
        {
            numdim=-numdim;
            dendim=-dendim;
        }
        
        return new Fraction(numdim, dendim);
    }
    
    // Teste l'égalité entre deux fractions
    @Override
    public boolean equals(Object other)
    {
        if(this == other)
        {
            return true;
        }
        else if(other instanceof Fraction)  // Si l'objet est une instance de la classe Fraction (un objet Fraction)
        {
            Fraction f = (Fraction) other;  // On change l'objet indifférencié en objet Fraction pour pouvoir utiliser les opérations spécifiques à la classe Fraction.
            
            // On réduit les deux fractions pour pouvoir les comparer
            Fraction f1red = this.getReducedFraction();
            Fraction f2red = f.getReducedFraction();
            
            // On compare les numéateurs et les dénominateurs des deux fractions.
            return (f1red.numerateur == f2red.numerateur) && (f1red.denominateur == f2red.denominateur);
        }
        return false;
        
    }
    
    // Compare deux fractions
    public String comparer(Fraction f)
    {
        if(f != null)
        {
            if(this.doubleValue() == f.doubleValue())
            {
                return "Les deux fractions sont égales";
            }
            else if(this.doubleValue() > f.doubleValue())
            {
                return "La fraction "+this+" est plus grande que la fraction "+f;
            }
            else if(this.doubleValue() < f.doubleValue())
            {
                return "La fraction "+f+" est plus grande que la fraction "+this;
            }
        }
        return "Erreur";
    }
    
    
}
