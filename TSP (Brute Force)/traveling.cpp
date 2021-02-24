#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <algorithm>

using namespace std;

#include "middleearth.h"

float computeDistance (MiddleEarth &me, string start, vector<string> dests);
void printRoute (string start, vector<string> dests);

int main (int argc, char **argv) {
    // check the number of parameters
    if ( argc != 6 ) {
        cout << "Usage: " << argv[0] << " <world_height> <world_width> "
             << "<num_cities> <random_seed> <cities_to_visit>" << endl;
        exit(0);
    }
    // we'll assume the parameters are all well-formed
    int width, height, num_cities, rand_seed, cities_to_visit;
    sscanf (argv[1], "%d", &width);
    sscanf (argv[2], "%d", &height);
    sscanf (argv[3], "%d", &num_cities);
    sscanf (argv[4], "%d", &rand_seed);
    sscanf (argv[5], "%d", &cities_to_visit);
    // Create the world, and select your itinerary
    MiddleEarth me(width, height, num_cities, rand_seed);
    vector<string> dests = me.getItinerary(cities_to_visit);

    // holds the first spot
    string base = dests[0];

    //replaces the vector with the proper, sorted vector
    vector<string> final = dests;

    //initializes the permutation distance float value
    float permutation = 0.0;

    //initializes the dynamic minimum value. 
    float currMin = computeDistance(me, base, dests);
    
    sort(dests.begin()+1, dests.end());
    while(next_permutation(dests.begin()+1, dests.end())) {
      

      permutation = computeDistance(me, base, dests);
      

      if(permutation < currMin) {
            currMin = permutation;
            final = dests;
      }

    }

    string baseFin = final[0];

    printRoute(baseFin, final);
    cout << "The distance in this route " << currMin << endl << endl;

    return 0;
}



/**@brief This computes the distance for each vector it is given. 
 * 
 * @return the final calculated distance
 *
 * @param start This is the povided base. 
 * @param me This is my middleearth
 * @param dests this is the list of vectors
 */

// This method will compute the full distance of the cycle that starts
// at the 'start' parameter, goes to each of the cities in the dests
// vector IN ORDER, and ends back at the 'start' parameter.
float computeDistance (MiddleEarth &me, string start, vector<string> dests) {
    float ans = 0.0;

    for(int i = 0; i < dests.size(); i++) {
        ans = ans + me.getDistance(start, dests[i]);
        start = dests[i];
    }
  
    ans = ans + me.getDistance(dests[0], dests[dests.size() - 1]);
  
  return ans;
}


/**@brief This prints out the sorted vector 
 * 
 * @return a cout strand of cities. 
 *
 * @param start This is the povided base. 
 * @param dests this is the sorted list of vectors
 */
// This method will print the entire route, starting and ending at the
// 'start' parameter.  The output should be of the form:
// Erebor -> Khazad-dum -> Michel Delving -> Bree -> Cirith Ungol -> Erebor
void printRoute (string start, vector<string> dests) {

    cout << endl << "Your journey entails the following route: " << endl << endl;
    for(int i = 0; i < dests.size(); i++) {
        if(i + 1 == dests.size()){
            cout << dests[i] << " -> " << start << endl << endl;
            break;
        }
        cout << dests[i] << " -> ";
    }


}



