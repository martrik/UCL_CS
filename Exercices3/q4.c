#include "stdio.h"

int seqProduct(int number, int toNumber) {
  int result = 1;

  for (int i = 0; i<=toNumber-number; i++) {
    result *= (number+i);
  }

  return result;
}

int main() {
  printf("%d\n", seqProduct(4,8));

  return 0;
}
