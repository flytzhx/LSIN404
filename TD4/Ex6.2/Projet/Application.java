import org.apache.commons.math3.complex.Complex;

/**
 * Write a description of class Application here.
 * 
 * @author Quentin
 * @version 2016
 */
public class Application
{
    static public void main(String[] args)
    {
        Complex c1 = new Complex(34,21);
        Complex c2 = new Complex(28,12);
        
        Complex c3 = c1.add(c2);
    }
}
