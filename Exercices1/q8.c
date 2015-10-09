#include "graphics.h"

int main() {
  int i = 1;
  for (i; i < 10; i++){
    int width = 500 -i*50;
    int height = 300 -i*40;
    drawOval(250-(int)width/2, 150-(int)height/2, width, height);
  }

  return 0;
}
