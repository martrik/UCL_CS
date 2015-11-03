#include <stdio.h>
#include <stdlib.h>

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

  while (*word != '\0') {
    if (charIndex+length <= 40) {
      copyString(line+lineIndex, word, charIndex);
      charIndex += length;
    } else {
      *(line+40) = '\0';
      *(text+lineIndex) = line; // Finish previous
      lineIndex++;
      charIndex = 0;
      
      text = realloc(text, (lineIndex+1)*sizeof(char*)); // Reallocate memory to fit new line
      line = malloc(sizeof(char)*41); // Start new line
      copyString(line+lineIndex, word, 0);
      charIndex = length;
    }
    scanf("%s", word);
    length = stringLength(word);
    printf("%d \n", length);
  }

  return text;
}

int main() {
  char **text = malloc(sizeof(char*));
  readText(text);

}
