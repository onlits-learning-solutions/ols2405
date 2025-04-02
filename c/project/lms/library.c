#include "library.h"

int main(int argc, char const *argv[]) // out of scope for Big O
{
    int ch;
    do
    {
        printf("LIBRARY MANAGEMENT SYSTEM\n");
        messagebox("MAIN MENU");
        printf("1. Book Module\n");
        printf("Enter choice[0 to exit]: ");
        scanf("%d", &ch);
        switch (ch)
        {
        case 0:
            messagebox("Bye!");
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
