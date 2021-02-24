CXX=clang++ $(CXXFLAGS)
CXXFLAGS= -Wall 

OFILES = node.o heap.o huffmanenc.o 

.SUFFIXES: .o .cpp

a.out: $(OFILES)
	$(CXX) $(DEBUG) $(OFILES)  
	@echo "Your code worked, woot!"
	
huffmanenc.o: huffmanenc.cpp heap.h heap.cpp node.h node.cpp
	$(CXX) -c huffmanenc.cpp


node.o: node.cpp node.h
	$(CXX) -c node.cpp

	
heap.o: node.cpp heap.cpp node.h heap.h
	$(CXX) -c heap.cpp

	
clean:
	-rm *.o a.out

