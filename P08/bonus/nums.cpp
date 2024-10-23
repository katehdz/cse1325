//run with g++ --std=c++17 nums.cpp 

#include <iostream>
#include <vector>
#include <string>
#include <cctype>

int main (int argc, char* argv[]){
	std::vector<std::string> numbers;
	std::vector<std::string> words;

	for (int i=1; i<argc; i++){
		std::string arg = argv[i];
		if (std::isdigit(arg[0])){
			numbers.push_back(arg);
		} else {
			words.push_back(arg);
		}
	}

	std::cout <<"Numbers:\n";
	for(const auto& num : numbers){
		std::cout << num << std::endl;
	}

	std::cout <<"\nWords:\n";
	for (const auto& word : words){
		std::cout << word << std::endl;
	}

	return 0;
}