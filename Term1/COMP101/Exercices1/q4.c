// Written by Marti Serra on 7/10/2015
// This program displays an heptagon.

#include "graphics.h"

int main(void) {
  int x = 50;
  int y = 40;

  drawLine(-26.95 +x, 13.18  +y, -26.95 +x, -13.18 +y);
  drawLine(-26.95 +x, -13.18 +y, -6.55  +x, -29.27 +y);
  drawLine(-6.55  +x, -29.27 +y, 18.75  +x, -23.42 +y);
  drawLine(18.75  +x, -23.42 +y, 30.00  +x, 0.00   +y);
  drawLine(30.00  +x, 0.00   +y, 18.75  +x, 23.42  +y);
  drawLine(18.75  +x, 23.42  +y, -6.55  +x, 29.27  +y);
  drawLine(-6.55  +x, 29.27  +y, -26.95 +x, 13.18  +y);

  return 0;
}
