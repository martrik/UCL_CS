#include <stdio.h>

char* stringCopy(char *s) {
  char *r = s;
  return r;
}

int main() {

  char l [] = {'h', 'e', 'l', 'l', 'o'};

  printf("%s", stringCopy(&l[0]));

  char *copy = stringCopy(&l[0]);

  copy[2] = 'g';

  printf("%s", stringCopy(&l[0]));

  return 0;
}
