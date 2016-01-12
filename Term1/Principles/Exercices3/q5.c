#include "stdio.h"

void printHundred(int h) {
  if (h == 9) printf("nine hundred");
  if (h == 8) printf("eight hundred");
  if (h == 7) printf("seven hundred");
  if (h == 6) printf("six hundred");
  if (h == 5) printf("five hundred");
  if (h == 4) printf("four hundred");
  if (h == 3) printf("three hundred");
  if (h == 2) printf("two hundred");
  if (h == 1) printf("one hundred");
}

void printTen(int h) {
  if (h == 9) printf("ninety");
  if (h == 8) printf("eighty");
  if (h == 7) printf("seventy");
  if (h == 6) printf("sixty");
  if (h == 5) printf("fifty");
  if (h == 4) printf("fourty");
  if (h == 3) printf("thirty");
  if (h == 2) printf("twenty");
}

void printSpecial(int h) {
  if (h == 19) printf("nineteen");
  if (h == 18) printf("eighteen");
  if (h == 17) printf("seventeen");
  if (h == 16) printf("sixteen");
  if (h == 15) printf("fifteen");
  if (h == 14) printf("fourteen");
  if (h == 13) printf("thirteen");
  if (h == 12) printf("twelve");
  if (h == 11) printf("eleven");
  if (h == 10) printf("ten");
  if (h == 9) printf("nine");
  if (h == 8) printf("eight");
  if (h == 7) printf("seven");
  if (h == 6) printf("six");
  if (h == 5) printf("five");
  if (h == 4) printf("four");
  if (h == 3) printf("three");
  if (h == 2) printf("two");
  if (h == 1) printf("one");
  if (h == 0) printf("zero");
}

int main() {
  int number = 0;
  scanf("%d", &number);

  if (number>= 100) {
    printHundred(number/100);
  }
  if (number>= 100 && number%100 > 0) printf(" and ");
  if (number%100 > 0) {
    if ((number%100)/10 >=2) {
      printTen((number%100)/10);
      printf(" ");
      if (number%10 > 0) {
        printSpecial(number%10);
      }
    }
    else if ((number%100)/10 < 2) {
      printSpecial(number%20);
    }
  }

  return 0;
}
