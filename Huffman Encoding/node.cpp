#include "node.h"
#include <string>
#include <iostream>
using namespace std;

node::node() {
  int f = 0;
  int val = 0;
  string code;
  left = NULL;
  right = NULL;
}

node::~node() {
  delete left;
  delete right;
  left = NULL;
  right = NULL;
}