#include "stdio.h"
#include "math.h"

int main() {
  int a, b, c;

  scanf("%d %d %d", &a, &b, &c);

  if (a+b>c && a+c>b && b+c>a) {
    int perimeter = a + b + c;
    int semiPeri = perimeter/2;
    float area = pow(semiPeri*(semiPeri-a)*(semiPeri-b)*(semiPeri-c), 0.5);

    printf("This trinagle has perimeter: %d and area: %lf\n", perimeter, area);
  } else {
    printf("This is not a triangle.\n");
  }
  return 0;
}
