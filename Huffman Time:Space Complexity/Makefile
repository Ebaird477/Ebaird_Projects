CXX=clang++ 

ENCODEFILES = node.o heap.o huffmanenc.o timer.o

DECODEFILES = node.o heap.o huffmandec.o  timer.o

encoder: $(ENCODEFILES) huffmandec.o
	$(CXX) $(ENCODEFILES) -o encoder
	$(CXX) $(DECODEFILES) -o decoder

	
huffmanenc.o: huffmanenc.cpp heap.h heap.cpp node.h node.cpp timer.cpp timer.h
	$(CXX) -c huffmanenc.cpp

huffmandec.o: huffmandec.cpp heap.h heap.cpp node.h node.cpp timer.cpp timer.h
	$(CXX) -c huffmandec.cpp


node.o: node.cpp node.h
	$(CXX) -c node.cpp

timer.o: timer.cpp timer.h
	$(CXX) -c timer.cpp

	
heap.o: node.cpp heap.cpp node.h heap.h
	$(CXX) -c heap.cpp

	
clean:
	-rm *.o encoder decoder


