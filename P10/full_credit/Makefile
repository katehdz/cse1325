 CXXFLAGS += --std=c++20

bank: bank.o purse.o *.h
	$(CXX) $(CXXFLAGS) bank.o purse.o  -o bank

bank.o: bank.cpp *.h
	$(CXX) $(CXXFLAGS) -c bank.cpp -o bank.o

purse.o: purse.cpp *.h
	$(CXX) $(CXXFLAGS) -c purse.cpp -o purse.o

test_full_credit: test_full_credit.o purse.o *.h
	$(CXX) $(CXXFLAGS) test_full_credit.o purse.o  -o test_full_credit

test_full_credit.o: test_full_credit.cpp *.h
	$(CXX) $(CXXFLAGS) -c test_full_credit.cpp -o test_full_credit.o

all: bank test_full_credit

clean:
	-rm -f *.o *.gch *~ a.out bank test_full_credit
