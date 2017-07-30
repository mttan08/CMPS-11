//Guess.java
//Matthew Tan
//mxtan
//pa2
//This creates a guessing game using java

import java.util.*;

public class Guess 
{
  public static void main (String[] args) 
  {
    int guess1;
    int guess2;
    int guess3;     
    Scanner scan = new Scanner(System.in);
    int num = 1 + (int)(Math.random() * ((10 - 1) + 1));
    String lose = ("You lose. The number was " + num);
		
    System.out.print("I'm thinking of an integer in the range");
    System.out.println(" 1 to 10. You have three guesses.");
    System.out.println(" ");

    System.out.print("Enter your first guess: ");
    guess1 = scan.nextInt();
    
    if (guess1 == num)
    {
      System.out.println("You win!");
      System.out.println(" ");
		
    }
    else if (guess1 > num) 
    {
      System.out.println("Your guess is too high.");			
      System.out.println(" ");
		
      System.out.print("Enter your second guess: ");
      guess2  = scan.nextInt();
			
      if (guess2 == num)
      {
        System.out.println("You win!");
        System.out.println(" ");
			
      }
      else if (guess2 > num) 
      {
        System.out.println("Your guess is too high.");
        System.out.println(" ");
        System.out.print("Enter your third guess: ");
        guess3 = scan.nextInt();
        if (guess3 == num)
        {
	  System.out.println("You win!");
          System.out.println(" ");
        }
        else if(guess3 > num) 
        {
	  System.out.println("Your guess is too high.");
	  System.out.println(" ");
	  System.out.println(lose);
	  System.out.println(" ");
	}
        else if(guess3 < num) 
        {
	  System.out.println("Your guess is too low.");
	  System.out.println(" ");
	  System.out.println(lose);
	  System.out.println(" ");
        }
      }
      else if(guess2 < num) 
      {
        System.out.println("Your guess is too low.");
        System.out.println(" ");
		
        System.out.print("Enter your third guess: ");
        guess3 = scan.nextInt();
				
        if (guess3 == num)
        {
	  System.out.println("You win!");
	  System.out.println(" ");
        }
        else if(guess3 > num) 
        {
          System.out.println("Your guess is too high.");
	  System.out.println(" ");
          System.out.println(lose);
          System.out.println(" ");
        }
        else if(guess3 < num)
        {
          System.out.println("Your guess is too low.");
          System.out.println(" ");
          System.out.println(lose);
          System.out.println(" ");
        }
    }
		
  }
  else if (guess1 < num) 
  {
    System.out.println("Your guess is too low.");		
    System.out.println(" ");
    System.out.print("Enter your second guess: ");
    guess2  = scan.nextInt();
    
    if (guess2 == num)
    {
      System.out.println("You win!");
      System.out.println(" ");
    }
    else if(guess2 > num) 
    {
      System.out.println("Your guess is too high.");
      System.out.println(" ");
      System.out.print("Enter your third guess: ");
      guess3  = scan.nextInt();
      
      if (guess3 == num)
      {
        System.out.println("You win!");
        System.out.println(" ");
      }
      else if(guess3 > num) 
      {
        System.out.println("Your guess is too high.");
        System.out.println(" ");
        System.out.println(lose);
        System.out.println(" ");
      }
      else if(guess3 < num) 
      {
        System.out.println("Your guess is too low.");
        System.out.println(" ");
        System.out.println(lose);
        System.out.println(" ");
      }
    }
    else if(guess2 < num)
    {
        System.out.println("Your guess is too low.");
        System.out.println(" ");
        System.out.print("Enter your third guess: ");
        guess3 = scan.nextInt();
        if (guess3 == num)
        {
          System.out.println("You win!");
          System.out.println(" ");
        }
        else if(guess3 > num) 
        {
          System.out.println("Your guess is too high.");
          System.out.println(" ");
          System.out.println(lose);
          System.out.println(" ");
        }
        else if(guess3 < num)
        {
          System.out.println("Your guess is too low.");
          System.out.println(" ");
          System.out.println(lose);
          System.out.println(" ");
        }
      }
  }
}
}
