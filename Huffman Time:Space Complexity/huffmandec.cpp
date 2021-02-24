

// This program is the skeleton code for the lab 10 in-lab.  It uses
// C++ streams for the file input, and just prints out the data when
// read in from the file.

#include <iostream>
#include <fstream>
#include <sstream>
#include <stdlib.h>
#include <vector>
#include <string>
#include "node.h"
#include "timer.h"
using namespace std;

void insert(node* ptr, int ascii, string path) {
 
 if(path.length() == 0) {
    ptr->val = ascii;
    //cout << "Node created and inserted! " << char(ascii) << endl;
  }

    if(path[0] == '0') {
        if(ptr->left == NULL) {
            node* leftNode = new node;
            ptr->left = leftNode;
            leftNode->val = 0;
        }

    insert(ptr->left, ascii, path.substr(1, path.length()-1));
  }
    if(path[0] == '1') {
        if(ptr->right == NULL) {
            node* rightNode = new node;
            ptr->right = rightNode;
            rightNode->val = 0;
        }

    insert(ptr->right, ascii, path.substr(1, path.length()-1));
  }
  
}


int report(node* ptr, string path) {
    if(path.length() == 0) {
        int ans = ptr->val;
        //cout << "REPORT: found " << ans << endl; 

        return ans;
    }
    //cout << "REPORT: Looking for " << path << endl; 

    if(path[0] == '0') {
    return report(ptr->left, path.substr(1, path.length()-1));

    }

    if(path[0] == '1') {

    return report(ptr->right, path.substr(1, path.length()-1));

    }

}

// main(): we want to use parameters
int main (int argc, char **argv) {

    timer j;
    j.start();

    node* base = new node;
    node* root = new node;
    int asciiVal;

    root = base;
    // verify the correct number of parameters
    if ( argc != 2 ) {
        cout << "Must supply the input file name as the only parameter" << endl;
        exit(1);
    }
    // attempt to open the supplied file; must be opened in binary
    // mode, as otherwise whitespace is discarded
    ifstream file(argv[1], ifstream::binary);
    // report any problems opening the file and then exit
    if ( !file.is_open() ) {
        cout << "Unable to open file '" << argv[1] << "'." << endl;
        exit(2);
    }
    // read in the first section of the file: the prefix codes
    while ( true ) {
        string character, prefix;
        // read in the first token on the line
        file >> character;
        // did we hit the separator?
        if ( (character[0] == '-') && (character.length() > 1) )
            break;
        // check for space
        if ( character == "space" )
            character = " ";
        // read in the prefix code
        file >> prefix;
        // do something with the prefix code


        char firstChar = character[0];
        asciiVal = firstChar;

        insert(root, asciiVal, prefix);



    }

    int target = 0;
    char targetConv = '0';
    // read in the second section of the file: the encoded message
    stringstream sstm;
    while ( true ) {
        string bits;
        // read in the next set of 1's and 0's
        file >> bits; // string
        // check for the separator
        if ( bits[0] == '-' )
            break;
        // add it to the stringstream
        target = report(root, bits);
        targetConv = char(target);
       // cout << "Target reached: " << targetConv << endl;
        sstm << targetConv;
    }
    string allbits = sstm.str();
    // at this point, all the bits are in the 'allbits' string
    cout << endl<< endl << endl << allbits << endl;
    j.stop();
    //cout << "Time Taken: " <<  j.getTime() << endl;
    // close the file before exiting
    file.close();
}





