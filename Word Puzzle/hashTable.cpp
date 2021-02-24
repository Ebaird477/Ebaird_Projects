#include <iostream>
#include <string>
#include <fstream>
#include <vector>
#include <time.h>
#include <sys/time.h>
#include "hashTable.h"

hashTable::hashTable(int x){

	size = getNextPrime(x * 2);


	table.resize(size);

	for(int y = 0; y < size; y++ ){

		table.at(y) = "?";

	}



}

bool hashTable::find(string val){

unsigned int conVar = convert(val);


if(table.at(conVar) == "?"){
		return false;
	}
	else{
		while(table.at(conVar) != "?" && conVar != size){
			if(table.at(conVar) == val){
				return true;
			}
			conVar++;
		}

		return false;
	}


}


void hashTable::insert(string val){


	if(val.length() < 3){
		return;
	}

	unsigned int conVar = convert(val);

	if(table.at(conVar) == val){
		return;
	}

	else if(table.at(conVar) == "?"){
		table.at(conVar) = val;
	}

	else{
		while(table.at(conVar)!= "?"){
			conVar++;
		}


		table.at(conVar) = val;
	}

	return;

}


unsigned int hashTable::convert(string val){

	unsigned int output = 0;

	for(int i = 0; i < val.length(); i++){

		output = (output + (unsigned int)val[i]) * (37 * (37 * i));

}

	output = output % size;



	return output;
}

bool hashTable::checkPrime(unsigned int p) {
    if ( p <= 1 ) // 0 and 1 are not primes; the are both special cases
        return false;
    if ( p == 2 ) // 2 is prime
        return true;
    if ( p % 2 == 0 ) // even numbers other than 2 are not prime
        return false;
    for ( int i = 3; i*i <= p; i += 2 ) // only go up to the sqrt of p
        if ( p % i == 0 )
            return false;
    return true;
}

int hashTable::getNextPrime (unsigned int n) {
    while ( !checkPrime(++n) );
    return n; // all your primes are belong to us
}
