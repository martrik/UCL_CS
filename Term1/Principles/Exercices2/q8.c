#include "stdio.h"

int main() {

  int i;
  for (i = 0; i<6; i++) {
    int t;
    for (t = 0; t<6; t++ ) {
      if ((i+t+2)%2==0) printf("*");
      else printf("#");
    }
    printf("\n");
  }
  return 0;
}
