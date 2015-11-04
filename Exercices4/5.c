#include <stdio.h>
#include <stdlib.h>
#include <string.h>

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

char** readText(char **text) {
  int lineIndex = 0;

  char *line = malloc(sizeof(char)*41);
  int charIndex  = 0;

  char *word = malloc(sizeof(char) * 128);
  scanf("%s", word);
  int length =  stringLength(word);

  while (strcmp(word, "xxx") != 0) {
    if (charIndex+length <= 40) {
      copyString(line+lineIndex, word, charIndex);
      charIndex += length;
      *(line+charIndex) = ' ';
      charIndex++;
    } else {
      *(line+charIndex) = '\0';
      *(text+lineIndex) = line; // Finish previous
      lineIndex++;
      charIndex = 0;

      line = malloc(sizeof(char)*41); // Start new line
      copyString(line+lineIndex, word, 0);
      charIndex = length;
    }
    scanf("%s", word);
    length = stringLength(word);
  }

  return text;
}

int main() {
  char **text = malloc(sizeof(char*)*200);
  readText(text);

  printf("%s\n", *(text+1));

}
