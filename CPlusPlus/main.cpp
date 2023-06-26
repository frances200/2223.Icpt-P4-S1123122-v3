#include <iostream>
#include <string>
#include <vector>
#include <climits>

bool isLeap(int year){
    return year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
}

int getMaxDays(int month, int year){
    std::vector<int> maxDays {31, isLeap(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    return maxDays[month-1];
}

int getMonth(std::string month){
    std::vector<std::string> months {"januari", "februari", "maart", "april", "mei", "juni",
                                    "juli", "augustus", "september", "oktober", "november", "december"};
    for(int i = 0; i < months.size(); i++){
        if(month == months[i]){
            return i+1;
        }
    }
    return -1;
}

int main(){
    int year, day, hour, minute;
    std::string month;

    while(true){
        std::cout << "Voer het jaartal in: ";
        std::cin >> year;
        if(year > INT_MAX || year < INT_MIN){
            std::cout << "Het jaar valt buiten de grenzen van een integer. Probeer het opnieuw.\n";
        } else {
            break;
        }
    }

    while(true){
        std::cout << "Voer de maand in (uitgeschreven): ";
        std::cin >> month;
        int monthNum = getMonth(month);
        if(monthNum == -1){
            std::cout << "Ongeldige maand. Probeer het opnieuw.\n";
        } else {
            while(true){
                std::cout << "Voer de dag in: ";
                std::cin >> day;
                if(day < 1 || day > getMaxDays(monthNum, year)){
                    std::cout << "Ongeldige dag voor de gegeven maand en jaar. Probeer het opnieuw.\n";
                } else {
                    break;
                }
            }
            break;
        }
    }

    while(true){
        std::cout << "Voer het uur in: ";
        std::cin >> hour;
        if(hour < 0 || hour > 23){
            std::cout << "Ongeldig uur. Probeer het opnieuw.\n";
        } else {
            break;
        }
    }

    while(true){
        std::cout << "Voer de minuut in: ";
        std::cin >> minute;
        if(minute < 0 || minute > 59){
            std::cout << "Ongeldige minuut. Probeer het opnieuw.\n";
        } else {
            break;
        }
    }

    std::cout << "Ingevoerde datum en tijd: " << day << " " << month << " " << year << ", " << hour << ":" << minute << std::endl;
    return 0;
}
