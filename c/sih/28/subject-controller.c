#include "schedule.h"

int create_subject()
{
    new_subject();
    return 0;
}

int save_subject(SUBJECT subject)
{
    MYSQL *connection = mysql_init(NULL);
    char sql[100];
    sprintf(sql, "INSERT INTO subject(name) VALUES('%s')", subject.name);

    if (!mysql_real_connect(connection, "localhost", "ols2405", "ols2405", "schedule_2405", 0, NULL, 0))
    {
        fprintf(stderr, "%s\n", mysql_error(connection));
    }
    if (!mysql_query(connection, sql))
        printf("Subject Created!\n");
    else
        fprintf(stderr, "%s\n", mysql_error(connection));

    mysql_close(connection);
    return 0;
}

SUBJECT read_one_subject(int id)
{
    SUBJECT subject;
    char sql[100];
    sprintf(sql, "SELECT * FROM subject WHERE id=%d", id);
    MYSQL *connection = mysql_init(NULL);
    if (!mysql_real_connect(connection, "localhost", "ols2405", "ols2405", "schedule_2405", 0, NULL, 0))
    {
        fprintf(stderr, "%s\n", mysql_error(connection));
    }
    if (!mysql_query(connection, sql))
    {
        MYSQL_RES *result = mysql_use_result(connection);
        MYSQL_ROW row;
        row = mysql_fetch_row(result);
        subject.subject_id = atoi(row[0]);
        strcpy(subject.name, row[1]);
    }
    else
    {
        fprintf(stderr, "%s\n", mysql_error(connection));
    }
    mysql_close(connection);
    return subject;
}

SUBJECT *read_all_subjects(void)
{
    SUBJECT subject;
    MYSQL *connection = mysql_init(NULL);
    char sql[100];
    sprintf(sql, "SELECT * FROM subject");
    if (!mysql_real_connect(connection, "localhost", "ols2405", "ols2405", "schedule_2405", 0, NULL, 0))
    {
        fprintf(stderr, "%s\n", mysql_error(connection));
    }

    if (!mysql_query(connection, sql))
    {
        MYSQL_RES *result = mysql_use_result(connection);
        MYSQL_ROW row;
        printf("%-10s%s\n", "Id", "Name");
        while (row = mysql_fetch_row(result))
        {
            printf("%-10d%s\n", atoi(row[0]), row[1]);
        }
    }
    else
    {
        fprintf(stderr, "%s\n", mysql_error(connection));
    }
    mysql_close(connection);
    printf("All is well!\n");
}