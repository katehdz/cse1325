//run with g++ --std=c++17 nums.cpp 

#include <iostream>
#include <vector>
#include <string>
#include <cctype>
#include <algorithm>
#include <random>

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
	//sort
	std::sort(words.begin(), words.end());
	
	//shuffle
	std::random_device rd;
	std::default_random_engine rng(rd());
	std::shuffle(numbers.begin(), numbers.end(), rng);


	std::cout <<"Numbers (shuffled):\n";
	for(const auto& num : numbers){
		std::cout << num << std::endl;
	}

	std::cout <<"\nWords (sorted):\n";
	for (const auto& word : words){
		std::cout << word << std::endl;
	}

	return 0;
}