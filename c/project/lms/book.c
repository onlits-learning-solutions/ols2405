#include "library.h"

void bookMenu()
{
    int ch;
    do
    {
        printf("\nBook Menu\n");
        printf("1. New Book\n");
        printf("2. Display All Books\n");
        printf("Enter choice[0 to exit]: ");
        scanf("%d", &ch);
        switch (ch)
        {
        case 0:
            return;
            break;
        case 1:
            newBook();
            break;
        case 2:
            displayAllBooks();
            break;
        default:
            printf("\nInvalid option!\n\n");
            break;
        }
    } while (1);
}

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

void displayAllBooks()
{
    BOOK book;
    FILE *fp;
    fp = fopen("book.csv", "r");
    printf("%-5s%-30s\n", "Id", "Title");
    while (fscanf(fp, "%d, %[^\n]", &book.id, book.title) != EOF)
    {
        printf("%-5d%-30s\n", book.id, book.title);
    }
    fclose(fp);
}

BOOK getBookById(int id)
{
    BOOK book;
    FILE *fp;
    int flag = 0;
    fp = fopen("book.csv", "r");

    while(fscanf(fp, "%d,%[^\n]", &book.id, book.title) != EOF)
    {
        if(book.id == id)
        {
            flag = 1;
            break;
        }
    }

    fclose(fp);
    return book;
}

BOOK getBookByTitle(char *title)
{
    BOOK book;
    return book;
}