#include <iostream>
#include <stdexcept>
#include <iomanip>

class Clock {
private:
    int _hours;
    int _minutes;
    int _seconds;
public:
    Clock(int hours, int minutes, int seconds);
    virtual ~Clock() = default;
    void tic();
    void print() const;
};
