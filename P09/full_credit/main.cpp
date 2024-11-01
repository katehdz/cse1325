#include "clock.h"
#include <iostream>
#include <cstdlib>

int main (int argc, char** argv[]){

    if (argc !=4) {
        std::cerr << "usage: clock <hour> <minutes> <seconds>" << std:endl;
        return -1;
    }
}