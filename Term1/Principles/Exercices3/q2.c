#include "stdio.h"

int recPow(int base, int power) {
  if (power == 0) return 1;
  else if (power%2 == 0) return recPow(base*base, power/2);
  else return recPow(base*base, (power-1)/2) * base;
}

int loopPow(int base, int power) {
  int result = 1;
  for (int i = 0; i<power; i++) {
    result *= base;
  }
  return result;
}

int main() {
  printf("%i\n", recPow(2,5));
  printf("%i\n", loopPow(2,5));

  return 0;
}
