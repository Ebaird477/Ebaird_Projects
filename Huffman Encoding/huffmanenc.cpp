
// This program shows how C-based file I/O works.  It will print a
// file to the screen two times.

// included so we can use cout
#include <iostream> 
#include <vector> 
#include <string> 
  
// stdlib.h is where exit() lives
#include <stdlib.h>
#include <map>
#include "heap.h"



using namespace std;

// include the standard I/O library
#include <stdio.h>

// we want to use parameters
int main (int argc, char **argv) {

	heap binHeap;
    // verify the correct number of parameters
    if ( argc != 2 ) {
        cout << "Must supply the input file name as the one and only parameter" << endl;
        exit(1);
    }
    // attempt to open the supplied file.  FILE is a type designed to
    // hold file pointers.  The first parameter to fopen() is the
    // filename.  The second parameter is the mode -- "r" means it
    // will read from the file.
    FILE *fp = fopen(argv[1], "r");
    // if the file wasn't found, output and error message and exit
    if ( fp == NULL ) {
        cout << "File '" << argv[1] << "' does not exist!" << endl;
        exit(2);
    }
    // read in each character, one by one.  Note that the fgetc() will
    // read in a single character from a file, and returns EOF when it
    // reaches the end of a file.

    int temp;
    int zeroCheck;
    char g;
    int charCount;
    int nodeCount;




    int ascii[128];

    for(int a = 0; a < 128; a++){
        ascii[a] = 0;
    }


    while ( (g = fgetc(fp)) != EOF ){
        temp = int(g);
        if(g > 31){
            ascii[temp]++;
            charCount++;
      }

}


    for(int c = 0; c < 128; c++){
        zeroCheck = ascii[c];
        if(zeroCheck > 0){
            node* n = new node;
            n->f = zeroCheck;
            n->val = c;
            binHeap.insert(n);
            nodeCount++;
        }


    }

    int originalBits = charCount*8;
    binHeap.consolidate();
    binHeap.report();

    binHeap.codeSet();

    // a nice pretty separator
    cout << "----------------------------------------" << endl;
    // rewinds the file pointer, so that it starts reading the file
    // again from the beginning
    rewind(fp);

    string finale;
    // read the file again, and print to the screen
    while ( (g = fgetc(fp)) != EOF )
        finale = finale + " "  + binHeap.findCode(g);
        cout << finale <<endl;

    rewind(fp);

    int finSum;
    while ( (g = fgetc(fp)) != EOF ){
        finSum = finSum + binHeap.reportFinal(g);
    }

    double compRat = double(originalBits) / double(finSum);
    double bitRat = double(finSum)/double(charCount);

    // close the file
    fclose(fp);
    cout << "----------------------------------------" << endl;

    cout<<"There are a total of  " << charCount <<" symbols that are encoded." <<endl;
    cout<<"There are "<< nodeCount <<" distinct symbols used." << endl;
    cout<<"There were "<<originalBits<<" bits in the original file." <<endl;
    cout<<"There were "<< finSum << " bits in the compressed file."<<endl;
    cout<<"This gives a compression ratio of " <<  compRat <<"." <<endl;
    cout<<"The cost of the Huffman tree is " << bitRat << " bits per character." << endl;























}
