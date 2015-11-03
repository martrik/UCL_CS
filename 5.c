#include <stdio.h>

void copyString (char *to, char *from, int index) {
  to += index
  while (*from)  
    *to++  = *from++; 
  *to = ‘\0’; 
}

int stringLength (char *string) { 
  char *c = string; 
  while (*c) ++c; 
  return c - string; 
} 

char** readText(char **text) {
  text = malloc(sizeof(char*)*lines);
  int lineIndex = 0;

  char *line = malloc(sizeof(char)*41);
  int charIndex  = 0;
  
  char *word;
  scanf("%s", word);
  int length = stringLength(word);

  while (*word != '\0') {
    if (countercharIndex+length <= 40) {
      copyString(*(text+lines-1), word, counter);
      countercharIndex += length;
    } else {
      *(line+40) = '\n';
      *(text+lineIndex) = line; // Finish previous
      lineIndex++;
      charIndex = 0;

      line = malloc(sizeof(char)*41); // Start new line
      copyString(*(text+lines-1), word, counter);
      countercharIndex = length;
    }
    scanf("%s", word);
  }
  return text;
}

int main() {
  char **text;

  readText(text);

}
