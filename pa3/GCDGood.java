import java.util.*;

public class GCDGood
{
  public static void main(String[] args)
  {
    Scanner scan = new Scanner(System.in);
    System.out.print("Enter first number: ");
    int n1 = scan.nextInt();
    System.out.print("Enter second number: ");
    int n2 = scan.nextInt();
    
    int gcd = 1; 
    int k = 2; 
    while (k <= n1 && k <= n2) 
    { 
      if (n1 % k == 0 && n2 % k == 0)
      {   
        gcd = k;
      } 
      k++; 
    }
 
   System.out.println("The greatest common divisor for " + n1 + " and "+ n2 
      + " is "+ gcd);
  }
} 
