#include "stdio.h"

int main() {
  int reversing = 0;
  int i;
  int rows = 0;
  for (i = 0; i<9; i++) {
    if (i<5) rows++;
    else rows--;
    int t;
    printf("*");
    for (t = 1; t<rows; t++) {
      if (t == rows-1)  printf("*");
      else printf(" ");
    }
    printf("\n");
  }
  return 0;
}
