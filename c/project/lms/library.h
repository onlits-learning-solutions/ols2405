#include <stdio.h>
#include <string.h>

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

// ---------------- utility --------------------
void printline(int n);
void messagebox(char *message);

// ---------------- book module ----------------
void bookMenu();
void bookDispay();
int newBook();
void displayAllBooks();
BOOK getBookById(int id);
BOOK getBookByTitle(char *title);
void displayBook(BOOK book);
int getLocationById(int id);
void editBook(int id);

// --------------- member module ---------------
int newMember();