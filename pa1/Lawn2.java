import java.util.*;

//Lawn.java
//Matthew Tan
//mxtan
//pa1
//Create a simulation of mowing a lawn

public class Lawn2
{
  public static void main(String[] args)
  {
      Scanner scan = new Scanner(System.in);
        
      System.out.print("Enter the length and the width of the lot, in feet: ");
      double lotWidth = scan.nextDouble();
      double lotLength = scan.nextDouble();
      double lotArea = lotWidth * lotLength;
      
      System.out.print("Enter the length and width of the house, in feet: ");
      double houseWidth = scan.nextDouble();
      double houseLength = scan.nextDouble();
      double houseArea = houseWidth * houseLength;

      double lawnArea = lotArea - houseArea;

      System.out.println("The area is: " + lawnArea + " square feet.");
      
      System.out.print("Enter the mowing rate, in square feet per second: ");
      double mowingRate = scan.nextDouble();
      
      double mowingTime = lawnArea / mowingRate;
      
      double seconds = mowingTime;
      int hour;
      int minute;
      int second;
      second = (int) Math.round(seconds);
      minute = second / 60;
      second = second % 60;
      hour = minute / 60;
      minute = minute % 60;

      if (hour != 1)
      {
        System.out.print("The mowing time is " + hour + " hours");
      }
      else
      {
        System.out.print("The mowing time is " + hour + " hour");
      } 
      if (minute != 1)
      {
        System.out.print(" " + minute + " minutes");
      }
      else
      {
        System.out.print(" " + minute + " minute");
      }
      if (second != 1)
      {
        System.out.print(" " + second + " seconds.");
      }
      else
      {
        System.out.println(" " + second + " second.");
      }
  }
}
