// Written by Marti Serra on 7/10/2015
// This program displays two rectangles.

#include "graphics.h"

int main(void) {
  int x = 50;
  int y = 40;

  drawLine(30, 30, 120, 30);
  drawLine(120, 30, 120, 80);
  drawLine(120, 80, 30, 80);
  drawLine(30, 80, 30, 30);
  drawRect(150, 50, 210, 190);


  return 0;
}
