#include <stdio.h>

int* sort(int* unsorted) {
  int *sorted = unsorted;

  for (int i = 1; i<sizeof(sorted); i++) {
    int index = i-1;
    int pivot = sorted[i];
    while (index>=0 && pivot<sorted[index]) {
      sorted[index+1] = sorted[index];
      index--;
    }
    sorted[index+1] = pivot;
  }

  return sorted;
}

int main() {
  int array [] = {2,5,1,4,7,1,9,4};
  int *sorted = sort(&array[0]);

  for (int i = 0; i<sizeof(sorted); i++) {
    printf("%i", sorted[i]);
  }

  return 0;
}
