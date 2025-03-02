#include "library.h"

int main(int argc, char const *argv[]) // out of scope for Big O
{
    int ch;
    do
    {
        printf("LIBRARY MANAGEMENT SYSTEM\n");
        printf("\nMain Menu\n");
        printf("1. Book Module\n");
        printf("Enter choice[0 to exit]: ");
        scanf("%d", &ch);
        switch (ch)
        {
        case 0:
            printf("\nbye!\n");
            return 0;
        case 1:
            bookMenu();
            break;
        default:
            printf("\nInvalid option\n\n");
        }
    } while (1);
    return 0;
}
