CXX=clang++ $(CXXFLAGS)
CXXFLAGS= -Wall 

OFILES = node.o  huffmandec.o 

.SUFFIXES: .o .cpp

a.out: $(OFILES)
	$(CXX) $(DEBUG) $(OFILES)  
	@echo "Your code worked, woot!"
	
huffmanenc.o: huffmandec.cpp node.h node.cpp
	$(CXX) -c huffmandec.cpp


node.o: node.cpp node.h
	$(CXX) -c node.cpp

	
clean:
	-rm *.o a.out

