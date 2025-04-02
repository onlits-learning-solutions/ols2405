#include "library.h"

void bookMenu()
{
    int ch;
    do
    {
        messagebox("Book Menu");
        printf("1. New\n");
        printf("2. Display\n");
        printf("3. Edit\n");
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
            bookDispay();
            break;
        case 3:
            int id;
            printf("Enter id: ");
            scanf("%d", &id);
            editBook(id);
            break;
        default:
            printf("\nInvalid option!\n\n");
            break;
        }
    } while (1);
}

void bookDispay()
{
    int ch;
    do
    {
        messagebox("Display Book Menu");
        printf("1. All\n");
        printf("2. By Id\n");
        printf("3. By Title\n");
        printf("Enter choice [0 to exit]: ");
        scanf("%d", &ch);
        switch (ch)
        {
        case 0:
            return;
            break;
        case 1:
            displayAllBooks();
            break;
        case 2:
            int id;
            printf("Enter id: ");
            scanf("%d", &id);
            displayBook(getBookById(id));
            break;
        default:
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
    printf("\n%-5s%-30s\n", "Id", "Title");
    printline(30);
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

    while (fscanf(fp, "%d,%[^\n]", &book.id, book.title) != EOF)
    {
        if (book.id == id)
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

void displayBook(BOOK book)
{
    printf("\nId: %d\n", book.id);
    printf("Title: %s\n", book.title);
}

int getLocationById(int id)
{
    BOOK book;
    FILE *fp;
    int loc = -1;
    fp = fopen("book.csv", "r");

    while (1)
    {
        loc = ftell(fp);
        if (fscanf(fp, "%d,%[^\n]", &book.id, book.title) == EOF || book.id == id)
        {
            break;
        }
    }

    fclose(fp);
    return loc;
}

void editBook(int id)
{
    int loc = getLocationById(id);
    printf("\nloc: %d\n\n", loc);
}