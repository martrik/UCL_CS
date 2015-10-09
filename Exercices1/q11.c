#include <math.h>
#include "graphics.h"
#include <stdio.h>

int main() {
  drawLine(10, 150, 400, 150);
  drawLine(20, 10, 20, 290);

  for (double i = 0; i<3.1416*2; i += 0.01){
    drawRect((int)(i/(2*3.1416)*380)+20, 150+(int)(sin(i)*140), 1, 1);
  }
  return 0;
}
