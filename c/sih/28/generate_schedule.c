#include "schedule.h"

SCHEDULE *generate_schedule(int num_slots)
{
    SCHEDULE *schedule = (SCHEDULE *)malloc(sizeof(SCHEDULE));
    schedule->num_slots = num_slots;
    schedule->slots = (SLOT *)malloc(num_slots * sizeof(SLOT));
    return schedule;
}

