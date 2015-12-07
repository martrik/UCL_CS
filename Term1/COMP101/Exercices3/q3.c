#include "stdio.h"

int main() {

  int number = 0;
  int reversedNumber = 0;
  scanf("%d", &number);
  int temp = number;

  while (temp > 0) {
    reversedNumber = reversedNumber*10 + temp%10;
    temp /= 10.00;
  }

  if (number == reversedNumber) printf("%d is palindrome\n", number);
  else printf("%d isn't palindrome\n", number);

  return 0;
}
