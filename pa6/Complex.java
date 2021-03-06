/*
 * Complex.java
 * Matthew Tan
 * mxtan
 * pa6
 * Models a complex number
 */

public class Complex
{
    //--------------------------------------------------------------------------
    // Private Data Fields 
    //--------------------------------------------------------------------------
    private double re;
    private double im;
   
    //--------------------------------------------------------------------------
    // Public Constant Fields 
    //--------------------------------------------------------------------------
    public static final Complex ONE = Complex.valueOf(1,0);
    public static final Complex ZERO = Complex.valueOf(0,0);
    public static final Complex I = Complex.valueOf(0,1);

    //--------------------------------------------------------------------------
    // Constructors 
    //--------------------------------------------------------------------------
    public Complex(double a, double b)
    {
        this.re = a;
        this.im = b;
    }

    public Complex(double a)
    {
        this.re = a;
        this.im = 0;
    }

    public Complex(String s)
    {
        double[] complex = parseComplex(s);
        re = complex[0];
        im = complex[1];
    }

    //---------------------------------------------------------------------------
    // Public methods 
    //---------------------------------------------------------------------------

    // Complex arithmetic -------------------------------------------------------

    // copy()
    // Return a new Complex equal to this Complex
    public Complex copy()
    {
        return new Complex(this.re, this.im);
    }
   
    // add()
    // Return a new Complex representing the sum this plus z.
    public Complex add(Complex z)
    {
        return new Complex(this.re + z.re, this.im + z.im);
    }
   
    // negate()
    // Return a new Complex representing the negative of this.
    public Complex negate()
    {
        double negate = -1;
        return new Complex(this.re * negate, this.im * negate);
    }

    // sub()
    // Return a new Complex representing the difference this minus z.
    public Complex sub(Complex z)
    {
        return new Complex(this.re - z.re, this.im - z.im);
    }

    // mult()
    // Return a new Complex representing the product this times z.
    public Complex mult(Complex z)
    {
        double a = z.re;
        double b = z.im;
        double c = this.re;
        double d = this.im;
        double i = (a * c - d * b);
        double j = (a * d + b * c);
        return new Complex(i, j);
    }

    // recip()
    // Return a new Complex representing the reciprocal of this.
    // Throw an ArithmeticException with appropriate message if 
    // this.equals(Complex.ZERO).
    public Complex recip()
    {
        double a = re;
        double b = im;
        return new Complex(a / ((a * a) + (b * b)),
                           (-b / ((a * a) + (b * b))));
    }

    // div()
    // Return a new Complex representing the quotient of this by z.
    // Throw an ArithmeticException with appropriate message if 
    // z.equals(Complex.ZERO).
    public Complex div(Complex z)
    {
        if (z.equals(Complex.ZERO))
        {
            throw new NumberFormatException("Cannot divide by zero.");
        }
        
        double a = z.re;
        double b = z.im;
        double c = this.re;
        double d = this.im;
            
        double i = ((a * c) + (b * d)) / ((a * a) + (b * b));
        double j = ((a * d) - (b * c)) / ((a * a) + (b * b));
        return new Complex(i, j);
    }

    // conj()
    // Return a new Complex representing the conjugate of this Complex.
    public Complex conj()
    {
        return new Complex(re, -im);
    }
   
    // Re()
    // Return the real part of this.
    public double Re()
    {
        return re;
    }

    // Im()
    // Return the imaginary part of this.
    public double Im()
    {
        return im;
    }

    // abs()
    // Return the modulus of this Complex, i.e. the distance between 
    // points (0, 0) and (re, im).
    public double abs()
    {
        double abs = (re - 0) * (re - 0) + (im - 0) * (im - 0);
        return Math.sqrt(abs);
    }

    // arg()
    // Return the argument of this Complex, i.e. the angle this Complex
    // makes with positive real axis.
    public double arg()
    {
        return Math.atan2(im, re);
    }

    // Other functions ---------------------------------------------------------
   
    // toString()
    // Return a String representation of this Complex.
    // The String returned will be readable by the constructor Complex(String s)
    public String toString()
    {
        if (im > 0 && re > 0)
        {
            return re + " + " + im + "i";
        }
        else if (im == 0 && re > 0)
        {
            return re + " ";
        }
        else if (im < 0 && re > 0)
        {
            return + re + "-" + (-im) + "i";   
        } 
        else if (im > 0 && re < 0)
        {
            return re + "+" + im + "i";
        }
        else if (im == 0 && re < 0)
        {
            return re + " ";
        }
        else if (im < 0 && re < 0)
        {
            return  + re + "-" + (-im) + "i";
        }
        return  + im + "i";
    }

    // equals()
    // Return true iff this and obj have the same real and imaginary parts.
    public boolean equals(Object obj)
    {
        Complex compare = (Complex) obj;
        return(this.re == compare.re && this.im == compare.re);
    }

    // valueOf()
    // Return a new Complex with real part a and imaginary part b.
    public static Complex valueOf(double a, double b)
    {
        return new Complex(a, b);
    }

    // valueOf()
    // Return a new Complex with real part a and imaginary part 0.
    public static Complex valueOf(double a)
    {
        return new Complex(a);
    }

    // valueOf()
    // Return a new Complex constructed from s.
    public static Complex valueOf(String s)
    {
        return new Complex(s);
    }
    // ----------------------------------------------------------------
    // Private methods
    // ---------------------------------------------------------------

    // parseComplex(String str)
    // Parses a complex number in the form of a + bi
    private static double[] parseComplex(String str)
    {
        double[] part = new double[2];
        String s = str.trim();
        String NUM = "(\\d+\\.\\d*|\\.?\\d+)";
        String SGN = "[+-]?";
        String OP =  "\\s*[+-]\\s*";
        String I =   "i";
        String OR =  "|";
        String REAL = SGN + NUM;
        String IMAG = SGN+NUM+"?" + I;
        String COMP = REAL + OR +
                    IMAG + OR +
          REAL + OP + NUM + "?" + I;
      
        if (!s.matches(COMP))
        {
          throw new NumberFormatException(
                "Cannot parse input string \""+s+"\" as Complex");
        }
        
        s = s.replaceAll("\\s","");     
        if (s.matches(REAL))
        {
            part[0] = Double.parseDouble(s);
            part[1] = 0;
        }
        else if (s.matches(SGN+I))
        {
          part[0] = 0;
          part[1] = Double.parseDouble( s.replace(I, "1.0"));
        }
        else if (s.matches(IMAG))
        {
            part[0] = 0;
            part[1] = Double.parseDouble(s.replace( I , ""));
        }
        else if (s.matches(REAL+OP+I))
        {
            part[0] = Double.parseDouble(s.replaceAll("(" + REAL + ")" + OP                     +".+" , "$1"));
            part[1] = Double.parseDouble(s.replaceAll(".+(" + OP + ")" + I ,                    "$1" + "1.0"));
        }
        else
        {
          part[0] = Double.parseDouble(s.replaceAll("(" + REAL + ").+"  
                  , "$1") );
          part[1] = Double.parseDouble(s.replaceAll( ".+(" + OP + NUM + ")"                   + I , "$1" ) );
        }
        return part;
    }
}
