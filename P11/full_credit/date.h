#ifndef DATE_H
#define DATE_H

#include <iostream>
#include <compare>
#include <iomanip>

class Date {
private: 
	int _year;
	int _month;
	int _day;

public: 

	Date(int year = 1970, int month =1, int day =1)
		:_year(year), _month(month), _day(day) {}

	auto operator<=>(const Date&) const = default;

	friend std::ostream& operator<<(std::ostream& ost, const Date& date) {
	    char old_fill = ost.fill('0');
	    ost << std::setw(4) << date._year << "/"
	        << std::setw(2) << date._month << "/"
	        << std::setw(2) << date._day;
	    ost.fill(old_fill); // Restore the fill character
	    return ost;
	}
};

#endif