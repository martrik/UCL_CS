#include "stdio.h"
#include <stdbool.h>

int main() {
  int rows = 9;
  int charPerRow = 4;
  bool reversing = false;

  for (int i = 0; i < rows; i++) {
    if (i<5) charPerRow++;
    else {
      reversing = true;
      charPerRow--;
    }
    for (int t = 0; t < charPerRow; t++) {
      if ((t>=i && !reversing) || (t>=charPerRow-5 && reversing)) printf("*");
      else printf(" ");
    }
    printf("\n");
  }

  retun 0;
}
