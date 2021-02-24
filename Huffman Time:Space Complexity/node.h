#ifndef NODE_H
#define NODE_H
#include <string>
#include <iostream>

using namespace std;

class node {
  public: 
  node();
  ~node();

  int f;
  int val;
  string code;

  node* left;
  node* right;

  friend class heap;
  friend class huffmanec;
};

#endif