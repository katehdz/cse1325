CXXFLAGS += --std=c++20
main: main.o clock.o *.h
	$(CXX) $(CXXFLAGS) main.o clock.o -o clock
main.o: main.cpp *.h
	$(CXX) $(CXXFLAGS) -c main.cpp -o main.o
clock.o: clock.cpp *.h
	$(CXX) $(CXXFLAGS) -c clock.cpp -o clock.o
clean:
	-rm -f *.o *.gch *~ a.out clock