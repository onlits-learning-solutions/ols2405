#include "schedule.h"

int main(int argc, char const *argv[])
{
    int id = 1;
    SUBJECT subject;

    if(argc <=1)
    {
        printf("Too few arguments!\n");
        return 1;
    }
    strcpy(subject.name, argv[1]);
    create_subject(subject);
    
    printf("Fetched record # %d:\n", id);
    read_all_subjects();
    return 0;
}