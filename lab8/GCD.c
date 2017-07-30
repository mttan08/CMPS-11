/*
 * GCD.c
 * Matthew Tan
 * mxtan
 * lab 8
 * Calculates the GCD of two numbers
 */

#include<stdio.h>
#include<stdlib.h>

int main(void)
{
    int a = -1;
    int b = -1;
    int n;
    char str[100];

    printf("Enter a positive integer: ");
    while (1)
    {    
        n = scanf(" %d", &a);
        if (n != 1)
        {
            printf("Please enter a positive integer: ");
            scanf(" %s", str);
        }   
        else
        { 
            if (a < 0)
            {
                printf("Please enter a positive integer: ");
            }
            else
            {
                break;
            }
        }
    }
    
    printf("Enter another positive integer: ");
    while (1)
    {   
        n = scanf(" %d", &b);
        if (n != 1)
        {
            printf("Please enter another positive integer: ");
            scanf(" %s", str);
        }   
        else
        { 
            if (b < 0)
            {
                printf("Please enter another positive integer: ");
            }
            else
            {
                break;
            }
        }
    }

    int r;
    int gcd;
    r = a % b;
    printf("The GCD of %d ", a); 
    printf("%d", b);
    printf(" and ");
    printf(" is ");
  
    while (r > 0)
    {
        a = b;
        b = r;
        r = a % b;
    }
    gcd = b;
    printf(" %d", gcd);
    printf(" \n");
    return 0;
} 
