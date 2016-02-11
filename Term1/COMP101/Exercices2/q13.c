#include "stdio.h"
#include "math.h"
#include "graphics.h"

#define CYCLES 6

int main() {
  double radius = 150.00;

  for (int angle = 0; angle < CYCLES*360; angle++) {
    double radAngle = angle * (3.1416/180);
    //radius = cos(radAngle)*50 + 50; Draws a cardroid
    radius -= 0.07;

    drawRect(250 + (int)radius*cos(radAngle), 145 + (int)radius*sin(radAngle),1,1);
  }

  return 0;
}
