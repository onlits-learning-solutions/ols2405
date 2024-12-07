#include <stdio.h>
#include "library.h"

int newBook()
{
    BOOK book;
    printf("Enter book id: ");
    scanf("%d%*c", &book.id);
    printf("Enter book title: ");
    scanf("%[^\n]", book.title);
    FILE *fp;
    fp = fopen("book.csv", "a");
    fprintf(fp, "%d,%s\n", book.id, book.title);
    fclose(fp);
    printf("\nData saved!\n");
    return 0;
}

BOOK getBookById(int id)
{
    BOOK book;
    FILE *fp;
    fp = fopen("book.csv", "r");
    
    do
    {
       fscanf(fp, "%d,%[^\n]", &book.id, book.title);
    } while (book.id != id || book.id != EOF );     //EOF not working
    
    fclose(fp);
    return book;
}

BOOK getBookByTitle(char *title)
{
    BOOK book;
    return book;
}