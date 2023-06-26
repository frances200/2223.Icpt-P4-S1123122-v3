#include <stdio.h>

void convertSeconds(int seconds)
{
    int years, months, days, hours, minutes;

    years = seconds / (365 * 24 * 60 * 60);
    seconds %= (365 * 24 * 60 * 60);

    months = seconds / (30 * 24 * 60 * 60);
    seconds %= (30 * 24 * 60 * 60);

    days = seconds / (24 * 60 * 60);
    seconds %= (24 * 60 * 60);

    hours = seconds / (60 * 60);
    seconds %= (60 * 60);

    minutes = seconds / 60;
    seconds %= 60;

    printf("%d jaar, %d %s, %d %s, %d %s, %d %s en %d %s.\n",
           years,
           months,
           (months == 1) ? "maand" : "maanden",
           days,
           (days == 1) ? "dag" : "dagen",
           hours,
           (hours == 1) ? "uur" : "uren",
           minutes,
           (minutes == 1) ? "minuut" : "minuten",
           seconds,
           (seconds == 1) ? "seconde" : "seconden");
}

int main()
{
    int input;

    printf("Voer een aantal seconden in: ");
    scanf("%d", &input);
 
    convertSeconds(input);

    return 0;
}
