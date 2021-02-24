
#ifndef HEAP_H
#define HEAP_H


#include <vector>
#include <map>
#include "node.h"
using namespace std;

class heap {


public:
    heap();
    heap(vector<node*> vec);
    ~heap();

    void codeSet();
    void codeList(node* ptr, string x);
    void report();
    node* newNode(node* smallest, node* secondSmallest);
    void consolidate();
    void insert(node* x);
    node* first();
    string findCode(char g);

    int reportFinal(char g);


    node* findMin();
    node* deleteMin();
    unsigned int size();
    void makeEmpty();
    void shift();
    bool isEmpty();
    void print();

private:
    map<char, string> key;
    vector<node*> table;
    unsigned int heap_size;

    void percolateUp(int hole);
    void percolateDown(int hole);
};

#endif