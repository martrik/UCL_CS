#include <math.h>
#include "graphics.h"
#define M_PI 3.14159265358979323846

int main() {
  drawLine(10, 150, 400, 150);
  drawLine(20, 10, 20, 290);
  double i = 0;

  for (i; i<M_PI*2; i += 0.01){
    drawRect((int)i/(2*M_PI)*390+10, 150+(int)sin(i)*140, 1, 1);
  }
  return 0;
}
