/*
 * Sphere.c
 * Matthew Tan
 * mxtan
 * lab7
 * calculates the volume and surface area of a sphere
 * of any given radius
 */

#include<stdio.h>
#include<math.h>

int main()
{
    const double pi = 3.141592654;
    double radius;
    double sphereVol;
    double sphereArea;

    printf("Enter the radius of the sphere: ");
    scanf("%lf", &radius);
    sphereVol = (4.0/3.0) * pi * pow(radius, 3);
    sphereArea = 4 * pi * pow(radius, 2);
    printf("The volume is %lf " , sphereVol); 
    printf("and the surface area is %lf", sphereArea);
    printf("."); 
}
