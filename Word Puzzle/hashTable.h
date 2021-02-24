
#ifndef HASHTABLE_H
#define HASHTABLE_H

#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <time.h>
#include <sys/time.h>

using namespace std;

class hashTable {
    int size;

   

    struct node{
        string value;
        int convertValue;

    };


public:

    hashTable(int x);

    void insert(string val);
    unsigned int convert(string val);
    bool find(string val);
    bool checkPrime(unsigned int p);
    int getNextPrime(unsigned int n);

private:
vector<string> table;



};


    


#endif
