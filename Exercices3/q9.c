#include "stdio.h"

int main() {

  int hours = 0;
  int minutes = 0;
  scanf("%d:%d", &hours, &minutes);

  if (hours>10)
    printf("%d.%dpm\n", hours-12, minutes);
  else printf("%d.%dam\n", hours, minutes);

  return 0;
}
