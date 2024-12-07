#include <stdio.h>
int main(int argc, char const *argv[])
{
    char ch;
    FILE *fp;
    fp = fopen("quotes.txt", "w");
    printf("Write a quote below:\n");
    while((ch = getchar()) != EOF)
    {
        putc(ch, fp);
    }
    fclose(fp);
    return 0;
}
