#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

void copyString (char *to, char *from, int index) {
  to += index;
  while (*from) {
    *to++  = *from++;
  }
  *to = '\0';
}

int stringLength (char *string) {
  char *c = string;
  while (*c) {
    ++c;
  }
  return c - string;
}

void printText(char **text, int columns, int lines) {
  for (int r = 0; r<round(lines/columns); r++) {
    for (int c = 0; c<columns; c++) {
      char *line = *(text+(int)(round(lines/columns)*c + r));
      if (lines >= (r+1)*(c+1)) printf("%s", line);
      if (c < columns-1) {
        for (int offset = stringLength(line); offset<40; offset++) {
          printf(" ");
        }
        printf("   ");
      }
    }
    printf("\n");
  }
}

void readText(char **text, int *lines, int columns) {
  char *line = malloc(sizeof(char)*41);
  int charIndex  = 0;

  char *word = malloc(sizeof(char) * 40);
  scanf("%s", word);
  int length =  stringLength(word);

  while (strcmp(word, "xxx") != 0) {
    if (charIndex+length <= 40) {
      copyString(line, word, charIndex);
      charIndex += length;
      if (charIndex != 40){
        *(line+charIndex) = ' ';
        charIndex++;
      }
    } else {
      *(line+charIndex) = '\0';
      *(text+ (*lines)++) = line; // Finish previous

      text = realloc(text, sizeof(char*)*(*lines+1));

      line = malloc(sizeof(char)*41); // Start new line
      copyString(line, word, 0);
      charIndex = length;
      *(line+charIndex) = ' ';
      charIndex++;
    }
    scanf("%s", word);
    length = stringLength(word);
  }
  printText(text, columns, *lines);
}

int main() {
  int columns = 2;
  int lines = 0;
  char **text = malloc(sizeof(char*));

  readText(text, &lines, columns);
}
