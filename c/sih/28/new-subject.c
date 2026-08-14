#include "schedule.h"

void new_subject()
{
    SUBJECT subject;
    printf("Subject Name: ");
    scanf("%[^\n]", subject.name);
    save_subject(subject);
}