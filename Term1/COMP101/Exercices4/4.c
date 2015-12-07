#include <stdio.h>
#include <stdlib.h>

int** createRaggedArray(int rows, int* columnsArray) {
  int** pointersArray = malloc(sizeof(int*)*rows);

  for (int i = 0; i<rows; i++) {
    int *raggedArray = malloc(sizeof(int)*columnsArray[i]);

    for (int t = 0; t<columnsArray[i]; t++) {
      raggedArray[t] = i+t + i*t;
      printf("Array %i number %i %d\n", i, t, i+t + i*t);
    }
    pointersArray[i] = raggedArray;
  }

  return pointersArray;
}

int main() {
  int *sizes = (int[5]) {6,5,3,5,4};
  int **ragged = createRaggedArray(5, sizes);

  printf("%d", ragged[1][3]);

  return 0;
}
