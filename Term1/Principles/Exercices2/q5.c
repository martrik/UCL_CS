#include "stdio.h"

int main() {
  for (int i = 0; i < 6; i++) {
    for (int t = 0; t < 6; t++) {
      if (t>=i) printf("*");
      else printf(" ");
    }
    printf("\n");
  }
  return 0;
}
