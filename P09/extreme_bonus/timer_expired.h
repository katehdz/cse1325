#include <stdexcept>
#include <string>

class Timer_expired : public std::runtime_error {
public: 
	Timer_expired() : std::runtime_error("Timer expired") {}
};