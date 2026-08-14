#include "schedule.h"

int create_teacher()
{
    return 0;
}

int save_teacher(TEACHER teacher)
{
    MYSQL *connection = mysql_init(NULL);
    char sql[100];
    sprintf(sql, "INSERT INTO teacher(name) VALUES('%s)", teacher.name);

}