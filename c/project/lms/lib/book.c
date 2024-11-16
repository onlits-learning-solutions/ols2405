#include <stdio.h>
#include "library.h"

int newBook()
{
    BOOK book;
    printf("Enter book id: ");
    scanf("%d", &book.id);
    printf("Enter book title: ");
    scanf("%s", book.title);
    return 0;
}

BOOK getBookById(int id)
{
    BOOK book;
    if(book.id == id)
        return book;
}

BOOK getBookByTitle(char *title)
{
    BOOK book;
    return book;
}