#include "library.h"

void printline(int n)
{
    for (int i = 0; i < n; i++)
    {
        printf("-");
    }
    printf("\n");
}

void messagebox(char *message)
{
    int n = strlen(message);
    printline(n);
    printf("%s\n", message);
    printline(n);
}