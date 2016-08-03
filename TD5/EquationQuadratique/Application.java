import java.lang.Math;
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
         try
         {
             double a = Double.parseDouble(args[0]);
             double b = Double.parseDouble(args[1]);
             double c = Double.parseDouble(args[2]);
             
             System.out.println("La racine de l'équation : "+a+"x^2 +"+b+" x + "+c+" = "+calculRacine(a,b,c));
         }
         catch(ArrayIndexOutOfBoundsException e1)
         {
             System.out.println("Exception :" +e1);
             System.out.println("Le tableau args est vide ou de longueur plus petit que trois.");
         }
         catch(NumberFormatException e2)
         {
             System.out.println("Exception :" +e2);
             System.out.println("Au moins un des élements du tableau args n'est pas de type double.");
             
         }
         catch(IllegalArgumentException e3)
         {
             System.out.println("Exception :" +e3);
             System.out.println("Les arguments entrés sont erronés");
             
         }
     }
        
        
    public static double calculRacine(double a, double b, double c) throws IllegalArgumentException
    {
        double delta = (b*b)-4*a*c;
        
        if(a == 0)
        {
            throw new IllegalArgumentException("Le coefficient a vaut zero");

        }
        else if(delta < 0)
        {
            throw new IllegalArgumentException("Le discriminant est négatif");
        }
        else
        {
            double x1 = (-b-Math.sqrt(delta))/2*a;
            double x2 = (-b+Math.sqrt(delta))/2*a;
            if (x1 > x2)
            return x1;
            else return x2;
        }
      
    }
}
