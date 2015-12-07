#include "graphics.h"
#include "stdio.h"
colour colorArray[] = {yellow, orange ,  red, pink,  blue ,  cyan, darkgray, gray};

int main() {

  for (int Px = 0; Px<500; Px++) {
    for (int Py = 0; Py<300; Py++){
      double sX = -2.5 + (Px/499.0)*3.5;
      double sY = -1 + (Py/299.0)*2;
      double x  = 0;
      double y  = 0;
      int iteration = 0;
      int max_iteration = 1000;

      do {
	  double xtemp = x*x - y*y + sX;
	  y = 2*x*y + sY;
	  x = xtemp;
	  iteration += 1;
  } while ((x*x + y*y < 4) && (iteration < max_iteration));
  
      setColour(colorArray[iteration%8]);
      fillRect(Px, Py, 1, 1);
    }
  }
}
