CXX=clang++ 

FILES = node.o middleearth.o traveling.o

a.out: $(FILES) 
	$(CXX) $(FILES) 
	doxygen

	
middleearth.o: middleearth.cpp middleearth.h 
	$(CXX) -c middleearth.cpp

traveling.o: traveling.cpp middleearth.cpp middleearth.h 
	$(CXX) -c traveling.cpp


node.o: node.cpp node.h
	$(CXX) -c node.cpp
	
clean:
	-rm *.o a.out 
