#include <stdio.h> 
#include <string.h>
#include <stdlib.h>

int Fsize = 50;

char* subString (int offset, int len, const char* input) {
  char* sub = malloc(sizeof(char)*len);
  int input_len = strlen(input);

  strncpy (sub, input + offset, len);

  return sub;
}

int isVar(char var) {
  if (var == 'x' || var == 'y' || var == 'z') return 1;
  else return 0;
}

int parse(char *g) {
  switch(*g) {
     // Atomic formula
     case 'X':
      if (*(g+1) == '[' && isVar(*(g+2))) {
        if (*(g+3) == ']') {
          return 1;
        }
        else if (isVar(*(g+3)) && *(g+4) == ']') {
          return 1;
        }
      }
    break;

    // Negated formula
    case '-':
      if (parse(subString(1, strlen(g)-1, g))) {
        return 2;
      }
    break;

    // Binary conenctor
    case '(': 
      if (parse(subString(1,strlen(g)-2, g)) && *(g+strlen(g)-1) == ')') {
        return 3;
      } break;

    // Existencial formula
    case 'E': 
      if (isVar(*(g+1)) && parse(subString(2, strlen(g)-3, g))) return 4;
      break;

    // Universal formula
    case 'A':
    if (isVar(*(g+1)) && parse(subString(2, strlen(g)-3, g))) return 5;
    break;

    default: return 0;break;
  } 
  return 0;
}

int isBin(char c) {
  switch(c)
  { case '>': return 1;break;
    case 'v': return 1;break;
    case '^': return 1;break;
    default: return 0;break;
  }
}

int binIndex(char *g) {
  int bracketCount = 0;
  int indexCount = 0;

  while (1) {
      if (*(g+indexCount) == '(') bracketCount++;
      else if (*(g+indexCount) == ')') bracketCount--;

      if (isBin(*(g+indexCount)) && bracketCount == 1) return indexCount;
      
      indexCount++;
  }

  return 0;
}

char* partone(char *g) {
  return subString(1, binIndex(g)-1, g);
}

char* parttwo(char *g) {
  int index = binIndex(g);
  return subString(index+1,strlen(g)-index-2, g);
}

char bin(char *g) {
  return *(g + binIndex(g));
}

int main() {
  char *name = malloc(Fsize);
  printf("Enter a formula:");
  scanf("%s", name);
  int p = parse(name);
  switch(p)
  { case 0: printf("Not a formula");break;
    case 1: printf("An atomic formula");break;
    case 2: printf("A negated formula");break;
    case 3: printf("A binary connective formula");break;
    case 4: printf("An existential formula");break;
    case 5: printf("A universal formula");break;
    default: printf("Not a formula");break;
  }

  if (p==3) printf("The first part is %s, the binary connective is %c, the second part is %s", partone(name), bin(name), parttwo(name));

  return(1);
}
