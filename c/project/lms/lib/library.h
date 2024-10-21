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

int newBook();
BOOK getBookById(int id);
BOOK getBookByTitle(char *title);

int newMember();