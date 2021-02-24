CXX=clang++ $(CXXFLAGS)
CXXFLAGS= -Wall -O2 -std=c++11

OFILES = hashTable.o timer.o wordPuzzle.o

.SUFFIXES: .o .cpp

a.out: $(OFILES)
	$(CXX) $(DEBUG) $(OFILES)  
	@echo "Your code worked, woot!"
	
hashTable.o: hashTable.cpp hashTable.h 
	$(CXX) -c hashTable.cpp


timer.o: timer.cpp timer.h
	$(CXX) -c timer.cpp

	
wordPuzzle.o: wordPuzzle.cpp hashTable.cpp hashTable.h timer.cpp timer.h
	$(CXX) -c wordPuzzle.cpp

	
clean:
	-rm *.o a.out
