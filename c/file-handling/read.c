#include <stdio.h>

int main(int argc, char const *argv[])
{
    char ch;
    FILE *fp;
    fp = fopen("quotes.txt", "r");
    printf("The file contains following text:\n");
    while((ch = getc(fp)) != EOF)
    {
        putchar(ch);
    }
    fclose(fp);
    return 0;
}
