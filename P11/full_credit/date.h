#ifndef DATE_H
#define DATE_H

#include <iostream>
#include <compare>

class Date {
private: 
	int _year;
	int _month;
	int _day;

public: 

	Date(int year = 1970, int month =1, int day =1)

	auto operator<=>(const Date&) const = default;

	friend std::ostream& operator<<(std::ostream& ost, const Date& date) 
};

#endif