#include <stdio.h>

#define SUCCESS 0
#define FAILURE 1

typedef struct book
{
    int id;
    char title[50];
} BOOK;

typedef struct member
{
    int id;
    char name[50];
} MEMBER;

void bookMenu();
int newBook();
void displayAllBooks();
BOOK getBookById(int id);
BOOK getBookByTitle(char *title);

int newMember();