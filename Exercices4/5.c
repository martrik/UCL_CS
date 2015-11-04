#import <stdio.h>

int main() {
  int counter = 0;
  char** text;

  while (counter >= 0) {
    char *word = ;
    scanf("%s", word);
    if (word[0] == '\0') {
      counter = -1;
      break;
    }
    if (counter == 4) {
      counter = -1;
      break;
    }
    text[counter] = word;

    counter++;
  }

  printf("%c", text[4][1]);

  return 0;
}
