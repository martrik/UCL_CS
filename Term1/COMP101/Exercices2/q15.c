#include "stdio.h"

void drawRectangleOfSizeWithCharecter(int w, int h, char letter) {
  for (int i = 0; i<h; i++) {
    for (int t = 0; t<w; t++) {
      printf("%c", letter);
    }
    printf("\n");
  }
}

int main() {
  drawRectangleOfSizeWithCharecter(3,5,'h');
  return 0;
}
