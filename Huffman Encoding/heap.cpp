#include <iostream>
#include <string>
#include <vector>
#include <map>
#include <iostream>
#include "heap.h"
#include "node.h"
using namespace std;

// default constructor
heap::heap() : heap_size(0) {
    table.push_back(0);
}

// builds a heap from an unsorted vector
heap::heap(vector<node*> vec) : heap_size(vec.size()) {
    table = vec;
    table.push_back(table[0]);
    table[0] = 0;
    for ( int i = heap_size/2; i > 0; i-- )
        percolateDown(i);
}

// the destructor doesn't need to do much
heap::~heap() {

}

int heap::reportFinal(char g){
    if(key.count(g) == 1){
        string coded = key.at(g);
        int len = coded.length();
        return len;
    }

    return 0;

}


string heap::findCode(char g) {

    if(key.count(g) == 1){
         return key.at(g);
    }

    return "";


}


void heap::codeSet(){
    node* test = table.at(1);
    codeList(test, "");
}

void heap::codeList(node* ptr, string x) {


    if (ptr->left==NULL && ptr->right==NULL){

        ptr->code = x;
        char insertChar = char(ptr->val);

        key.insert(std::make_pair(insertChar, x));
        if(insertChar == ' '){
           cout << "space" << "  " << x << endl;
        }
        else{
            cout << char(ptr->val) << "  " << x << endl;

        }

        }

    if (ptr->left != NULL){
        node* n = new node;
        n = ptr->left;

        codeList(n, x + "0");

        }


    if (ptr->right != NULL) {
        node* n = new node;
        n = ptr->right;

        codeList(n, x + "1");

        }
}



void heap::consolidate() {
    report();
    while(table.size() > 2){
        shift();
        node* smallest = table.back();
        table.pop_back();
        node* secondSmallest = table.back();
        table.pop_back();

        //cout << "Smallest: " << smallest->f << " Val: " << char(smallest->val) << "   secondSmallest: " << secondSmallest->f << " Val: " << char(secondSmallest->val) <<endl;


        node* consolidated = newNode(smallest, secondSmallest);
        //cout << "Current Table Size: " << table.size() << endl;
        table.push_back(consolidated);
    }
    return;
}


node* heap::newNode(node* smallest, node* secondSmallest) {
  int num = smallest->f;
  int num2 = secondSmallest->f;
  int sum = num + num2;
  node* n = new node;
  n->val = 0;
  n->f = sum;
  n->left = smallest;
  n->right = secondSmallest;

//cout << "Smallest: " << n->left->f << " Val: " << char(smallest->val) << "   secondSmallest: " << n->right->f << " Val: " << char(secondSmallest->val) <<endl;

  return n;
}

void heap::report() {
    // a vector push_back will resize as necessary
    int it = 1;

    while(it < table.size()){
        node* n =table[it];
        //cout <<"REPORTING: Position: "<< it << " Frequency: " << n->f << " Value: " << char(n->val) <<endl;
        it++; 

    }
}


void heap::insert(node* x) {
    // a vector push_back will resize as necessary
    table.push_back(x);
    shift();
}



void heap::shift() {

    for(int e = 1; e < table.size(); e++){
        for(int e2 = 1; e2 < table.size(); e2++){
            node* x = table[e2]; // Grab node
            int xFre = x->f;
            int check = e2 + 1;

            if(check < table.size()){

                node* y = table[check]; // Grab node
                int yFre = y->f;

                if(xFre < yFre){
                    table[e2] = y;
                    table[check] = x;
                }
            }
        }
    }




    
}

node* heap::deleteMin() {
    // make sure the heap is not empty
    if ( heap_size == 0 )
        throw "deleteMin() called on empty heap";
    // save the value to be returned
    node* ret = table.at(1);
    // move the last inserted position into the root
    table.at(1) = table[heap_size--];
    // make sure the vector knows that there is one less element
    table.pop_back();
    // percolate the root down to the proper position
    percolateDown(1);
    // return the old root node
    return ret;
}

void heap::percolateDown(int hole) {
    // get the value to percolate down
    int x = table[hole]->f;
    // while there is a left child...
    while ( hole*2 <= heap_size ) {
        int child = hole*2; // the left child
        // is there a right child?  if so, is it lesser?
        if ( (child+1 <= heap_size) && (table[child+1]->f < table[child]->f) )
            child++;
        // if the child is greater than the node...
        if ( x > table[child]->f ) {
            table[hole] = table[child]; // move child up
            hole = child;             // move hole down
        } else
            break;
    }
    // correct position found!  insert at that spot
    table[hole]->f = x;
}

node* heap::findMin() {
    if ( heap_size == 0 )
        throw "findMin() called on empty heap";
    return table.at(1);
}

unsigned int heap::size() {
    return heap_size;
}

void heap::makeEmpty() {
    heap_size = 0;
    table.resize(1);
}

bool heap::isEmpty() {
    return heap_size == 0;
}

void heap::print() {
    cout << "(" << table[0] << ") ";
    for ( int i = 1; i <= heap_size; i++ ) {
        cout << table[i]->f << " ";
        // next line from http://tinyurl.com/mf9tbgm
        bool isPow2 = (((i+1) & ~(i))==(i+1))? i+1 : 0;
        if ( isPow2 )
            cout << endl << "\t";
    }
    cout << endl;
}



