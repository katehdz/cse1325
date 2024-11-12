//g++ -std=c++20 -o bank bank.cpp purse.cpp OR make
#include <iostream>
#include <map>
#include <string>
#include "purse.h"

int main() {
    std::map<std::string, Purse> vault;

    int num_accounts;
    std::cout << "Welcome to Ye Olde Bank of Merry England\n\n";
    std::cout << "How many accounts? ";
    std::cin >> num_accounts;

    for (int i = 0; i < num_accounts; ++i) {
        std::string account_name;
        int pounds, shillings, pence;

        std::cout << "Name account " << i << ": ";
        std::cin.ignore();
        std::getline(std::cin, account_name);

        std::cout << "Enter your initial deposit (pounds shillings pence): ";
        std::cin >> pounds >> shillings >> pence;

        Purse account(pounds, shillings, pence);
        vault[account_name] = account;
        std::cout << "Account " << account_name << " created with " << account << "\n\n";
    }

    std::cout << "\nAccount list\n==========\n";
    Purse total;
    for (const auto& [account_name, purse] : vault) {
        std::cout << account_name << " with " << purse << "\n";
        total += purse;
    }

    std::cout << "\nTotal in bank is " << total << "\n";
    return 0;
}
