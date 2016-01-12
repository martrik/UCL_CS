#include <stdio.h> 
#include <string.h> // for all the new-fangled string functions 
#include <stdlib.h> // malloc, free, rand

int Fsize=50;
int no_edges;
int no_nodes;
int i;
const int cases=6;

// Parser functions
char* subString (int offset, int len, const char* input) {
  char* sub = malloc(sizeof(char)*len);

  strncpy (sub, input + offset, len);

  return sub;
}

int isVar(char var) {
  if (var == 'x' || var == 'y' || var == 'z') return 1;
  else return 0;
}

int isBin(char c) {
  switch(c)
  { case '>': return 1;
    case 'v': return 1;
    case '^': return 1;
    default: return 0;
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

    // Binary connector
    case '(':
      if (parse(partone(g)) && parse(parttwo(g)) && *(g+strlen(g)-1) == ')') {
        return 3;
      } 
      break;

    // Existencial formula
    case 'E': 
      if (isVar(*(g+1)) && parse(g+2)) {
        return 4;
      }
      break;

    // Universal formula
    case 'A':
      if (isVar(*(g+1)) && parse(g+2)) {
        return 5;
      }
      break;

    default: return 0;break;
  } 
  return 0;
}

char bin(char *g) {
  return *(g + binIndex(g));
}

// Model checker functions
int binEval(int left, char bin, int right) {
  switch(bin) {
    case '>':
      if (!left + right >= 1) return 1;
      else return 0;

    case '^':
      return left * right;

    case 'v':
      if (left + right >= 1) return 1;
      else return 0;

    default:
      break;
  }
  return 0;
}

int varCharIndex (char var) {
  switch(var) {
    case 'x':
      return 0;
    case 'y':
      return 1;

    case 'z':
      return 2;
    default:
      break;
  }
  return 0;
}

int varValue(char var, int V[3]) {
  return V[varCharIndex(var)];
}

int eval(char *nm, int edges[no_edges][2], int size, int V[3]) {
  int i;
switch(parse(nm)) {
    // Not formula
    case 0:
      return 0;

    // Atomic
    case 1:
      for (i = 0; i<no_edges; i++) {
        if (edges[i][0] == varValue(*(nm+2), V) && edges[i][1] == varValue(*(nm+3), V)) {
          return 1;
        } 
      }
      return 0;

    // Negated
    case 2:
      return !eval(nm+1, edges, size, V);

    // Binary connective
    case 3:
      return binEval(eval(partone(nm), edges, size, V), bin(nm), eval(parttwo(nm), edges, size, V));

    // Existential
    case 4:  
      for (i = 0; i<size; i++) {
        int Va[3] = {V[0], V[1], V[2]};
        Va[varCharIndex(*(nm+1))] = i;
        if (eval(nm+2, edges, size, Va)) {
          return 1;
        }
      }
      return 0;

    // Universal
    case 5:
      for (i = 0; i<size; i++) {
        int Va[3] = {V[0], V[1], V[2]};
        Va[varCharIndex(*(nm+1))] = i;
        if (!eval(nm+2, edges, size, Va)) {
          return 0;
        }
      }
      return 1;

    // Not formula
    default:
      break;
	}
  return 0;
}

int main()
{
  char *name=malloc(Fsize); /*create space for the formula*/
  FILE *fp, *fpout;
 
  /* reads from input.txt, writes to output.txt*/
 if ((  fp=fopen("input.txt","r"))==NULL){printf("Error opening file");exit(1);}
  if ((  fpout=fopen("output.txt","w"))==NULL){printf("Error opening file");exit(1);}

  int j;
  for(j=0;j<cases;j++)
    {
      fscanf(fp, "%s %d %d",name,&no_nodes,&no_edges);/*read formula, number of nodes, number of edges*/
      int edges[no_edges][2];  /*Store edges in 2D array*/
      for(i=0;i<no_edges;i++)  fscanf(fp, "%d%d", &edges[i][0], &edges[i][1]);/*read all the edges*/

      /*Assign variables x, y, z to nodes */
      int W[3];
      /*Store variable values in array
  value of x in V[0]
  value of y in V[1]
  value of z in V[2] */
      for(i=0;i<3;i++)  fscanf(fp, "%d", &W[i]);
      int p=parse(name); 
      switch(p)
  {case 0:fprintf(fpout,"%s is not a formula.  ", name);break;
  case 1: fprintf(fpout,"%s is an atomic formula.  ",name);break;
  case 2: fprintf(fpout,"%s is a negated formula.  ",name);break;
  case 3: fprintf(fpout,"%s is a binary connective formula.  ", name);break;
  case 4: fprintf(fpout,"%s is an existential formula.  ",name);break;
  case 5: fprintf(fpout,"%s is a universal formula.  ",name);break;
  default: fprintf(fpout,"%s is not a formula.  ",name);break;
  }
  
      /*Now check if formula is true in the graph with given variable assignment. */
      if (eval(name, edges, no_nodes,  W)==1) fprintf(fpout,"The formula %s is true in G under W\n", name); 
      else fprintf(fpout,"The formula %s is false in G under W\n", name);
    }
 
  fclose(fp);
  fclose(fpout);
  free(name);
  return(1);
}
