CXXFLAGS += --std=c++17

all: hello hello_all

hello: hello.cpp
    $(CXX) $(CXXFLAGS) hello.cpp -o hello

hello_all: hello_all.cpp
    $(CXX) $(CXXFLAGS) hello_all.cpp -o hello_all

clean:
    -rm -f *.o *.gch *~ a.out hello hello_all
