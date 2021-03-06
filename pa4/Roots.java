// -------------------------------------------------------
//  Roots.java
//  Matthew Tan
//  mxtan
//  pa4
//  Calculates the roots of a polynomial
// -------------------------------------------------------

import java.util.*;

public class Roots
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
	double resolution = 0.01;
	double tolerance = 0.0000001;
	double threshold = 0.001;

        double a;
        double b;
        int L;
        int  R;
        int degree;
        boolean foundRoot = false;
        
        System.out.print("Enter the degree: ");
        degree = scan.nextInt();
        //System.out.println("Degree is: " + degree);
        double[] coeffs = new double[degree + 1];
        System.out.print("Enter " + (degree + 1) + " coeffcients: ");
        for (int i = 0; i < (degree + 1); i++)
        {
            coeffs[i] = scan.nextDouble();
            //System.out.println("Coefficent is: " + coeffs[i]);
        }
        
        double[] deriv = diff(coeffs);
        /*for (int i = 0; i < deriv.length; i++)
        {
            System.out.println("Deriv is: " + deriv[i]);
            }*/
        System.out.print("Enter the left and right endpoints: ");
        L = scan.nextInt();
        R = scan.nextInt();
        
        System.out.println("");
        a = L;
        b = a + resolution;
        /*System.out.println("a is: " + a);
        System.out.println("b is: " + b);
        System.out.println("L is: " + L);
        System.out.println("R is: " + R);*/

        //double polyA = poly(coeffs, a);
        //double polyB = poly(coeffs, b);
        //System.out.println("Poly A is: " + polyA + " Poly B is : " + polyB);
        while (a <= R)
        {
            //System.out.println("Got here");
            // odd root
             double polyA = poly(coeffs, a);
             double polyB = poly(coeffs, b);
             double derivA = poly(deriv, a);
             double derivB = poly(deriv, b);
             // System.out.println("Deriv A is: " + derivA + " Deriv B is: " + derivB);
             // System.out.println("Poly A is: " + polyA + " Poly B is : " + polyB);
            if ((polyA > 0 && polyB < 0))
            {
                //System.out.println("Got here");
                double root = findRoot(coeffs, a, b, tolerance);
                foundRoot = true;
                System.out.printf("Root found at %.5f%n", root);
            }
            else if (polyA < 0 && polyB > 0)
            {
                double root = findRoot(coeffs, a, b, tolerance);
                foundRoot = true;
                System.out.printf("Root found at %.5f%n", root);
            }
            // even root, graph concave up
            else if (derivA < 0 && derivB > 0)
            {
                // System.out.println("!!Poly A is: " + polyA + " Poly B is : " + polyB
                //       + " threshold is: " + threshold);
                if (polyA >= 0 && 
                    polyB >= 0 &&
                    Math.abs(polyA) <= threshold && 
                    Math.abs(polyB) <= threshold)
                {
                    double root = findRoot(coeffs, a, b, tolerance);
                    foundRoot = true;
                    System.out.printf("Root found at %.5f%n", root);

                }
            }
            // even root, graph concave down
            else if (derivA > 0 && derivB < 0)
            {
                if (polyA <= 0 && 
                   polyB <= 0 &&
                   Math.abs(polyA) <= threshold && 
                   Math.abs(polyB) <= threshold)
                {
                    double root = findRoot(coeffs, a, b, tolerance);
                    foundRoot = true;
                    System.out.printf("Root found at %.5f%n", root);

                }    
            }
            a = b;
            b = a + resolution;   
        }
        if (!foundRoot)
        {
             System.out.println("No roots were found in the specified range.");
        }
    }
    public static double poly(double[] C, double x)
    {
	double[] storePoly = new double[C.length];
        double sum = 0;
        // System.out.println("Length of C is: " + C.length);
	for (int i = 0; i < C.length; i++)
	{
		storePoly[i] = C[i] * Math.pow(x, i);
		sum = sum + storePoly[i];
	}
	return sum;
    }

    public static double[] diff(double[] C)
    {
	double[] D = new double[C.length - 1];
	for (int i = 0; i < C.length - 1; i++)
	{
	    D[i] = C[i + 1] * (i + 1);
        }
	return D;
    }

    public static double findRoot(double[] C, 
           double a, double b, double tolerance)
    {
        //System.out.println("Got here");
	double midpoint = 0.0, width = b - a;
	while (Math.abs(width) > tolerance)
	{
	    midpoint = (a + b) / 2.0;
	    if ((poly(C, a)) * (poly(C, midpoint)) <= 0)
	    {
	        b = midpoint;
	    } 
            else if ((poly(C, b)) * (poly(C, midpoint)) <= 0)
	    {
	        a = midpoint;
	    }
            width = b - a;
        }
	return midpoint;
    }
}
