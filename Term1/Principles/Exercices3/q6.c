#include "stdio.h"
#include "math.h"

int isPrime(int number) {
  int i = 0;
  for (i = pow(number, .5); i>1; i--) {
    if (number%i == 0) return 0;
  }
  return 1;
}

void printTwins(int lower, int upper) {
  int i = 0;
  int lastPrime = 0;

  for (i = lower;i<upper+1; i++) {
    if (isPrime(i)) {
      if (i - lastPrime <=2) {
        printf("Twin primes: %i %i\n", lastPrime, i);
      }
      lastPrime = i;
    }
  }
}

int main() {
  printTwins(113, 5609);

  return 0;
}
