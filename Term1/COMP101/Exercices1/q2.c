// Written by Marti Serra on 7/10/2015
// This program displays CS deparment name and adress.

#include <stdio.h>
#include <string.h>

int main() {
  char name[] = “Dept. of Computer Science”;
  char address[] = “Malet Place Engineering Building”;
  printf("%s\n", name);
  printf("%s\n", adress);

  int index = strlen(name) - 1;
  while (index > -1)
  {
    printf("%c", name[index]);
    index = index - 1;
  }
  printf("\n");

  int index2 = strlen(address) - 1;
  while (index2 > -1)
  {
    printf("%c", address[index2]);
    index2 = index2 - 1;
  }
  printf("\n");

return 0;
}
