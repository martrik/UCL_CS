#include "stdio.h"
#include "math.h"

int factorial(int i) {
  if (i == 1) return 1;
  return i*factorial(i-1);
}

int main() {
  int number = 145;
  int copyNumber = number;
  int sumFactorials = 0;

  while (copyNumber >= 1) {
    sumFactorials += factorial(copyNumber%10);
    copyNumber /= 10;
  }

  if (sumFactorials == number)
    printf("%i is a strong number\n", number);
  else printf("%i isn't a strong number\n", number);

  return 0;
}
