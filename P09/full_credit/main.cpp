#include "clock.h"
#include <iostream>
#include <cstdlib>

int main (int argc, char** argv){

    if (argc !=4) {
        std::cerr << "usage: clock <hour> <minutes> <seconds>" << std::endl;
        return -1;
    }

    try {
        int hours = std::stoi(std::string(argv[1]));
        int minutes = std::stoi(std::string(argv[2]));
        int seconds = std::stoi(std::string(argv[3]));

        Clock clock (hours, minutes,seconds);

        std::string input;
        std::cout << "Enter 'q' to quit." << std::endl <<std::endl;

        while (true){
            std::cout << "The time is now ";
            clock.print();
            std::getline(std::cin, input);
            if (input == "q") {
                break;
            }
            clock.tic();
        }
    } catch (const std::out_of_range& e){
        std::cerr << e.what() <<std::endl;
        return -2;
    }

    return 0;
}