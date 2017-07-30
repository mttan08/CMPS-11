#include<stdio.h>
#include<stdlib.h>

int main(){
  int a = 1, n;

  /* n = scanf(" %d", &a);
   if( n!=1 ){
    printf("Error: not a number\n");
    exit(1);
    } */
  while( 1 ){  // seemingly infinite loop
    if(a>0){
      n = scanf(" %d", &a);
      if( n!=1 ){
        printf("Error: not a number\n");
        exit(1);
      }
      continue;
    }
    break;
    // continue lands here
  }
  // break lands here
  printf("done\n");
   
  return 0;
}

