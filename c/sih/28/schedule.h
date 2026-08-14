#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <mysql.h>

typedef struct subject
{
    int subject_id;
    char name[50];
} SUBJECT;

typedef struct teacher
{
    int teacher_id;
    char name[50];
} TEACHER;

typedef struct batch
{
    int batch_id;

} BATCH;

typedef struct slot
{
    int id;
    BATCH batch;
    TEACHER teacher;
    SUBJECT subject;
} SLOT;

typedef struct schedule
{
    SLOT *slots;
    int num_slots;
} SCHEDULE;

/*-------------------------- schedule_controller ------------------------*/
int create_subject();
int save_subject(SUBJECT subject);
SUBJECT read_one_subject(int id);
SUBJECT *read_all_subjects(void);

/*----------------------------- views ----------------------------------*/
void new_subject();