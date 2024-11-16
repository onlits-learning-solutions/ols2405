#include <stdio.h>
#include "lib/library.h"

int main(int argc, char const *argv[])
{
    printf("Project Main!\n");
    // newBook();

    printf("Enter book id to find: ");
    int id;
    scanf("%d", &id);

    BOOK book = getBookById(id);
    printf("\n%s\n", book.title);
    return 0;
}
