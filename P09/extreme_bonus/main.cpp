#include "timer.h"
#include <iostream>
#include <cstdlib>

int main (int argc, char** argv){

    if (argc !=4) {
        std::cerr << "usage: timer <hour> <minutes> <seconds>" << std::endl;
        return -1;
    }

    try {
        int hours = std::stoi(std::string(argv[1]));
        int minutes = std::stoi(std::string(argv[2]));
        int seconds = std::stoi(std::string(argv[3]));

        Timer timer (hours, minutes,seconds);

        std::string input;
        std::cout << "Enter 'q' to quit." << std::endl <<std::endl;

        while (true){
            std::cout << "Remaining time is now ";
            timer.print();
            std::getline(std::cin, input);
            if (input == "q") {
                break;
            }
            timer.tic();
        }
    } catch (const std::out_of_range& e){
        std::cerr << e.what() <<std::endl;
        return -2;
    } catch (const std::runtime_error& e) {
        std::cout << e.what() << std::endl; 
    }


    return 0;
}