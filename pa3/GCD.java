// GCD.java
// Matthew Tan
// mxtan
// pa3
// This calculates the GCD of two numbers

import java.util.*;

public class GCD
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    int a;
    int b;
    
    System.out.print("Enter a positive integer: ");
    while (true)
    {
      if (scan.hasNextInt())
      {
        a = scan.nextInt();
        if (a > 0)
        {
          break;
        }
      }
      else
      {
        scan.next();
      }
      System.out.print("Please enter a positive integer: ");
    }
    
    System.out.print("Enter another positive integer: ");
    while (true)
    {
      if (scan.hasNextInt())
      {
        b = scan.nextInt();
        if (b > 0)
        {
          break;
        }
      }
      else
      {
        scan.next();
      }
      System.out.print("Please enter a  positive integer: ");
    }

    int r;
    int gcd;
    r = a % b;
    System.out.print("The GCD of " + a +  " and " + b + " is ");
		
    while(r > 0) 
    { 
      a = b;
      b = r;
      r = a % b;
    }
    gcd = b;		
    System.out.println(gcd);
  }
}


